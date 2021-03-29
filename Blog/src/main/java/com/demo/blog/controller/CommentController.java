package com.demo.blog.controller;

import com.demo.blog.annotation.LoginTokenRequired;
import com.demo.blog.annotation.PassTokenRequired;
import com.demo.blog.data.ApiResult;
import com.demo.blog.dto.CommentDto;
import com.demo.blog.entity.Comment;
import com.demo.blog.service.CommentService;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * 评论控制器
 * @author By-Lin
 */
@ResponseBody
@RestController
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }
    /**
     * 存在问题 org.springframework.validation.BindException 当某一个字段在实体中 但是 该字段为null
     * 这个时候都没有进到控制器
     */




    /**
     * 添加评论
     * @param comment     评论实体
     * @return             响应数据
     */
    @PostMapping("/addComment")
    public ApiResult addComment(Comment comment) {
        return commentService.insertComment(comment);
    }

    /**
     * 删除评论
     * @param commentId     评论id
     * @return              响应数据
     */
    @PostMapping("/deleteComment")
    public ApiResult deleteComment(@PathParam("commentId") int commentId) {
        return commentService.deleteComment(commentId);
    }

    /**
     * 更新评论
     * @param comment       评论实体
     * @return              响应数据
     */
    @PostMapping("/updateComment")
    public ApiResult updateComment(Comment comment) {
        return commentService.updateComment(comment);
    }

    /**
     * 查询多条 评论
     * @param commentDto    评论dto
     * @return              响应数据
     */
    @GetMapping("/getComments")
    public ApiResult getComments(CommentDto commentDto) {
        return commentService.selectComments(commentDto);
    }

    /**
     * 通过id 查询评论
     * @param commentId     评论id
     * @return              响应数据
     */
    @PassTokenRequired
    @GetMapping("/getComment")
    public ApiResult getComment(@PathParam("commentId") int commentId) {
        return commentService.selectCommentById(commentId);
    }
}
