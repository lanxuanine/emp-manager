package com.emsby.empmanager.config;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 该项目的过滤器
 * create lichengong on 20210125
 */
public class EmpFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestURI = request.getServletPath();
        System.out.println(requestURI);
        filterChain.doFilter(servletRequest,servletResponse);
    }

}
