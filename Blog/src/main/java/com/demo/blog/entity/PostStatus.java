package com.demo.blog.entity;

public enum PostStatus {
    // 删除，正常，审批中
    Deleted(0), Normal(1), Approval(2);
    PostStatus(int i) {
    }
}
