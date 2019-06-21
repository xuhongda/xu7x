package com.xu.xu7x.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author xuhongda on 2019/6/20
 * com.xu.xu7x.service
 * xu7x
 */
public interface PostService {

    boolean getFileToPost(MultipartFile[] files, HttpServletRequest request) throws IOException;
}
