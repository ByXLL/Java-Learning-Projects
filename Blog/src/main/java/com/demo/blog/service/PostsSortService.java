package com.demo.blog.service;

import com.demo.blog.dao.PostsSortMapper;
import com.demo.blog.data.ApiResult;
import com.demo.blog.entity.PostsSort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 帖子分类 service
 * @author By-Lin
 */
@Service
public class PostsSortService {
    private final PostsSortMapper postsSortMapper;

    public PostsSortService(PostsSortMapper postsSortMapper) {
        this.postsSortMapper = postsSortMapper;
    }

    /**
     * 添加帖子分类
     * @param postsSort     帖子实体
     * @return              响应数据
     */
    public ApiResult insertPostsSort(PostsSort postsSort) {
        if(postsSort == null || postsSort.getSortName().isEmpty() ) { return new ApiResult(400,"参数不能为空"); }
        List<PostsSort> oldRow = postsSortMapper.selectPostsSort(postsSort);
        if(oldRow.size() > 0 ) {return new ApiResult(400,"当前分类已存在"); }
        int row = postsSortMapper.insertPostsSort(postsSort);
        if( row > 0 ) { return  new ApiResult(200,"添加成功"); }
        return new ApiResult(400,"添加失败");
    }

    /**
     * 删除帖子分类
     * @param postsSortId       帖子id
     * @return                  响应数据
     */
    public ApiResult deletePostsSort(int postsSortId) {
        if(postsSortId > 0) {
           int row = postsSortMapper.deletePostsSort(postsSortId);
            if( row > 0 ) { return new ApiResult(200,"删除成功"); }
        }
        return new ApiResult(400,"id不能为空");
    }

    /**
     *
     * @param postsSort     帖子分类实体
     * @return              响应数据
     */
    public ApiResult updatePostsSort(PostsSort postsSort) {
        System.out.println(postsSort);
        if(postsSort == null || postsSort.getSortName() == null || "".equals(postsSort.getSortName())) { return new ApiResult(400,"参数不能为空"); }
        int row = postsSortMapper.updatePostsSort(postsSort);
        if( row > 0) { return new ApiResult(200,"编辑成功"); }
        return new ApiResult(400,"编辑失败");
    }

    /**
     * 获取帖子分类
     * @param postsSort     帖子实体
     * @return              响应数据
     */
    public ApiResult selectPostsSort(PostsSort postsSort) {
        if(postsSort == null) { return new ApiResult(400,"参数不能为空"); }
        List<PostsSort> postsSortList = postsSortMapper.selectPostsSort(postsSort);
        return new ApiResult(200,"查询成功",postsSortList);
    }

    /**
     * 获取帖子分类 通过id
     * @param postSortId    帖子分类id
     * @return              响应数据
     */
    public ApiResult selectPostsSortById(int postSortId) {
        if(postSortId == 0) { return new ApiResult(400,"参数不能为空"); }
        PostsSort postsSort = postsSortMapper.selectPostsSortById(postSortId);
        return new ApiResult(200,"数据获取成功", postsSort);
    }

}
