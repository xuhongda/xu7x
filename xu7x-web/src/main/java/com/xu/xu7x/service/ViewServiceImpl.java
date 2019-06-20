package com.xu.xu7x.service;

import com.xu.xu7x.mapper.Xu7xIndexMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Xu7xContent;
import pojo.Xu7xIndex;

import java.util.List;

/**
 * @author xuhongda on 2019/6/20
 * com.xu.xu7x.service
 * xu7x
 */
@Slf4j
@Service
public class ViewServiceImpl implements ViewService {

    @Autowired
    private Xu7xIndexMapper indexMapper;
    @Override
    public List<Xu7xIndex> getIndexs() {
        List<Xu7xIndex> xu7xIndices = indexMapper.selectByExample(null);
        return xu7xIndices;
    }
}
