package com.demo.blog.service;

import com.demo.blog.dao.PostsLikeMapper;
import com.demo.blog.dao.PostsMapper;
import com.demo.blog.dao.UserMapper;
import com.demo.blog.data.ApiResult;
import com.demo.blog.dto.PostsLikeDto;
import com.demo.blog.entity.Posts;
import com.demo.blog.entity.PostsLike;
import com.demo.blog.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 帖子 service 层
 * @author By-Lin
 */
@Service
public class PostsService {
    private final UserMapper userMapper;
    private final PostsMapper postsMapper;

    private final PostsLikeMapper postsLikeMapper;

    public PostsService(UserMapper userMapper, PostsMapper postsMapper, PostsLikeMapper postsLikeMapper) {
        this.userMapper = userMapper;
        this.postsMapper = postsMapper;
        this.postsLikeMapper = postsLikeMapper;
    }

    /**
     * 通过实体查询帖子
     * @param posts     帖子实体
     * @return          响应数据
     */
    public ApiResult findPosts(Posts posts) {
        if(posts == null) { return new ApiResult(400,"参数不能为空"); }
        List<Posts> postsList = postsMapper.selectByPosts(posts);
        return new ApiResult(200,"数据获取成功", postsList);
    }

    /**
     * 通过id查询 数据
     * @param postId    帖子id
     * @return          响应数据
     */
    public ApiResult findPostsById(int postId, String ipAddress) {
        if(postId > 0) {
            Posts posts = postsMapper.selectById(postId);
            // 这里有个问题 关于 访问量 ++
            if(posts != null) {
                // 这有个问题 获取点赞的问题
                // posts1.setIsLiked(1);
                posts.setPostsPv(posts.getPostsPv() +1);
                postsMapper.updatePostsPV(posts);
            }
            return new ApiResult(200,"数据获取成功",posts);
        }
        return new ApiResult(400,"参数不能为空");
    }

    /**
     * 点赞
     * @param postsLikeDto     帖子实体
     * @return          响应数据
     */
    public ApiResult likePosts(PostsLikeDto postsLikeDto) {
        if(postsLikeDto == null) {
            return new ApiResult(400,"参数不能为空");
        }
        if(postsLikeDto.getPostsId() == 0 ) { return new ApiResult(400,"参数不能为空"); }
        if(postsLikeDto.getUserId() == 0) {  return new ApiResult(400,"参数不能为空"); }

        User user = userMapper.selectById(postsLikeDto.getUserId());
        Posts posts = postsMapper.selectById(postsLikeDto.getPostsId());
        if(posts == null || user == null) { return new ApiResult(400,"操作失败,参数错误"); }

        PostsLike postsLike = postsLikeMapper.selectPostsLike(postsLikeDto);

        PostsLike newPostsLike = new PostsLike();
        newPostsLike.setPostsId(postsLikeDto.getPostsId());
        newPostsLike.setUserId(postsLikeDto.getUserId());

        // 之前没有点赞
        if(postsLike == null ) {
            newPostsLike.setIsLike(1);
            int insertRow = postsLikeMapper.insertPostsLike(newPostsLike);
            if(insertRow > 0) {
                posts.setPostsLikeCount(posts.getPostsLikeCount() +1);
                if(updatePostsLikeCount(posts)){  return new ApiResult(200,"点赞成功");  }
                else { return new ApiResult(400,"点赞失败"); }
            }
            return new ApiResult(400,"点赞失败");
        }else {
            // 已经点了赞
            if(postsLike.getIsLike() == 1) {
                newPostsLike.setIsLike(0);
                int updateLikeRow = postsLikeMapper.updatePostsLike(newPostsLike);
                if(updateLikeRow > 0) {
                    posts.setPostsLikeCount(posts.getPostsLikeCount()-1);
                    if(updatePostsLikeCount(posts)) { return new ApiResult(200,"取消点赞成功"); }
                }
                return new ApiResult(400,"取消点赞失败");
            }else {
                // 点了赞 又取消
                newPostsLike.setIsLike(1);
                int updateLikeRow = postsLikeMapper.updatePostsLike(newPostsLike);
                if(updateLikeRow > 0) {
                    posts.setPostsLikeCount(posts.getPostsLikeCount()+1);
                    if(updatePostsLikeCount(posts)) { return new ApiResult(200,"点赞成功"); }
                }
                return new ApiResult(400,"点赞失败");
            }
        }
    }

    /**
     * 修改 帖子
     * @param posts     帖子实体
     * @return          响应数据
     */
    public ApiResult updatePosts(Posts posts) {
        if(posts == null || posts.getPostsId() == 0) { return new ApiResult(400,"参数不能为空"); }
        Posts oldPosts = postsMapper.selectById(posts.getPostsId());
        if(oldPosts == null) { return new ApiResult(400,"当前帖子不存在"); }

        if(!posts.getPostsSortIds().isEmpty()) { oldPosts.setPostsSortIds(posts.getPostsSortIds()); }
        if(!posts.getPostsTitle().isEmpty()) { oldPosts.setPostsTitle(posts.getPostsTitle()); }
        if(!posts.getPostsExcerpt().isEmpty()) { oldPosts.setPostsExcerpt(posts.getPostsExcerpt()); }
        if(!posts.getPostsContent().isEmpty()) { oldPosts.setPostsContent(posts.getPostsContent()); }
        if(posts.getPostsIsHot() > 0) { oldPosts.setPostsIsHot(posts.getPostsIsHot()); }
        if(posts.getPostsStatus() > 0) { oldPosts.setPostsStatus(posts.getPostsStatus()); }

        int row = postsMapper.updatePosts(oldPosts);
        if(row > 0) { return new ApiResult(200,"修改成功",oldPosts); }
        return new ApiResult(400,"修改失败");
    }

    /**
     * 添加 帖子
     * @param posts     帖子实体
     * @return          响应数据
     */
    public ApiResult insertPosts(Posts posts) {
        if(posts == null) { return new ApiResult(400,"参数不能为空"); }
        if(posts.getAuthorId() == 0) { return new ApiResult(400,"作者id不能为空"); }
        if(posts.getPostsTitle().isEmpty()) { return new ApiResult(400,"帖子标题不能为空"); }
        if(posts.getPostsExcerpt().isEmpty()) { return new ApiResult(400,"简介不能为空"); }
        if(posts.getPostsContent().isEmpty()) { return new ApiResult(400,"正文内容不能为空"); }
        if(posts.getPostsIsHot() == 0) { posts.setPostsIsHot(2); }
        posts.setPostsStatus(2);
        posts.setPostsPv(0);
        posts.setPostsLikeCount(0);
        posts.setPostsCreateTime(new Date());
        int row = postsMapper.insertPosts(posts);
        if(row > 0) { return new ApiResult(200,"添加成功"); }
        return new ApiResult(400,"添加失败");
    }

    /**
     * 内部方法 处理 帖子点赞个数++
     * @param posts     帖子实体
     * @return
     */
    private Boolean updatePostsLikeCount(Posts posts){
        int updatePostsRow = postsMapper.updatePostsLikeCount(posts);
        if(updatePostsRow > 0) {
            return true;
        }
        return false;
    }
}
