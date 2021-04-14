package com.example.mall.controller;

import com.example.mall.annotation.PassTokenRequired;
import com.example.mall.data.ApiResult;
import com.example.mall.dto.TestDto;
import com.example.mall.utils.Constants;
import org.springframework.web.bind.annotation.*;

/**
 * @author By-Lin
 */
@RestController
@ResponseBody
@RequestMapping("/test")
public class TestController implements Constants {

    @PassTokenRequired
    @GetMapping("/testAdd")
    public ApiResult testApi(TestDto dto) {
        System.out.println(dto);
        return new ApiResult(SUCCESS_CODE,"数据获取成功", dto);
    }
}
