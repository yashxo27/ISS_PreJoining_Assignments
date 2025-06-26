package com.bookstore.controller;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        if (email != null && password != null && !UserDB.exists(email)) {
            UserDB.addUser(email, password);
            res.sendRedirect("index.jsp");
        } else {
            res.sendRedirect("register.jsp");
        }
    }
}
