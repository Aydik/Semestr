package ru.itis.inf301.semestr.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import ru.itis.inf301.semestr.service.UserService;
import ru.itis.inf301.semestr.model.User;
import ru.itis.inf301.semestr.bcrypt.PasswordSecurity;

@WebServlet("/login")
public class LoginPageServlet extends HttpServlet {
    private final UserService userService = new UserService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            boolean access = false;
            User user = userService.findByName(username);
            if (user != null) {
                access = PasswordSecurity.checkPassword(password, user.getPassword());
            }

            if (access) {
                HttpSession session = request.getSession();
                session.setAttribute("user", username);
                response.sendRedirect("/");
            } else {
                request.setAttribute("error", "Неверное имя пользователя или пароль");
                doGet(request, response);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {

        try {
            HttpSession session = request.getSession(false);
            if (session != null) System.out.println(session.getAttribute("user"));
            request.getRequestDispatcher("jsp/login.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

}
