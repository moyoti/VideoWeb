package com.spring.dao;

import com.my.pojo.CommentRelation;
import com.my.pojo.CommentRelationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommentRelationMapper {
    List<CommentRelation> queryByPage(Map<String, Object> map);
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_relation
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    int countByExample(CommentRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_relation
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    int deleteByExample(CommentRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_relation
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_relation
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    int insert(CommentRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_relation
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    int insertSelective(CommentRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_relation
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    List<CommentRelation> selectByExample(CommentRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_relation
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    CommentRelation selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_relation
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    int updateByExampleSelective(@Param("record") CommentRelation record, @Param("example") CommentRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_relation
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    int updateByExample(@Param("record") CommentRelation record, @Param("example") CommentRelationExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_relation
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    int updateByPrimaryKeySelective(CommentRelation record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table comment_relation
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    int updateByPrimaryKey(CommentRelation record);
}