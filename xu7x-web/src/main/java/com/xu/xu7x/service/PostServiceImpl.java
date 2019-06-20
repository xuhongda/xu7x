package com.xu.xu7x.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;

/**
 * @author xuhongda on 2019/6/20
 * com.xu.xu7x.service
 * xu7x
 */
@Slf4j
@Service
public class PostServiceImpl implements PostService {
    @Override
    public boolean getFileToPost(MultipartFile[] files) throws IOException {
        MultipartFile f = files[0];
        File file = new File("D:/xucode/my/xu7x/tt.text");
        f.transferTo(file);

        String contentType = f.getContentType();

        byte[] bytes = f.getBytes();
        InputStream inputStream = f.getInputStream();

        InputStreamReader streamReader = new InputStreamReader(inputStream, Charset.forName("utf-8"));

        BufferedReader bufferedReader = new BufferedReader(streamReader);

        String text;
        StringBuffer stringBuffer = new StringBuffer();
        while ((text = bufferedReader.readLine())  != null){
            log.info("text = {}",text);
            stringBuffer.append(text);
        }
        log.info("stringBuffer = {}",stringBuffer);

        return true;
    }
}
