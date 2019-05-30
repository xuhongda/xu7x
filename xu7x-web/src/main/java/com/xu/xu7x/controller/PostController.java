package com.xu.xu7x.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.Post;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文本编辑器
 * @author xuhongda on 2019/5/30
 * com.xu.xu7x.controller
 * xu7x
 */
@Controller
public class PostController {

    private SimpleDateFormat format = new SimpleDateFormat("yyyyy-mm-dd  HH:mm:ss");

    @GetMapping("writer")
    public String editor(){
        return "writer";
    }

    @ResponseBody
    @GetMapping("post")
    public HttpStatus editor(Post post) throws ParseException {
        post.setDate(format.parse(format.format(new Date())));
        post.setAuthor("xuhongda");
        return HttpStatus.OK;
    }
}
