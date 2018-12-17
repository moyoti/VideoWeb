package com.my.pojo;

import java.util.Date;

public class BehaviorContext {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column behavior_context.id
     *
     * @mbggenerated Tue Dec 11 20:04:30 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column behavior_context.access_time
     *
     * @mbggenerated Tue Dec 11 20:04:30 CST 2018
     */
    private Date accessTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column behavior_context.ip_address
     *
     * @mbggenerated Tue Dec 11 20:04:30 CST 2018
     */
    private String ipAddress;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column behavior_context.id
     *
     * @return the value of behavior_context.id
     *
     * @mbggenerated Tue Dec 11 20:04:30 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column behavior_context.id
     *
     * @param id the value for behavior_context.id
     *
     * @mbggenerated Tue Dec 11 20:04:30 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column behavior_context.access_time
     *
     * @return the value of behavior_context.access_time
     *
     * @mbggenerated Tue Dec 11 20:04:30 CST 2018
     */
    public Date getAccessTime() {
        return accessTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column behavior_context.access_time
     *
     * @param accessTime the value for behavior_context.access_time
     *
     * @mbggenerated Tue Dec 11 20:04:30 CST 2018
     */
    public void setAccessTime(Date accessTime) {
        this.accessTime = accessTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column behavior_context.ip_address
     *
     * @return the value of behavior_context.ip_address
     *
     * @mbggenerated Tue Dec 11 20:04:30 CST 2018
     */
    public String getIpAddress() {
        return ipAddress;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column behavior_context.ip_address
     *
     * @param ipAddress the value for behavior_context.ip_address
     *
     * @mbggenerated Tue Dec 11 20:04:30 CST 2018
     */
    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress == null ? null : ipAddress.trim();
    }
}