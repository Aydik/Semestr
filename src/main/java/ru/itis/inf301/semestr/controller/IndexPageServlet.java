package ru.itis.inf301.semestr.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("")
public class IndexPageServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try{
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }


    }

}