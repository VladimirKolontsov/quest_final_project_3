package ru.javarush.quest.kolontsov.servlet;

import ru.javarush.quest.kolontsov.model.Model;
import ru.javarush.quest.kolontsov.util.Go;
import ru.javarush.quest.kolontsov.util.Jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "statListServlet", value = Go.STATISTIC)
public class StatisticServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Model model = Model.getInstance();
        List<String> statistics = model.list();
        request.setAttribute("title", Go.statisticTitle);
        request.setAttribute("statistics", statistics);
        Jsp.show(request, response, Go.STATISTIC);
    }
}
