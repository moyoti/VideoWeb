package com.my.pojo;

public class UserActive {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_active.id
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_active.userid
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    private String userid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_active.activecode
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    private String activecode;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_active.id
     *
     * @return the value of user_active.id
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_active.id
     *
     * @param id the value for user_active.id
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_active.userid
     *
     * @return the value of user_active.userid
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public String getUserid() {
        return userid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_active.userid
     *
     * @param userid the value for user_active.userid
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_active.activecode
     *
     * @return the value of user_active.activecode
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public String getActivecode() {
        return activecode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_active.activecode
     *
     * @param activecode the value for user_active.activecode
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public void setActivecode(String activecode) {
        this.activecode = activecode == null ? null : activecode.trim();
    }
}