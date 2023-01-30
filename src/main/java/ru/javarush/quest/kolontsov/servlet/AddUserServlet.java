package ru.javarush.quest.kolontsov.servlet;

import ru.javarush.quest.kolontsov.entity.User;
import ru.javarush.quest.kolontsov.repository.Repo;
import ru.javarush.quest.kolontsov.util.Go;
import ru.javarush.quest.kolontsov.util.Ids;
import ru.javarush.quest.kolontsov.util.Jsp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "AddUserServlet", value = Go.ADDUSER)
public class AddUserServlet extends HttpServlet {
    User user;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("title", Go.AddUserTitle);
        Jsp.show(request, response, Go.ADDUSER);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = User.builder()
                .id(++Ids.userId)
                .login(login)
                .password(password)
                .build();
        Repo users = Repo.getInstance();
        users.add(user);

        HttpSession session = request.getSession();
        session.setAttribute("userId", user.getId()); // запомнить пользователя в сессии
        session.setAttribute("login", login);
        request.setAttribute("login", login);

        doGet(request, response);
    }
}//TODO d  addUser.jsp первый 2 строчки почему-то серые - это нормально? и web.xml там тоже вопросики
