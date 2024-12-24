package ru.itis.inf301.semestr.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import ru.itis.inf301.semestr.model.Cart;
import ru.itis.inf301.semestr.service.CartService;

import java.io.IOException;
import java.util.List;

@WebServlet("/cart")
public class CartPageServlet extends HttpServlet {
    private final CartService cartService = new CartService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {

            response.sendRedirect("/");
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