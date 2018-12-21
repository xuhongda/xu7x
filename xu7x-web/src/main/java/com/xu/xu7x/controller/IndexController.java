package com.xu.xu7x.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xuhongda on 2018/12/21
 * com.xu.xu7x.controller
 * xu7x
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index(){
        return "index";
    }
}
