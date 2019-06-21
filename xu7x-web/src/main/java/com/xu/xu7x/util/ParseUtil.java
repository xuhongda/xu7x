package com.xu.xu7x.util;

import com.xu.xu7x.mapper.Xu7xIndexMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Xu7xContent;
import pojo.Xu7xIndex;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xuhongda on 2019/6/20
 * com.xu.xu7x.util
 * xu7x
 */
@Service
public class ParseUtil {

    @Autowired
    private Xu7xIndexMapper indexMapper;

    public  List<Xu7xContent> pase(StringBuffer stringBuffer){

        String s = stringBuffer.toString();
        String trim = s.trim();

        int startTitle = trim.indexOf("#");
        int endTitle = trim.lastIndexOf("#");
        int startAuthor = trim.indexOf("@");
        int endAuthor = trim.lastIndexOf("@");



        String title = trim.substring(startTitle, endTitle);

        String author = trim.substring(startAuthor, endAuthor);

        Xu7xIndex xu7xIndex = new Xu7xIndex();
        xu7xIndex.setAuthor(author);
        xu7xIndex.setCreateTime(new Date());
        xu7xIndex.setName(title);
        xu7xIndex.setLastUpdateTime(new Date());

        int i = indexMapper.insertSelective(xu7xIndex);
        List<Xu7xContent> xu7xContents = new ArrayList<>();
        Integer indexId = xu7xIndex.getId();
        for (int k=0;k<4;k++){
            Xu7xContent xu7xContent = new Xu7xContent();
            xu7xContent.setIndexId(indexId);
            xu7xContent.setContent("str");
            xu7xContents.add(xu7xContent);
        }
        return xu7xContents;
    }

}
