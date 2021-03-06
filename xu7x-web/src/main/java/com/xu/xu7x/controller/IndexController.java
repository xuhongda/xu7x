package com.xu.xu7x.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xu.xu7x.bean.ButtonType;
import com.xu.xu7x.service.ViewServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Detail;
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
    private ButtonType buttonType;

    @Autowired
    private ViewServiceImpl viewService;

    @GetMapping("/")
    public String index(HttpServletRequest request){
        String remoteHost = getRemoteHost(request);
        log.info("remoteHost = {}",remoteHost);
        log.info("buttonType = {}", buttonType.getTopic());
        return "index";
    }

    @GetMapping("page")
    public String page(HttpServletRequest request){
        String remoteHost = getRemoteHost(request);
        log.info("remoteHost = {}",remoteHost);
        return "page";
    }

    @ResponseBody
    @GetMapping("/indexs")
    public PageInfo<Xu7xIndex> indexs(Integer pageNum,Integer pageSize){
        PageHelper.startPage(pageNum,pageSize);
        List<Xu7xIndex> indexs = viewService.getIndexs();
        PageInfo<Xu7xIndex> pageInfo = new PageInfo<>(indexs,7);
        return pageInfo;
    }


    @GetMapping("/content")
    public String content(Integer id,HttpServletRequest request){
        request.setAttribute("id",id);
        return "content";
    }

    @ResponseBody
    @GetMapping("/cc")
    public Detail content(Integer id) throws JsonProcessingException {
        Detail detail = viewService.getContent(id);
        return detail;
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
