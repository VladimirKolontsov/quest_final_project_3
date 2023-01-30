package ru.javarush.quest.kolontsov.servlet;

import ru.javarush.quest.kolontsov.util.Go;
import ru.javarush.quest.kolontsov.util.Jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "MainServlet", value = {Go.ROOT, Go.MAIN})
public class MainServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", Go.mainTitle);
        Jsp.show(request, response, Go.MAIN);
    }
}
