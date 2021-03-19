package com.demo.blog.controller;

import com.demo.blog.data.ApiResult;
import com.demo.blog.entity.Posts;
import com.demo.blog.service.PostsService;
import com.demo.blog.utils.CommUtils;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;

/**
 * 帖子 控制器层
 * @author By-Lin
 */
@ResponseBody
@RestController
@RequestMapping("/posts")
public class PostController {
    private final PostsService postsService;

    public PostController(PostsService postsService) {
        this.postsService = postsService;
    }
    /**
     * 通过 帖子id 查询帖子信息
     * @param postId    帖子id
     * @return          响应数据
     */
    @GetMapping("/{postId}")
    public ApiResult getPosts(@PathVariable int postId, HttpServletRequest request) {
        String ipAddress =  CommUtils.getIpAddr(request);
        System.out.println(ipAddress);
        return postsService.findPostsById(postId,ipAddress );
    }

    /**
     * 通过 实体查询 帖子信息
     * @param posts     帖子实体
     * @return          响应数据
     */
    @GetMapping("/getPosts")
    public ApiResult getPosts(Posts posts) {
      return postsService.findPosts(posts);
    }

    /**
     * 点赞帖子
     * @param posts     帖子实体
     * @return
     */
    @PostMapping("/like")
    public ApiResult likePosts(Posts posts) {
        return postsService.likePosts(posts);
    }

    /**
     * 添加 帖子
     * @param posts     帖子实体
     * @return          响应数据
     */
    @PostMapping("/addPosts")
    public ApiResult addPosts(Posts posts) {
        return postsService.insertPosts(posts);
    }

    /**
     * 修改帖子
     * @param posts     帖子
     * @return          响应数据
     */
    @PostMapping("/updatePosts")
    public ApiResult updatePosts(Posts posts) {
        return postsService.updatePosts(posts);
    }
}
