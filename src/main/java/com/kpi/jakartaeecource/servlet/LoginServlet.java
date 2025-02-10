package com.kpi.jakartaeecource.servlet;

import com.kpi.jakartaeecource.dao.UserDAO;
import com.kpi.jakartaeecource.model.User;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "loginServlet", value = "/login")
public class LoginServlet extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(LoginServlet.class.getName());

    @Inject
    private UserDAO userDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      try {
          String action = request.getParameter("action");
          if ("loginUser".equals(action)) {
              String username = request.getParameter("username");
              String password = request.getParameter("password");

              User user = userDAO.getByUserNameAndPass(username, password);
              
              if (user == null) {
                  request.setAttribute("loginError", "Invalid credentials!");
                  request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
                  return;
              }

              if (user.isAdmin()) {
                  HttpSession session = request.getSession(true);
                  session.setAttribute("role", "ADMIN");
                  response.sendRedirect(request.getContextPath() + "/admin");
              } else {
                  request.getRequestDispatcher("/WEB-INF/views/currencies.jsp").forward(request, response);
              }
          } else if ("guest".equals(action)) {
              response.sendRedirect(request.getContextPath() + "/currencies");
          } else {
              response.sendRedirect(request.getContextPath() + "/login");
          }
      } catch (Exception e) {
          LOGGER.log(Level.SEVERE, "Error processing login request", e);
          response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "An internal error occurred. Please try again later.");
      }

    }
}