package ru.javarush.quest.kolontsov.servlet;

import ru.javarush.quest.kolontsov.entity.Question;
import ru.javarush.quest.kolontsov.entity.Statistic;
import ru.javarush.quest.kolontsov.model.Model;
import ru.javarush.quest.kolontsov.util.Go;
import ru.javarush.quest.kolontsov.util.Jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@WebServlet(name = "WinServlet", value = "/win")
public class WinServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = Model.getInstance();
        Question question = (Question) request.getAttribute("question");
        //Statistic statistic = (Statistic) request.getSession().getAttribute("statistic");
        Statistic statistic = Statistic.builder()
                .dateTime(Statistic.currentTime( new Date(System.currentTimeMillis())))
                .lastQuestion(question)
                .result("Выигрыш")
                .build();

        model.add(statistic);

        Jsp.show(request, response, Go.WIN);
    }
}
