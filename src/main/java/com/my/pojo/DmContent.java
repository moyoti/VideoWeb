package com.my.pojo;

import java.util.Date;

public class DmContent {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dm_content.id
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dm_content.uid
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dm_content.vid
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    private Integer vid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dm_content.content
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dm_content.vduration
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    private Double vduration;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column dm_content.sendtime
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    private Date sendtime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dm_content.id
     *
     * @return the value of dm_content.id
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dm_content.id
     *
     * @param id the value for dm_content.id
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dm_content.uid
     *
     * @return the value of dm_content.uid
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dm_content.uid
     *
     * @param uid the value for dm_content.uid
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dm_content.vid
     *
     * @return the value of dm_content.vid
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public Integer getVid() {
        return vid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dm_content.vid
     *
     * @param vid the value for dm_content.vid
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public void setVid(Integer vid) {
        this.vid = vid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dm_content.content
     *
     * @return the value of dm_content.content
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dm_content.content
     *
     * @param content the value for dm_content.content
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dm_content.vduration
     *
     * @return the value of dm_content.vduration
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public Double getVduration() {
        return vduration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dm_content.vduration
     *
     * @param vduration the value for dm_content.vduration
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public void setVduration(Double vduration) {
        this.vduration = vduration;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column dm_content.sendtime
     *
     * @return the value of dm_content.sendtime
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public Date getSendtime() {
        return sendtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column dm_content.sendtime
     *
     * @param sendtime the value for dm_content.sendtime
     *
     * @mbggenerated Sat Dec 29 16:01:56 CST 2018
     */
    public void setSendtime(Date sendtime) {
        this.sendtime = sendtime;
    }
}