package com.imooc.sm.controller;

import com.imooc.sm.entity.Staff;
import com.imooc.sm.service.SelfService;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author liuxy
 * @version 1.0
 * @description:
 * @date 2020/11/6 16:38
 */

@Controller("selfController")
public class SelfController {

    @Autowired
    private SelfService selfService;

    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account = request.getParameter("account");
        String password = request.getParameter("password");
        Staff login = selfService.login(account, password);
        if (login == null) {
            response.sendRedirect("toLogin.do");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("USER", login);
            response.sendRedirect("main.do");
        }
    }

    public void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            HttpSession session = request.getSession();
            session.setAttribute("USER", null);
            response.sendRedirect("toLogin.do");
        }

    public void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void info(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../info.jsp").forward(request,response);
    }

    public void toChangePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("../change_password.jsp").forward(request,response);
    }

    public void changePassword(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String password = request.getParameter("password");  // 获取到原始密码
        String password1 = request.getParameter("password1");// 获取到新密码
        HttpSession session = request.getSession();
        Staff staff = (Staff) session.getAttribute("USER");
        if (!staff.getPassword().equals(password)) {
            response.sendRedirect("toChangePassword.do");
        } else {
            selfService.changePassword(staff.getId(), password1);
            response.getWriter().print("<script type=\"text/javascript\">parent.location.href=\"../logout.do\"</script>");
        }

    }
}
