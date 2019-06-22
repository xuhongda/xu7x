package com.xu.xu7x.service;

import com.xu.xu7x.mapper.Xu7xContentMapper;
import com.xu.xu7x.mapper.Xu7xIndexMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.Xu7xContent;
import pojo.Xu7xContentExample;
import pojo.Xu7xIndex;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

/**
 * @author xuhongda on 2019/6/20
 * com.xu.xu7x.service
 * xu7x
 */
@Slf4j
@Service
public class ViewServiceImpl implements ViewService {

    private final Xu7xIndexMapper indexMapper;

    private final Xu7xContentMapper contentMapper;

    public ViewServiceImpl(Xu7xIndexMapper indexMapper, Xu7xContentMapper contentMapper) {
        this.indexMapper = indexMapper;
        this.contentMapper = contentMapper;
    }

    @Override
    public List<Xu7xIndex> getIndexs() {
        List<Xu7xIndex> xu7xIndices = indexMapper.selectByExample(null);
        xu7xIndices.sort(Comparator.comparing(Xu7xIndex::getId).reversed());
        return xu7xIndices;
    }

    @Override
    public List<Xu7xContent> getContent(Integer id) {
        Xu7xContentExample contentExample = new Xu7xContentExample();
        contentExample.createCriteria().andIndexIdEqualTo(id);
        List<Xu7xContent> xu7xContents = contentMapper.selectByExample(contentExample);
        log.debug("contents  =  {}",xu7xContents);
        return xu7xContents;
    }
}
