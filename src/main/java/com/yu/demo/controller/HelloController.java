package com.yu.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiOperation;

@RequestMapping("/say")
@RestController
public class HelloController {
    
    @RequestMapping(value={"/hello"},method=RequestMethod.GET)
    @ApiOperation(value="测试接口", notes="测试接口")
    public String say(){
        return "Hello~";
    }
    
    
}
