package ru.itis.inf301.semestr.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {

//        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
//
//        // Проверяем аутентификацию
//        // Если нет ассоциированной с пользователем сессии мы ее не создаем
//        HttpSession session = httpServletRequest.getSession(false);
//        if (session != null) {
//            System.out.println(1234);
//            filterChain.doFilter(request, response);
//        } else {
//            System.out.println(543);
//            request.getRequestDispatcher("/login").forward(request, response);
//        }
        filterChain.doFilter(request, response);

    }
}