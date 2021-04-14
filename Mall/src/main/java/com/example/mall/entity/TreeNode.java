package com.example.mall.entity;

import lombok.Data;

import java.util.List;

/**
 * 树节点 对象
 * @author By-Lin
 */
@Data
public class TreeNode {
    private Integer id;
    private Integer pid;
    private String name;
    private List<TreeNode> children;
}
