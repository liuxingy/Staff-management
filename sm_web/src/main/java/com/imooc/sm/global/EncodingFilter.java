package com.imooc.sm.global;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author liuxy
 * @version 1.0
 * @description:
 * @date 2020/10/19 17:38
 */
public class EncodingFilter implements Filter {
    private String encoding = "UTF-8";
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        if (filterConfig.getInitParameter("ENCODING") != null)
        encoding = filterConfig.getInitParameter("ENCODING");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        servletResponse.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        encoding = null;
    }
}
