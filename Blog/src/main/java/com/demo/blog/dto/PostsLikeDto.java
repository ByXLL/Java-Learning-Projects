package com.demo.blog.dto;

/**
 * 帖子点赞 dto
 * @author By-Lin
 */
public class PostsLikeDto {
    private int postsId;
    private int userId;

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

    @Override
    public String toString() {
        return "PostsLikeDto{" +
                "postsId=" + postsId +
                ", userId=" + userId +
                '}';
    }
}
