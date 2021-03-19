package com.demo.blog.entity;

/**
 * 帖子分类 实体类
 * @author By-Lin
 */
public class PostsSort {
    private int postsSortId;
    private String sortName;

    public int getPostsSortId() {
        return postsSortId;
    }

    public void setPostsSortId(int postsSortId) {
        this.postsSortId = postsSortId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    @Override
    public String toString() {
        return "PostsSort{" +
                "postsSortId=" + postsSortId +
                ", sortName='" + sortName + '\'' +
                '}';
    }
}
