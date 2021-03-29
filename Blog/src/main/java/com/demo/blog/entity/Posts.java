package com.demo.blog.entity;

import java.util.Date;

/**
 * 帖子实体
 * @author By-Lin
 */
public class Posts {
    private int postsId;
    private int authorId;
    private String postsSortIds;
    private String postsTitle;
    private String postsExcerpt;
    private String postsContent;
    private int postsIsHot;
    private int postsStatus;
    private int postsPv;
    private int postsLikeCount;
    private Date postsCreateTime;

    public int getPostsId() {
        return postsId;
    }

    public void setPostsId(int postsId) {
        this.postsId = postsId;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getPostsSortIds() {
        return postsSortIds;
    }

    public void setPostsSortIds(String postsSortIds) {
        this.postsSortIds = postsSortIds;
    }

    public String getPostsTitle() {
        return postsTitle;
    }

    public void setPostsTitle(String postsTitle) {
        this.postsTitle = postsTitle;
    }

    public String getPostsExcerpt() {
        return postsExcerpt;
    }

    public void setPostsExcerpt(String postsExcerpt) {
        this.postsExcerpt = postsExcerpt;
    }

    public String getPostsContent() {
        return postsContent;
    }

    public void setPostsContent(String postsContent) {
        this.postsContent = postsContent;
    }

    public int getPostsIsHot() {
        return postsIsHot;
    }

    public void setPostsIsHot(int postsIsHot) {
        this.postsIsHot = postsIsHot;
    }

    public int getPostsStatus() {
        return postsStatus;
    }

    public void setPostsStatus(int postsStatus) {
        this.postsStatus = postsStatus;
    }

    public int getPostsPv() {
        return postsPv;
    }

    public void setPostsPv(int postsPv) {
        this.postsPv = postsPv;
    }

    public int getPostsLikeCount() {
        return postsLikeCount;
    }

    public void setPostsLikeCount(int postsLikeCount) {
        this.postsLikeCount = postsLikeCount;
    }

    public Date getPostsCreateTime() {
        return postsCreateTime;
    }

    public void setPostsCreateTime(Date postsCreateTime) {
        this.postsCreateTime = postsCreateTime;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "postsId=" + postsId +
                ", authorId=" + authorId +
                ", postsSortIds='" + postsSortIds + '\'' +
                ", postsTitle='" + postsTitle + '\'' +
                ", postsExcerpt='" + postsExcerpt + '\'' +
                ", postsContent='" + postsContent + '\'' +
                ", postsIsHot=" + postsIsHot +
                ", postsStatus=" + postsStatus +
                ", postsPv=" + postsPv +
                ", postsLikeCount=" + postsLikeCount +
                ", postsCreateTime=" + postsCreateTime +
                '}';
    }
}
