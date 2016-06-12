/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.com.koss.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jdk.nashorn.internal.ir.BreakNode;
import ua.com.koss.entity.Sessions;
import ua.com.koss.entity.Users;
import ua.com.koss.service.ServiceAPI;
import ua.com.koss.service.ServiceImpl;

/**
 *
 * @author koss
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    private final ServiceAPI service;

    {
        service = new ServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/views/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("register") != null) {
            registerUser(request);
            response.sendRedirect("login");
        } else if (loginUser(request) != null) {
            gsetsession(loginUser(request), request);
            response.sendRedirect("info");
        } else {
            response.sendRedirect("login");
        }
    }

    private void registerUser(HttpServletRequest request) {
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String repeatPassword = request.getParameter("repeate-password");
        if (password.equals(repeatPassword)) {
            service.adduser(name, password, email);
        }
    }

    private Users loginUser(HttpServletRequest request) {
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        if (service.isExist(login, password) != null) {
            return service.isExist(login, password);
        } else {
            return null;
        }
    }

    private void gsetsession(Users loginUser, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Date date = new Date(session.getLastAccessedTime());
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        String dateFormatted = formatter.format(date);
        session.setAttribute("auth", true);
        session.setAttribute("userName", loginUser.getUsername());
        session.setAttribute("hashId", loginUser.getId().toString());
        if (service.getByHashId(String.valueOf(loginUser.getId())) != null){
            Sessions sessions = service.getByHashId(String.valueOf(loginUser.getId()));
            service.changeSessionTime(sessions, dateFormatted);
            service.changeSessionCount(sessions);
            return;
        }
        service.addSession(String.valueOf(loginUser.getId()), dateFormatted, "1");
    }
}
