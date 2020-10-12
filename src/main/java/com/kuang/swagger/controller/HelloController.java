package com.kuang.swagger.controller;

import com.kuang.swagger.pojo.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/9/24
 * Time: 9:55
 * Description: No Description
 */
@RestController
public class HelloController {
    @GetMapping(value = "/hello")
    public String hello(){
        return "hello";
    }
//只要我们的接口中，返回值中存在实体类，它就会被扫描到swagger中
    @PostMapping(value = "/user")
    public User user(){
        return new User();
    }

    @ApiOperation("Hello控制类")
    @GetMapping(value = "/hello2")
    public String hello(@ApiParam("用户名") String username){
        return "hello2"+username;
    }

    @ApiOperation("Post测试类")
    @PostMapping(value = "/postt")
    public User postt(@ApiParam("用户名") User user){
        return user;
    }


}
