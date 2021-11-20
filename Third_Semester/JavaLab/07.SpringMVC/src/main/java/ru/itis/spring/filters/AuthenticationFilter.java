package ru.itis.spring.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {


    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        if (request.getRequestURI().equals("/signIn") || request.getRequestURI().equals("/signUp")){
            chain.doFilter(request, response);
            return;
        } else {
            HttpSession session = request.getSession(false);
            try {
                if (session != null && session.getAttribute("isAuthenticated").equals("true")) {
                    chain.doFilter(request, response);
                } else {
                    System.out.println("Обнаружена попытка входа без аутентификации");
                    response.sendRedirect("/signIn?Error=Not-Authenticated");
                }
            } catch (NullPointerException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void destroy() {

    }
}
