package ru.itis.inf301.semestr.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse res = (HttpServletResponse) response;
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession(false);

        if (req.getServletPath().startsWith("/cart")) {
            if (session != null) {
                filterChain.doFilter(request, response);
            } else {
                res.sendRedirect("/login");
            }
        } else if(req.getServletPath().startsWith("/login") ||
                req.getServletPath().startsWith("/register")){
            if (session == null) {
                filterChain.doFilter(request, response);
            } else {
                res.sendRedirect("/");
            }
        } else{
            filterChain.doFilter(request, response);
        }

    }
}