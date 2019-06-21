package com.xu.xu7x.service;

import com.xu.xu7x.mapper.Xu7xContentMapper;
import com.xu.xu7x.util.ParseUtil;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pojo.Xu7xContent;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author xuhongda on 2019/6/20
 * com.xu.xu7x.service
 * xu7x
 */
@Slf4j
@Service
public class PostServiceImpl implements PostService {

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");


    @Autowired
    private Xu7xContentMapper contentMapper;

    @Autowired
    private ParseUtil parseUtil;

    @Override
    public boolean getFileToPost(MultipartFile[] files, HttpServletRequest request) throws IOException {
        MultipartFile f = files[0];
        String originalFilename = f.getOriginalFilename();
        String format = this.format.format(new Date());
        //获取绝对滤镜
        String realPath = request.getSession().getServletContext().getRealPath("/");
        File file = new File(realPath + format + "-" + originalFilename);
        f.transferTo(file);
        InputStream inputStream = f.getInputStream();

        InputStreamReader streamReader = new InputStreamReader(inputStream, Charset.forName("utf-8"));

        BufferedReader bufferedReader = new BufferedReader(streamReader);

        String text;
        StringBuffer stringBuffer = new StringBuffer();
        while ((text = bufferedReader.readLine()) != null) {
            log.info("text = {}", text);
            stringBuffer.append(text);
        }
        log.info("stringBuffer = {}", stringBuffer);
        List<Xu7xContent> xu7xContents = parseUtil.pase(stringBuffer);
        contentMapper.insertList(xu7xContents);
        return true;
    }
}
