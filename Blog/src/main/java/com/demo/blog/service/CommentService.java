package com.demo.blog.service;

import com.demo.blog.dao.CommentMapper;
import com.demo.blog.data.ApiResult;
import com.demo.blog.dto.CommentDto;
import com.demo.blog.entity.Comment;
import com.demo.blog.vo.CommentVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 评论 service 层
 * @author By-Lin
 */
@Service
public class CommentService {
    private final CommentMapper commentMapper;

    public CommentService(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    /**
     * 插入评论
     * @param comment       评论实体
     * @return              响应数据
     */
    public ApiResult insertComment(Comment comment) {
        if( comment == null || comment.getPostId() == 0 || comment.getUserId() == 0
            || comment.getContent() == null || comment.getContent().isEmpty()
            || "".equals(comment.getContent())) {
            return new ApiResult(400,"参数不能为空");
        }
        comment.setIsDel(0);
        comment.setCreateTime(new Date());
        int row = commentMapper.insertComment(comment);
        if( row > 0 ) { return new ApiResult(200,"评论成功"); }
        return new ApiResult(400,"评论失败");
    }

    /**
     * 删除评论
     * @param commentId     帖子id
     * @return              响应数据
     */
    public ApiResult deleteComment(int commentId) {
        if (commentId > 0) {
            int row = commentMapper.deleteComment(commentId);
            if(row > 0) { return new ApiResult(200,"删除成功"); }
            return new ApiResult(400,"删除失败");
        }
        return new ApiResult(400,"参数不能为空");
    }

    /**
     * 修改 评论
     * @param comment   评论实体
     * @return          响应数据
     */
    public ApiResult updateComment(Comment comment) {
        if(comment == null) { return new ApiResult(400,"参数不能为空"); }
        if(comment.getCommentId() == 0 ) { return new ApiResult(400,"id不能为空"); }
        if(comment.getContent() == null || comment.getContent().isEmpty() || "".equals(comment.getContent()) ) { return new ApiResult(400,"评论内容不能为空"); }
        CommentVO commentVO = commentMapper.selectCommentById(comment.getCommentId());
        if(commentVO == null) { return new ApiResult(400,"修改失败，当前帖子不存在"); }
        int row = commentMapper.updateComment(comment);
        if(row > 0) { return new ApiResult(200,"修改评论成功"); }
        return new ApiResult(400,"修改评论失败");
    }


    /**
     * 通过 dto 实体查询 评论
     * @param commentDto    评论dto
     * @return              响应数据
     */
    public ApiResult selectComments(CommentDto commentDto) {
        System.out.println(commentDto);
        if(commentDto == null) { return new ApiResult(400,"参数不能为空"); }
        List<CommentVO> commentVOList = commentMapper.selectComments(commentDto);
        return new ApiResult(200,"查询成功",commentVOList);
    }

    /**
     * 通过id 获取评论信息
     * @param commentId     评论id
     * @return              响应数据
     */
    public ApiResult selectCommentById(int commentId) {
        if(commentId == 0) { return new ApiResult(400,"参数不能为空"); }
        CommentVO commentVO = commentMapper.selectCommentById(commentId);
        if(commentVO == null) { return new ApiResult(400,"评论不存在"); }
        return new ApiResult(200,"获取评论成功", commentVO);
    }
}
