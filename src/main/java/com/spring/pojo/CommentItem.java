package com.spring.pojo;

/**
 * @Author: dongqihang
 * @Date: Created in 18:16 2018/11/13
 */
public class CommentItem {
    private String username;
    private Comment comment;

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
