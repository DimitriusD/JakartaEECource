package com.kpi.jakartaeecource.servlet;

import com.kpi.jakartaeecource.dao.MemberDAO;
import com.kpi.jakartaeecource.model.Member;
import com.kpi.jakartaeecource.servlet.converter.MemberConverter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    private final MemberDAO memberDAO = new MemberDAO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Member> members = memberDAO.getAllMembers();
        req.setAttribute("members", MemberConverter.toListDto(members));

        req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);
    }
}
