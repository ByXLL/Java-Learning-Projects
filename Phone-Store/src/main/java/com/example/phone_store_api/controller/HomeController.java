package com.example.phone_store_api.controller;

import com.example.phone_store_api.service.impl.HomeService;
import com.example.phone_store_api.utils.ApiResultUtil;
import com.example.phone_store_api.vo.ResultVO;
import org.springframework.web.bind.annotation.*;


/**
 * 首页 handler
 * @author By-Lin
 */
@ResponseBody
@RestController
@RequestMapping("/home")
public class HomeController {
    private final HomeService homeService;

    public HomeController(HomeService homeService) {
        this.homeService = homeService;
    }

    @GetMapping("/index")
    public ResultVO index() {
        return ApiResultUtil.success(homeService.findData());
    }
}
