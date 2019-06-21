package com.xu.xu7x.controller;

import com.xu.xu7x.service.ViewServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Xu7xContent;
import pojo.Xu7xIndex;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 首页
 * @author xuhongda on 2018/12/21
 * com.xu.xu7x.controller
 * xu7x
 */
@Slf4j
@Controller
public class IndexController {

    @Autowired
    private ViewServiceImpl viewService;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        String remoteHost = getRemoteHost(request);
        log.info("remoteHost = {}",remoteHost);
        return "index";
    }

    @ResponseBody
    @GetMapping("/indexs")
    public List<Xu7xIndex> indexs(){
        List<Xu7xIndex> indexs = viewService.getIndexs();
        return indexs;
    }


    @GetMapping("/content")
    public String content(Integer id,HttpServletRequest request){
        request.setAttribute("id",id);
        return "content";
    }

    @ResponseBody
    @GetMapping("/cc")
    public List<Xu7xContent> content(Integer id){
        List<Xu7xContent> contents = viewService.getContent(id);
        return contents;
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
