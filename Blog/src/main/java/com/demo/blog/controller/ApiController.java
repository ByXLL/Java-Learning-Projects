package com.demo.blog.controller;

import com.demo.blog.data.ApiResult;
import org.springframework.web.bind.annotation.RestController;

/**
 * api 控制器
 * @author By-Lin
 */
@RestController
public class ApiController {
    protected ApiResult Successed(String msg) {
        return new ApiResult(200,msg);
    }

    protected ApiResult Successed(String msg, Object data) {
        return new ApiResult(200,msg,data);
    }

    protected ApiResult Errored(String msg) {
        return new ApiResult(400,msg);
    }

    protected ApiResult Errored(String msg,Object data) {
        return new ApiResult(400,msg,data);
    }
}
