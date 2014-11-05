package com.portlogistics.config;


import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by cvfrans on 2/11/14.
 */

@WebFilter("/*")
@Component
public class SimpleCORSFilter extends OncePerRequestFilter implements Filter {


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods","GET, POST, PUT, DELETE, OPTIONS");
        response.addHeader("Access-Control-Allow-Headers","origin, content-type, accept, x-requested-with, sid, mycustom, smuser");
        filterChain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
