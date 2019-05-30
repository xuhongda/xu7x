package com.xu.xu7x.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author xuhongda on 2019/5/30
 * com.xu.xu7x.filter
 * xu7x
 */
@Slf4j
@WebFilter(urlPatterns = "/post")
public class WriterFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        String user = (String) request.getAttribute("user");
        String password = (String) request.getAttribute("password");
        if ("xuhongda".equals(user)&&"7777".equals(password)){
            chain.doFilter(request,response);
        }else {
            log.info("user:{},password:{}",user,password);
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            PrintWriter writer = response.getWriter();
            writer.print("这个用户不能写作");
        }
    }

    @Override
    public void destroy() {

    }
}
