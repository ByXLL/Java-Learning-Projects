package com.demo.blog.controller;

import com.demo.blog.data.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
public class HomeController extends ApiController {
    @GetMapping("/home")
    public ApiResult getHome(@PathParam("name") String name) {
        return Successed("欢迎你"+name);
    }
}
