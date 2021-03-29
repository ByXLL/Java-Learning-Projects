package com.demo.blog.entity;

/**
 * 帖子点赞 实体
 * @author By-Lin
 */
public class PostsLike {
    private int postsId;
    private int userId;
    private int isLike;

    public int getPostsId() {
        return postsId;
    }

    public void setPostsId(int postsId) {
        this.postsId = postsId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getIsLike() {
        return isLike;
    }

    public void setIsLike(int isLike) {
        this.isLike = isLike;
    }

    @Override
    public String toString() {
        return "PostsLike{" +
                "postsId=" + postsId +
                ", userId=" + userId +
                ", isLike=" + isLike +
                '}';
    }
}
