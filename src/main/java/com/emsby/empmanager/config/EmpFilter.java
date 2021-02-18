package com.emsby.empmanager.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 该项目的过滤器
 * create lichengong on 20210125
 */
public class EmpFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        response.setContentType("text/html;charset=utf-8");
        request.setCharacterEncoding("utf-8");
        String url = request.getServletPath();
        System.out.println(url);
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
