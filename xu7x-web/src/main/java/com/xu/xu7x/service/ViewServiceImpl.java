package com.xu.xu7x.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.xu.xu7x.mapper.Xu7xContentMapper;
import com.xu.xu7x.mapper.Xu7xIndexMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pojo.Detail;
import pojo.Xu7xContent;
import pojo.Xu7xContentExample;
import pojo.Xu7xIndex;

import java.util.Comparator;
import java.util.List;

/**
 * @author xuhongda on 2019/6/20
 * com.xu.xu7x.service
 * xu7x
 */
@Slf4j
@Service
public class ViewServiceImpl implements ViewService {

    private ObjectMapper mapper = new ObjectMapper();

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
    public Detail getContent(Integer id) throws JsonProcessingException {
        Detail detail = new Detail();
        Xu7xIndex xu7xIndex = indexMapper.selectByPrimaryKey(id);
        detail.setXu7xIndex(xu7xIndex);
        Xu7xContentExample contentExample = new Xu7xContentExample();
        contentExample.createCriteria().andIndexIdEqualTo(id);
        List<Xu7xContent> xu7xContents = contentMapper.selectByExample(contentExample);
        detail.setXu7xContents(xu7xContents);
        log.info("detail  =  {}",mapper.writeValueAsString(detail));
        return detail;
    }
}
