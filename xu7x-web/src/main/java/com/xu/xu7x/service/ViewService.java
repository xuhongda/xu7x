package com.xu.xu7x.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import pojo.Detail;
import pojo.Xu7xContent;
import pojo.Xu7xIndex;

import java.util.List;

/**
 * @author xuhongda on 2019/6/20
 * com.xu.xu7x.service
 * xu7x
 */
public interface ViewService {
    /**
     * 获取文章列表
     * @return
     */
    List<Xu7xIndex> getIndexs();

    /**
     * 获取文章详情
     * @param id
     * @return
     */
    Detail getContent(Integer id) throws JsonProcessingException;
}



