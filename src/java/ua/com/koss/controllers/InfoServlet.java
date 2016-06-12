/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.koss.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ua.com.koss.entity.Sessions;
import ua.com.koss.service.ServiceAPI;
import ua.com.koss.service.ServiceImpl;

/**
 *
 * @author koss
 */
@WebServlet("/info")
public class InfoServlet extends HttpServlet {

    private final ServiceAPI service;

    {
        service = new ServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        request.setAttribute("username", session.getAttribute("userName"));
        Sessions sessions = service.getByHashId(String.valueOf(session.getAttribute("hashId")));
        request.setAttribute("sessiontime", sessions.getSessiontime());
        request.setAttribute("countvisits", sessions.getSessionsCount());
        request.getRequestDispatcher("WEB-INF/views/info.jsp").forward(request, response);
    }

}
