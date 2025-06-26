package com.bookstore.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        // In-memory check
        if (email != null && password != null && UserDB.exists(email, password)) {
            HttpSession session = req.getSession();
            session.setAttribute("user", email);
            res.sendRedirect("welcome.jsp");
        } else {
            res.sendRedirect("error.jsp");
        }
    }
}
