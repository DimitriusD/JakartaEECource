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

@WebServlet(name = "memberServlet", value = "/member")
public class MemberServlet extends HttpServlet {

    private final MemberDAO memberDAO = new MemberDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String memberId = request.getParameter("id");
        int id = Integer.parseInt(memberId);

        Member member = memberDAO.getMemberById(id);
        if (member == null) {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Учасника з таким ID не знайдено");
            return;
        }

        request.setAttribute("member", MemberConverter.toMemberDto(member));
        request.getRequestDispatcher("/WEB-INF/views/member.jsp").forward(request, response);
    }

}
