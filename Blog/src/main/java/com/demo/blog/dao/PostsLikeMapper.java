package com.demo.blog.dao;

import com.demo.blog.dto.PostsLikeDto;
import com.demo.blog.entity.Posts;
import com.demo.blog.entity.PostsLike;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 帖子接口，编写操作用户的行为 在service层中实现
 * @author By-Lin
 */
@Mapper
public interface PostsLikeMapper {
    /**
     * 插入 点赞信息
     * @param postsLike     点赞实体
     * @return              影响行数
     */
    int insertPostsLike(PostsLike postsLike);

    /**
     * 修改点赞信息
     * @param postsLike     点赞实体
     * @return              影响行数
     */
    int updatePostsLike(PostsLike postsLike);

    /**
     * 查询 点赞信息
     * @param postsLikeDto     点赞dto
     * @return              点赞实体
     */
    PostsLike selectPostsLike(PostsLikeDto postsLikeDto);
}
