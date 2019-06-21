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

    /**
     * 批量更新
     * @param xu7xContents
     * @param contentIds
     */
    void updateListByIndexId(@Param("xu7xContents") List<Xu7xContent> xu7xContents, @Param("contentIds") List<Integer> contentIds);

    /**
     * 批量删除
     * @param contentIds
     */
    void deleteByIdList(@Param("contentIds") List<Integer> contentIds);
}