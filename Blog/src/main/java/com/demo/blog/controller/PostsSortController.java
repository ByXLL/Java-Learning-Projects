package com.demo.blog.controller;

import com.demo.blog.annotation.LoginTokenRequired;
import com.demo.blog.annotation.PassTokenRequired;
import com.demo.blog.data.ApiResult;
import com.demo.blog.entity.PostsSort;
import com.demo.blog.service.PostsSortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * 帖子分类控制器
 * @author By-Lin
 */
@ResponseBody
@RestController
@RequestMapping("/postsSort")
public class PostsSortController {
    private final PostsSortService postsSortService;

    public PostsSortController(PostsSortService postsSortService) {
        this.postsSortService = postsSortService;
    }

    /**
     * 添加帖子分类
     * @param postsSort     帖子分类实体
     * @return              响应数据
     */
    @LoginTokenRequired
    @PostMapping("/addPostsSort")
    public ApiResult addPostsSort(PostsSort postsSort) {
        return postsSortService.insertPostsSort(postsSort);
    }

    /**
     * 通过 id 删除帖子分类
     * @param postsSortId       帖子分类id
     * @return                  响应数据
     */
    @LoginTokenRequired
    @PostMapping("/delPostsSort")
    public ApiResult delPostsSort(int postsSortId) {
        return postsSortService.deletePostsSort(postsSortId);
    }

    /**
     * 修改 帖子分类
     * @param postsSort     帖子实体
     * @return              响应数据
     */
    @LoginTokenRequired
    @PostMapping("/updatePostsSort")
    public ApiResult updatePostsSort(PostsSort postsSort) {
        return postsSortService.updatePostsSort(postsSort);
    }

    /**
     * 通过 帖子实体查询
     * @param postsSort     帖子分类实体
     * @return              响应数据
     */
    @GetMapping("/getPostsSorts")
    public ApiResult getPostsSorts(PostsSort postsSort) {
        System.out.println(postsSort.toString());
        return postsSortService.selectPostsSort(postsSort);
    }

    /**
     * 通过id 获取 帖子分类信息
     * 这里有个 bug 当 url 中缺失字段的时候会造成报错
     * @param postsSortId       帖子分类id
     * @return                  响应数据
     */
    @LoginTokenRequired
    @GetMapping("/getPostsSort")
    public ApiResult getPostsSort(@PathParam("postsSortId") int postsSortId) {
        System.out.println(postsSortId);
        return postsSortService.selectPostsSortById(postsSortId);
    }
}
