package ru.itis.inf301.semestr.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.inf301.semestr.model.Cart;
import ru.itis.inf301.semestr.service.CartService;
import ru.itis.inf301.semestr.service.OrderService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/cart")
public class CartPageServlet extends HttpServlet {
    private final CartService cartService = new CartService();
    private final OrderService orderService = new OrderService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {

                String address = request.getParameter("address");

                Long user_id = (Long) session.getAttribute("id");
                List<Cart> carts = cartService.findByUser(user_id);

                orderService.addOrder(carts, address);

                response.sendRedirect("/");
            } else {
                response.sendRedirect("/login");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) {
        try {
            HttpSession session = request.getSession(false);
            if (session != null) {
                List<Cart> cart = cartService.findByUser((Long) session.getAttribute("id"));
                request.setAttribute("cart", cart);
                int quantity = cartService.getTotalQuantity((Long) session.getAttribute("id"));
                request.setAttribute("quantity", quantity);
                int totalPrice = cartService.getTotalPrice((Long) session.getAttribute("id"));
                request.setAttribute("totalPrice", totalPrice);
                request.setAttribute("authenticated", true);
                request.getRequestDispatcher("jsp/cart.jsp").forward(request, response);
            } else {
                response.sendRedirect("/login");
            }
        } catch (IOException | ServletException e) {
            throw new RuntimeException(e);
        }


    }

}