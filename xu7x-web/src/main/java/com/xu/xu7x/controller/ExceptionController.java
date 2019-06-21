package com.xu.xu7x.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author xuhongda on 2019/6/21
 * com.xu.xu7x.controller
 * xu7x
 */
@Slf4j
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public String ex(Exception ex){
        log.error(ex.getMessage());
        return "出错啦";
    }
}
