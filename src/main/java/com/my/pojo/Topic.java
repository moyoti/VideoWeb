package com.my.pojo;

public class Topic {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic.id
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic.title
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column topic.content
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic.id
     *
     * @return the value of topic.id
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic.id
     *
     * @param id the value for topic.id
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic.title
     *
     * @return the value of topic.title
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic.title
     *
     * @param title the value for topic.title
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column topic.content
     *
     * @return the value of topic.content
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column topic.content
     *
     * @param content the value for topic.content
     *
     * @mbggenerated Sun Nov 11 00:46:41 CST 2018
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}