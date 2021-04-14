package com.demo.blog.dao;

import com.demo.blog.dto.CommentDto;
import com.demo.blog.entity.Comment;
import com.demo.blog.vo.CommentVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 评论接口，编写操作用户的行为 在service层中实现
 * @author By-Lin
 */
@Mapper
public interface CommentMapper {
    /**
     * 插入 评论
     * @param comment       评论实体
     * @return              影响行数
     */
    int insertComment(Comment comment);

    /**
     * 删除 评论
     * @param commentId     评论id
     * @return              影响行数
     */
    int deleteComment(int commentId);

    /**
     * 修改 评论
     * @param comment       评论实体
     * @return              影响行数
     */
    int updateComment(Comment comment);

    /**
     * 通过dto 查询评论信息
     * @param commentDto    评论dto
     * @return              评论视图对象 集合
     */
    List<CommentVO> selectComments(CommentDto commentDto);

    /**
     * 通过 id  查询评论信息
     * @param commentId     评论id
     * @return              评论试图对象 集合
     */
    CommentVO selectCommentById(int commentId);

}
