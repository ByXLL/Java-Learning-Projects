package com.demo.blog.dao;

import com.demo.blog.entity.PostsSort;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 帖子分类接口，编写操作的行为 在service层中实现
 * @author By-Lin
 */
@Mapper
public interface PostsSortMapper {
    /**
     * 添加帖子分类
     * @param postsSort     帖子实体
     * @return              影响行数
     */
    int insertPostsSort(PostsSort postsSort);

    /**
     * 删除 帖子分类
     * @param postsSortId   帖子id
     * @return              影响行数
     */
    int deletePostsSort(int postsSortId);

    /**
     * 修改 帖子分类
     * @param postsSort     帖子实体
     * @return              影响行数
     */
    int updatePostsSort(PostsSort postsSort);

    /**
     * 通过 实体查询 帖子分类
     * @param postsSort     帖子实体
     * @return              帖子实体
     */
    List<PostsSort> selectPostsSort(PostsSort postsSort);


    /**
     * 通过 id 查询 帖子分类
     * @param postsSortId   帖子id
     * @return              帖子实体
     */
    PostsSort selectPostsSortById(int postsSortId);

}
