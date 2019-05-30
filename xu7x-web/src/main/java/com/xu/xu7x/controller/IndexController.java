package com.xu.xu7x.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;


/**
 * @author xuhongda on 2018/12/21
 * com.xu.xu7x.controller
 * xu7x
 */
@Slf4j
@Controller
public class IndexController {



    @GetMapping("/")
    public String index(HttpServletRequest request){
        String remoteHost = getRemoteHost(request);
        log.info("remoteHost = {}",remoteHost);
        return "index";
    }

    /**
     * 获取远程访问IP
     * @param request 访问对象
     * @return IP
     */
    private String getRemoteHost(javax.servlet.http.HttpServletRequest request){
        String unknown = "unknown";
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)){
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)){
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || unknown.equalsIgnoreCase(ip)){
            ip = request.getRemoteAddr();
        }
        return "0:0:0:0:0:0:0:1".equals(ip)?"127.0.0.1":ip;
    }
}
