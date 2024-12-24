package ru.itis.inf301.semestr.controller;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.inf301.semestr.service.CartService;

@WebServlet("/cart/service")
public class CartServiceServlet extends HttpServlet {
    private final CartService cartService = new CartService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {

            HttpSession session = request.getSession(false);
            if (session != null) {
                Long user_id = (Long) session.getAttribute("id");


                if (request.getParameter("action").equals("addCart")) {
                    String pizzaIdParam = request.getParameter("pizza_id");
                    if (pizzaIdParam == null || pizzaIdParam.isEmpty()) {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
                        return;
                    }
                    Long pizza_id = Long.parseLong(pizzaIdParam);
                    cartService.addPizza(user_id, pizza_id);
                } else if (request.getParameter("action").equals("reduceQuantity")) {
                    String pizzaIdParam = request.getParameter("pizza_id");
                    if (pizzaIdParam == null || pizzaIdParam.isEmpty()) {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
                        return;
                    }
                    Long pizza_id = Long.parseLong(pizzaIdParam);
                    cartService.reduceQuantity(user_id, pizza_id);
                } else if (request.getParameter("action").equals("deleteCart")) {
                    String pizzaIdParam = request.getParameter("pizza_id");
                    if (pizzaIdParam == null || pizzaIdParam.isEmpty()) {
                        response.setStatus(HttpServletResponse.SC_BAD_REQUEST); // 400 Bad Request
                        return;
                    }
                    Long pizza_id = Long.parseLong(pizzaIdParam);
                    cartService.removeCart(user_id, pizza_id);
                } else if (request.getParameter("action").equals("clearCart")) {
                    cartService.removeCartsByUser(user_id);
                }


                response.setStatus(HttpServletResponse.SC_NO_CONTENT); // 204 No Content
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.setContentType("application/json");
                response.getWriter().write("{\"redirect\":\"/login\"}");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); // 500 Internal Server Error
        }
    }
}