package ru.itis.inf301.semestr.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.inf301.semestr.model.Pizza;
import ru.itis.inf301.semestr.model.PizzaAndQuantity;
import ru.itis.inf301.semestr.service.PizzaService;


import ru.itis.inf301.semestr.service.CartService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@WebServlet("")
public class IndexPageServlet extends HttpServlet {
    private final PizzaService pizzaService = new PizzaService();
    private final CartService cartService = new CartService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            List<Pizza> pizzas = pizzaService.findAll();
            HttpSession session = request.getSession(false);
            int totalQuantity = 0;
            HashMap<Long, Integer> quantityMap = new HashMap<>();
            if (session != null) {
                Long id = (Long) session.getAttribute("id");
                totalQuantity = cartService.getTotalQuantity(id);
                quantityMap = cartService.getQuantityMap(id);

            }

            List<PizzaAndQuantity> products = new ArrayList<>();
            for (Pizza pizza : pizzas) {
                int quantity = 0;
                if (quantityMap.containsKey(pizza.getId())) {
                    quantity = quantityMap.get(pizza.getId());
                }
                products.add(new PizzaAndQuantity(pizza, quantity));
            }

            request.setAttribute("products", products);
            request.setAttribute("authenticated", (session != null));
            request.setAttribute("quantity", totalQuantity);

            request.getRequestDispatcher("jsp/index.jsp").forward(request, response);

        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }


    }

}