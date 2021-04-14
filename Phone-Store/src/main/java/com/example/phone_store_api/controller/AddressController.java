package com.example.phone_store_api.controller;

import com.example.phone_store_api.exception.GlobalException;
import com.example.phone_store_api.form.AddressForm;
import com.example.phone_store_api.service.impl.AddressService;
import com.example.phone_store_api.utils.ApiResultUtil;
import com.example.phone_store_api.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Objects;

/**
 * 地址 handler
 * @author By-Lin
 */
@Slf4j
@ResponseBody
@RestController
@RequestMapping("/address")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/list")
    public ResultVO list() {
        return ApiResultUtil.success(addressService.findAll());
    }

    @PostMapping("/create")
    public ResultVO create(@Valid @RequestBody AddressForm addressForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            log.error("【添加地址】 参数错误 addressForm={}",addressForm);
            throw new GlobalException(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        addressService.saveOrUpdate(addressForm);
        return ApiResultUtil.success(null);
    }

    @PostMapping("/update")
    public ResultVO update(@Valid @RequestBody AddressForm addressForm, BindingResult bindingResult) {
        if(bindingResult.hasErrors() || addressForm.getId() == null) {
            log.error("【修改地址】 参数错误 addressForm={}",addressForm);
            throw new GlobalException(Objects.requireNonNull(bindingResult.getFieldError()).getDefaultMessage());
        }
        addressService.saveOrUpdate(addressForm);
        return ApiResultUtil.success(null);
    }
}
