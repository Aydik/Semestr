package ru.itis.inf301.semestr.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.inf301.semestr.model.Pizza;
import ru.itis.inf301.semestr.service.PizzaService;

import java.io.IOException;
import java.util.List;

@WebServlet("")
public class IndexPageServlet extends HttpServlet {
    private final PizzaService pizzaService = new PizzaService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Pizza> pizzas = pizzaService.findAll();
            for (Pizza pizza : pizzas) {
                System.out.println(pizza.getName() + " " + pizza.getPrice() + " " + pizza.getPhoto());
            }
            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }


    }

}