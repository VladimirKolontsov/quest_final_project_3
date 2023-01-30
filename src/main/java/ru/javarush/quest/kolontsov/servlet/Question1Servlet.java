package ru.javarush.quest.kolontsov.servlet;

import ru.javarush.quest.kolontsov.entity.Answer;
import ru.javarush.quest.kolontsov.entity.Question;
import ru.javarush.quest.kolontsov.entity.Statistic;
import ru.javarush.quest.kolontsov.util.Go;
import ru.javarush.quest.kolontsov.util.Jsp;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Question1Servlet", value = Go.QUESTION1)
public class Question1Servlet extends HttpServlet {
    Question question;
    ArrayList<Answer> answerArrayList = new ArrayList<>();
    Statistic statistic;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        int id = 0;
        answerArrayList.add(Answer.builder()
                .id(String.valueOf(id++))
                .text("Принять вызов")
                .build());
        answerArrayList.add(Answer.builder()
                .id(String.valueOf(id))
                .text("Отклонить вызов")
                .build());

        question = Question.builder()
                .title("Вопрос1")
                .fabula("Ты потерял память...")
                .text("Принять вызов НЛО?")
                .loosMessage("Ты отклонил вызов.")
                .answers(answerArrayList)
                .answerPath(new String[]{Go.QUESTION2, Go.LOOS})
                .build();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("question", question);
        //request.getSession().setAttribute("statistic", statistic);
        Jsp.show(request, response, Go.QUESTION1);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String answerText = request.getParameter("answer");
        int answer = Integer.parseInt(answerText);
        question.setSubmitAnswerIndex(Integer.parseInt(answerText));  // Запомнить полученный ответ в вопросе

        // Куда пойдём дальше?
        String url = question.getAnswerPath()[answer];
        request.setAttribute("url", url);
        Jsp.redirect(request, response, url);

    }
}
