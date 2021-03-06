package com.xu.xu7x.controller;

import com.xu.xu7x.service.PostServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${read.type}")
    private String type;

    private final String STREAM = "stream";

    private final String MYSQL = "mysql";


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
    public String acc(User user,HttpServletResponse response) throws IOException {
        final String userName = "xuhongda";
        if (userName.equals(user.getUserName())) {
            return "post";
        } else {
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("认证失败:<a href= '/accu'>重新认证</a>");
            return null;
        }
    }

    /**
     * 发布
     */
    @ResponseBody
    @PostMapping("post")
    public HttpStatus editor(MultipartFile[] files, MultipartHttpServletRequest request) throws ParseException, IOException, ServletException {

        if (STREAM.equals(type)) {
            postService.fileParse(files, request);
        } else if (MYSQL.equals(type)) {
            String user = request.getParameter("user");
            log.info("user = {}", user);
            postService.getFileToPost(files, request);
        }
        return HttpStatus.OK;
    }


    @ResponseBody
    @GetMapping("xx")
    public String xx()  {
        return "中文乱码";
    }
}
