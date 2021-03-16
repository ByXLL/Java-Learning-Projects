package com.demo.blog.entity;

import java.util.Date;

/**
 * 帖子实体
 */
public class Posts {
    private int postId;
    private int authorId;
    private String postSortIds;
    private String postTitle;
    private String postExcerpt;
    private String postContent;
    private int postIsHot;
    private Enum postStatus;
    private int postPv;
    private int postLikeCount;
    private Date postCreateTime;

    public int getPostId() {
        return postId;
    }

    public void setPostId(int postId) {
        this.postId = postId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getPostSortIds() {
        return postSortIds;
    }

    public void setPostSortIds(String postSortIds) {
        this.postSortIds = postSortIds;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostExcerpt() {
        return postExcerpt;
    }

    public void setPostExcerpt(String postExcerpt) {
        this.postExcerpt = postExcerpt;
    }

    public String getPostContent() {
        return postContent;
    }

    public void setPostContent(String postContent) {
        this.postContent = postContent;
    }

    public int getPostIsHot() {
        return postIsHot;
    }

    public void setPostIsHot(int postIsHot) {
        this.postIsHot = postIsHot;
    }

    public Enum getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(PostStatus postStatus) {
        this.postStatus = postStatus;
    }

    public int getPostPv() {
        return postPv;
    }

    public void setPostPv(int postPv) {
        this.postPv = postPv;
    }

    public int getPostLikeCount() {
        return postLikeCount;
    }

    public void setPostLikeCount(int postLikeCount) {
        this.postLikeCount = postLikeCount;
    }

    public Date getPostCreateTime() {
        return postCreateTime;
    }

    public void setPostCreateTime(Date postCreateTime) {
        this.postCreateTime = postCreateTime;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "postId=" + postId +
                ", authorId=" + authorId +
                ", postSortIds='" + postSortIds + '\'' +
                ", postTitle='" + postTitle + '\'' +
                ", postExcerpt='" + postExcerpt + '\'' +
                ", postContent='" + postContent + '\'' +
                ", postIsHot=" + postIsHot +
                ", postStatus=" + postStatus +
                ", postPv=" + postPv +
                ", postLikeCount=" + postLikeCount +
                ", postCreateTime=" + postCreateTime +
                '}';
    }
}
