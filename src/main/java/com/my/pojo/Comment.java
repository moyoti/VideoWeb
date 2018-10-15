package com.my.pojo;

public class Comment {

    private Integer id;


    private Integer topicId;


    private String content;


    private Integer fromUid;


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getTopicId() {
        return topicId;
    }


    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }


    public Integer getFromUid() {
        return fromUid;
    }


    public void setFromUid(Integer fromUid) {
        this.fromUid = fromUid;
    }
}