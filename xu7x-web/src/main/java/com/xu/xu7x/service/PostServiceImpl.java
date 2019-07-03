package com.xu.xu7x.service;


import com.xu.xu7x.util.ParseUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author xuhongda on 2019/6/20
 * com.xu.xu7x.service
 * xu7x
 */
@Slf4j
@Service
public class PostServiceImpl implements PostService {

    private SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private final ParseUtil parseUtil;

    public PostServiceImpl(ParseUtil parseUtil) {
        this.parseUtil = parseUtil;
    }

    @Override
    public boolean getFileToPost(MultipartFile[] files, HttpServletRequest request) throws IOException {
        MultipartFile f = files[0];
        InputStream inputStream = getStream(files, request);
        InputStreamReader streamReader = new InputStreamReader(inputStream, Charset.forName("utf-8"));
        BufferedReader bufferedReader = new BufferedReader(streamReader);
        String text;
        StringBuffer stringBuffer = new StringBuffer();
        while ((text = bufferedReader.readLine()) != null) {
            log.debug("text = {}", text);
            stringBuffer.append(text);
        }
        log.debug("stringBuffer = {}", stringBuffer);
        return parseUtil.pase(stringBuffer,f.getOriginalFilename());
    }

    @Override
    public void fileParse(MultipartFile[] files, HttpServletRequest request) throws IOException {
        getStream(files, request);
    }


    private InputStream getStream(MultipartFile[] files, HttpServletRequest request) throws IOException {
        MultipartFile f = files[0];
        String originalFilename = f.getOriginalFilename();
        String format = this.format.format(new Date());
        //获取绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(realPath + format + "-" + originalFilename);
        InputStream inputStream = f.getInputStream();
        f.transferTo(file);
        return inputStream;
    }
}
