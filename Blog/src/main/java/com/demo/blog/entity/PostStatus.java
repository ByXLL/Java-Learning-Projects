package com.demo.blog.entity;

/**
 * 帖子状态 枚举类
 * @author By-Lin
 */

public enum PostStatus {
    // 正常，审批中,删除
    Normal(1), Approval(2),Deleted(3);
    PostStatus(int i) { }
}
