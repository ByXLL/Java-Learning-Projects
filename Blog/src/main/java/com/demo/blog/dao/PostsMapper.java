package com.demo.blog.dao;

import com.demo.blog.entity.Posts;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 帖子接口，编写操作用户的行为 在service层中实现
 * @author By-Lin
 */
@Mapper
public interface PostsMapper {

    /**
     * 新增 帖子
     * @param posts     帖子实体
     * @return          影响行数
     */
    int insertPosts(Posts posts);

    /**
     * 修改帖子
     * @param posts     帖子实体
     * @return          影响行数
     */
    int updatePosts(Posts posts);

    /**
     * 修改 帖子浏览量
     * @param posts     帖子实体
     * @return          影响行数
     */
    int updatePostsPV(Posts posts);

    /**
     * 修改 帖子点赞数
     * @param posts     帖子实体
     * @return          影响行数
     */
    int updatePostsLikeCount(Posts posts);

    /**
     * 假删除 帖子
     * @param postId    帖子id‘
     * @return          影响行数
     */
    int deletePosts(int postId);

    /**
     * 通过 id 查询帖子
     * @param postsId   帖子id
     * @return          帖子实体
     */
    Posts selectById(int postsId);

    /**
     * 通过 作者id查询
     * @param authorId      作者id
     * @return              帖子实体list
     */
    List<Posts> selectByAuthorId(int authorId);

    /**
     * 通过 帖子标题 查询帖子
     * @param postsTitle    帖子标题
     * @return              帖子list
     */
    List<Posts> selectByPostsTitle(String postsTitle);

    /**
     * 通过实体 条件查询帖子
     * @param posts     帖子实体
     * @return          帖子list
     */
    List<Posts> selectByPosts(Posts posts);

}
