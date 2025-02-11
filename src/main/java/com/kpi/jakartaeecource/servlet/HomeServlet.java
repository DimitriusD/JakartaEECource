package com.kpi.jakartaeecource.servlet;

import com.kpi.jakartaeecource.dao.MemberDAO;
import com.kpi.jakartaeecource.model.Member;
import com.kpi.jakartaeecource.servlet.converter.MemberConverter;
import com.kpi.jakartaeecource.utils.LoggerUtil;
import jakarta.inject.Inject;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "homeServlet", value = "/home")
public class HomeServlet extends HttpServlet {

    @Inject
    private MemberDAO memberDAO;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            LoggerUtil.logInfo(getClass(), "Processing GET request for /home");

            List<Member> members = memberDAO.getAllMembers();
            if (members.isEmpty()) {
                LoggerUtil.logWarning(getClass(), "No members found.");
                req.setAttribute("message", "No members available.");
            }

            req.setAttribute("members", MemberConverter.toListDto(members));
            req.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(req, resp);

            LoggerUtil.logInfo(getClass(), "Successfully forwarded to home.jsp with " + members.size() + " members.");
        } catch (Exception e) {
            LoggerUtil.logError(getClass(), "Error occurred during processing GET request for /home", e);
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error processing request" + e.getMessage());
        }
    }
}
