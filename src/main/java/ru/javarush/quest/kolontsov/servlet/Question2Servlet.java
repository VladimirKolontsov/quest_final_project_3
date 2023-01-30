package ru.javarush.quest.kolontsov.servlet;

import ru.javarush.quest.kolontsov.entity.Answer;
import ru.javarush.quest.kolontsov.entity.Question;
import ru.javarush.quest.kolontsov.util.Go;
import ru.javarush.quest.kolontsov.util.Jsp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "Question2Servlet", value = "/question2")
public class Question2Servlet extends HttpServlet {
    Question question;
    ArrayList<Answer> answerArrayList = new ArrayList<>();

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        int id = 0;
        answerArrayList.add(Answer.builder()
                .id(String.valueOf(id++))
                .text("Подняться на мостик")
                .build());
        answerArrayList.add(Answer.builder()
                .id(String.valueOf(id))
                .text("Отказаться подниматься на мостик")
                .build());

        question = Question.builder()
                .title("Вопрос2")
                .fabula("Ты принял вызов.")
                .text("Поднимаешься на мостик к капитану?")
                .loosMessage("Ты не пошёл на переговоры.")
                .viewAddress("WEB-INF/views/question2.jsp")
                .answers(answerArrayList)
                .answerPath(new String[]{Go.QUESTION3, Go.LOOS})
                .build();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("question", question);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(question.getViewAddress());
        requestDispatcher.forward(request, response);
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
