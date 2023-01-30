package ru.javarush.quest.kolontsov.util;

import lombok.experimental.UtilityClass;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@UtilityClass
public class Jsp {
    public void show(HttpServletRequest req, HttpServletResponse resp, String uri)
            throws ServletException, IOException {
        String path = "WEB-INF/views" + uri + ".jsp";
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(path);
        requestDispatcher.forward(req, resp);
    }

    public void redirect(HttpServletRequest req, HttpServletResponse resp, String uri)
            throws IOException {
        resp.sendRedirect(req.getContextPath() + uri);
    }
}
