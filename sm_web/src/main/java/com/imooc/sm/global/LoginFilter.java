package com.imooc.sm.global;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author liuxy
 * @version 1.0
 * @description:
 * @date 2020/11/9 9:28
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String path = request.getServletPath();
        if (path.toLowerCase().indexOf("login") != -1) {
            filterChain.doFilter(request,response);
        } else {
            HttpSession session = request.getSession();
            Object user = session.getAttribute("USER");
            if (user != null) {
                filterChain.doFilter(request,response);
            } else {
                response.sendRedirect(request.getContextPath() + "/toLogin.do");
            }
        }

    }

    @Override
    public void destroy() {

    }
}
