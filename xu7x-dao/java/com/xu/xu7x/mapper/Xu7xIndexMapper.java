package com.xu.xu7x.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import pojo.Xu7xIndex;
import pojo.Xu7xIndexExample;

public interface Xu7xIndexMapper {
    long countByExample(Xu7xIndexExample example);

    int deleteByExample(Xu7xIndexExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Xu7xIndex record);

    int insertSelective(Xu7xIndex record);

    List<Xu7xIndex> selectByExample(Xu7xIndexExample example);

    Xu7xIndex selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Xu7xIndex record, @Param("example") Xu7xIndexExample example);

    int updateByExample(@Param("record") Xu7xIndex record, @Param("example") Xu7xIndexExample example);

    int updateByPrimaryKeySelective(Xu7xIndex record);

    int updateByPrimaryKey(Xu7xIndex record);
}