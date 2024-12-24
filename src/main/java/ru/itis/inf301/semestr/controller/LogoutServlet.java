package ru.itis.inf301.semestr.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            HttpSession session = request.getSession(false);
            session.invalidate();
            response.sendRedirect("/");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

}