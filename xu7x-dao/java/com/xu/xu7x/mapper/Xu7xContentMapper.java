package com.xu.xu7x.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Xu7xContent;
import pojo.Xu7xContentExample;

public interface Xu7xContentMapper {
    long countByExample(Xu7xContentExample example);

    int deleteByExample(Xu7xContentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Xu7xContent record);

    int insertSelective(Xu7xContent record);

    List<Xu7xContent> selectByExample(Xu7xContentExample example);

    Xu7xContent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Xu7xContent record, @Param("example") Xu7xContentExample example);

    int updateByExample(@Param("record") Xu7xContent record, @Param("example") Xu7xContentExample example);

    int updateByPrimaryKeySelective(Xu7xContent record);

    int updateByPrimaryKey(Xu7xContent record);

    /**
     * 插入集合
     * @param xu7xContents
     */
    void insertList(@Param("list") List<Xu7xContent> xu7xContents);
}