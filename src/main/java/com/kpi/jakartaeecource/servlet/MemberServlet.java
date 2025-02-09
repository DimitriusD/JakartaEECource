package com.kpi.jakartaeecource.servlet;

import com.kpi.jakartaeecource.dao.MemberDAO;
import com.kpi.jakartaeecource.model.Member;
import com.kpi.jakartaeecource.servlet.converter.MemberConverter;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.logging.Logger;

@WebServlet(name = "memberServlet", value = "/member")
public class MemberServlet extends HttpServlet {
    private static final Logger LOGGER = Logger.getLogger(MemberServlet.class.getName());

    @Inject
    private  MemberDAO memberDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String memberIdParam = request.getParameter("id");
        if (memberIdParam == null || memberIdParam.trim().isEmpty()) {
            LOGGER.warning("Parameter 'id' is missing or empty.");
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Missing or empty parameter 'id'.");
            return;
        }

        int id;
        try {
            id = Integer.parseInt(memberIdParam);
        } catch (NumberFormatException e) {
            LOGGER.info(String.format("Invalid format for parameter 'id': %s", memberIdParam));
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid format for parameter 'id'.");
            return;
        }

        Member member = memberDAO.getMemberById(id);
        if (member == null) {
            LOGGER.info(String.format("Member with id %d not found.", id));
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Member with the specified ID not found.");
            return;
        }

        request.setAttribute("member", MemberConverter.toMemberDto(member));
        request.getRequestDispatcher("/WEB-INF/views/member.jsp").forward(request, response);
    }

}
