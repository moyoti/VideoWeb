package com.my.dao;

import com.my.pojo.BehaviorContent;
import com.my.pojo.BehaviorContentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BehaviorContentMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior_content
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    int countByExample(BehaviorContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior_content
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    int deleteByExample(BehaviorContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior_content
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior_content
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    int insert(BehaviorContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior_content
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    int insertSelective(BehaviorContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior_content
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    List<BehaviorContent> selectByExample(BehaviorContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior_content
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    BehaviorContent selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior_content
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    int updateByExampleSelective(@Param("record") BehaviorContent record, @Param("example") BehaviorContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior_content
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    int updateByExample(@Param("record") BehaviorContent record, @Param("example") BehaviorContentExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior_content
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    int updateByPrimaryKeySelective(BehaviorContent record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table behavior_content
     *
     * @mbggenerated Mon Dec 10 21:16:58 CST 2018
     */
    int updateByPrimaryKey(BehaviorContent record);
}