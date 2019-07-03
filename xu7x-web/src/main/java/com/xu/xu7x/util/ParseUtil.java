package com.xu.xu7x.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.xu7x.mapper.Xu7xContentMapper;
import com.xu.xu7x.mapper.Xu7xIndexMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import pojo.Xu7xContent;
import pojo.Xu7xContentExample;
import pojo.Xu7xIndex;
import pojo.Xu7xIndexExample;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author xuhongda on 2019/6/20
 * com.xu.xu7x.util
 * xu7x
 */
@Slf4j
@Service
public class ParseUtil {


    @Value("${read.type}")
    private String type;

    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    private final Xu7xIndexMapper indexMapper;

    private final Xu7xContentMapper contentMapper;

    private ObjectMapper objectMapper = new ObjectMapper();

    public ParseUtil(Xu7xIndexMapper indexMapper, Xu7xContentMapper contentMapper) {
        this.indexMapper = indexMapper;
        this.contentMapper = contentMapper;
    }


    public  boolean pase(StringBuffer stringBuffer,String originalFilename) throws IOException {
        log.info("type = {}", type);
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

        Xu7xIndexExample indexExample = new Xu7xIndexExample();
        indexExample.createCriteria().andNameEqualTo(title);
        List<Xu7xIndex> xu7xIndices = indexMapper.selectByExample(indexExample);
        //段落集合
        List<Xu7xContent> xu7xContents = new ArrayList<>();

        if (!xu7xIndices.isEmpty()){
            Assert.isTrue(xu7xIndices.size() == 1,"数量不对");
            Xu7xIndex xu7xIndex1 = xu7xIndices.get(0);
            xu7xIndex1.setLastUpdateTime(new Date());
            indexMapper.updateByPrimaryKeySelective(xu7xIndex1);
            Integer indexId = xu7xIndex1.getId();
            Xu7xContentExample xu7xContentExample = new Xu7xContentExample();
            xu7xContentExample.createCriteria().andIndexIdEqualTo(indexId);
            // 原有的段落
            List<Xu7xContent> oldContent = contentMapper.selectByExample(xu7xContentExample);
            List<Integer> oldContentIds = new ArrayList<>();

            for (int k=0;k<4;k++){
                Xu7xContent xu7xContent = new Xu7xContent();
                xu7xContent.setIndexId(indexId);
                xu7xContent.setContent("777");
                xu7xContents.add(xu7xContent);
            }
            oldContent.forEach(old->oldContentIds.add(old.getId()));



            //todo: 原有的段落内容与现有的段落内容，可能 有 增；删；改 三种情况

            if (oldContent.size() == xu7xContents.size()){
                //更新与新的段落数目相同的段落
                List<Integer> list = oldContentIds.subList(0, xu7xContents.size());
                //批量更新
                contentMapper.updateListByIndexId(xu7xContents,list);
            }else if (oldContent.size() > xu7xContents.size()){
                //更新与新的段落数目相同的段落
                List<Integer> list = oldContentIds.subList(0, xu7xContents.size());
                contentMapper.updateListByIndexId(xu7xContents,list);

                boolean b = oldContentIds.removeAll(list);
                if (b){
                    contentMapper.deleteByIdList(oldContentIds);
                }

            }else if ( oldContent.size() < xu7xContents.size()){

            }


        }else {
            indexMapper.insertSelective(xu7xIndex);
            Integer indexId = xu7xIndex.getId();
            for (int k=0;k<4;k++){
                Xu7xContent xu7xContent = new Xu7xContent();
                xu7xContent.setIndexId(indexId);
                xu7xContent.setContent("str");
                xu7xContents.add(xu7xContent);
            }
            String ss = objectMapper.writeValueAsString(xu7xContents);
            objectMapper.writeValue(new File(format + "-" + originalFilename+".json"),xu7xContents);
            log.info("s = {}",ss);
            contentMapper.insertList(xu7xContents);
        }
        return true;
    }

}
