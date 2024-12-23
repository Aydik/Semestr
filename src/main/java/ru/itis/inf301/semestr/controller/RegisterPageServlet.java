package ru.itis.inf301.semestr.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import ru.itis.inf301.semestr.model.User;
import ru.itis.inf301.semestr.service.UserService;
import ru.itis.inf301.semestr.bcrypt.PasswordSecurity;

@WebServlet("/register")
public class RegisterPageServlet extends HttpServlet {
    private final UserService userService = new UserService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            String username = request.getParameter("username");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            String password_copy = request.getParameter("password_copy");

            String error = validateData(username, phone, password, password_copy);

            if (error == null) {
                HttpSession session = request.getSession();
                session.setAttribute("id", userService.findByName(username));
                session.setAttribute("user", username);
                response.sendRedirect("/");
            } else {
                request.setAttribute("error", error);
                doGet(request, response);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("jsp/register.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String validateData(String username, String phone, String password, String password_copy) {
        if (username.length() < 4) return "Минимальная длина логина - 4 символа";
        if(userService.findByName(username) != null) return "Имя пользователя занято";
        String phone_new = phone.replaceAll("[^0-9]", "");
        if (phone_new.length() != 11 || phone_new.charAt(0) != '7' || phone_new.charAt(1) != '9')
            return "Номер телефона указан неверно";
        if (password.length() < 8) return "Минимальная длина пароля - 8 символов";
        if (!password.equals(password_copy)) return "Пароли не совпадают";

        User user = new User();
        user.setUsername(username);
        user.setPhone(phone_new);
        user.setPassword(PasswordSecurity.hashPassword(password));
        userService.addUser(user);

        return null;
    }

}
