package com.xu.xu7x.controller;

import com.xu.xu7x.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 文本编辑器
 *
 * @author xuhongda on 2019/5/30
 * com.xu.xu7x.controller
 * xu7x
 */
@Slf4j
@Controller
public class PostController {

    private SimpleDateFormat format = new SimpleDateFormat("yyyyy-mm-dd  HH:mm:ss");


    private final PostServiceImpl postService;

    public PostController(PostServiceImpl postService) {
        this.postService = postService;
    }

    @GetMapping("accu")
    public String editor() {
        return "accu";
    }

    /**
     * 发布认证用户
     * @param user 用户
     */
    @PostMapping("user/acc")
    public String acc(User user){
        final String userName = "xuhongda";
        if (userName.equals(user.getUserName())) {
            return "post";
        } else {
            return "认证失败";
        }
    }

    /**
     * 发布
     */
    @ResponseBody
    @PostMapping("post")
    public HttpStatus editor(MultipartFile[] files, MultipartHttpServletRequest request) throws ParseException, IOException, ServletException {
        String user = request.getParameter("user");
        log.info("user = {}", user);
        postService.getFileToPost(files,request);
        return HttpStatus.OK;
    }
}
