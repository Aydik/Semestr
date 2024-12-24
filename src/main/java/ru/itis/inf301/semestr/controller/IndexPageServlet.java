package ru.itis.inf301.semestr.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.inf301.semestr.model.Pizza;
import ru.itis.inf301.semestr.service.PizzaService;


import ru.itis.inf301.semestr.service.CartService;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@WebServlet("")
public class IndexPageServlet extends HttpServlet {
    private final PizzaService pizzaService = new PizzaService();
    private final CartService cartService = new CartService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Pizza> products = pizzaService.findAll();
            request.setAttribute("products", products);

            HttpSession session = request.getSession(false);
            int quantity;
            HashMap<Long, Integer> quantityMap;
            if (session != null) {
                Long id = (Long) session.getAttribute("id");
                quantity = cartService.getTotalQuantity(id);
                quantityMap = cartService.getQuantityMap(id);
            } else {
                quantity = 0;
                quantityMap = null;
            }
            request.setAttribute("quantity", quantity);
            request.setAttribute("quantityMap", quantityMap);

            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }


    }

}