package com.xu.xu7x.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author xuhongda on 2019/5/30
 * com.xu.xu7x.controller
 * xu7x
 */
@Controller
public class CatalogueController {

    @GetMapping("2018")
    public String x(){
        return "2018";
    }
}
