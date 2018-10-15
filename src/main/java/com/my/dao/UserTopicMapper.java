package com.my.dao;

import com.my.pojo.UserTopic;
import com.my.pojo.UserTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserTopicMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_topic
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    int countByExample(UserTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_topic
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    int deleteByExample(UserTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_topic
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_topic
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    int insert(UserTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_topic
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    int insertSelective(UserTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_topic
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    List<UserTopic> selectByExample(UserTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_topic
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    UserTopic selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_topic
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    int updateByExampleSelective(@Param("record") UserTopic record, @Param("example") UserTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_topic
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    int updateByExample(@Param("record") UserTopic record, @Param("example") UserTopicExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_topic
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    int updateByPrimaryKeySelective(UserTopic record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table user_topic
     *
     * @mbggenerated Mon Oct 08 11:31:16 CST 2018
     */
    int updateByPrimaryKey(UserTopic record);
}