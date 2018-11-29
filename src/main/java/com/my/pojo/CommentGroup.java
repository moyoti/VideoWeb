package com.my.pojo;

import java.util.List;

/**
 * @Author: dongqihang
 * @Date: Created in 20:22 2018/11/18
 */
public class CommentGroup {
    private String username;

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    private String picPath;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private Comment pComment;
    private List<CommentItem> cComment;

    public Comment getpComment() {
        return pComment;
    }

    public void setpComment(Comment pComment) {
        this.pComment = pComment;
    }

    public List<CommentItem> getcComment() {
        return cComment;
    }

    public void setcComment(List<CommentItem> cComment) {
        this.cComment = cComment;
    }
}
