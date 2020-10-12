package com.kuang.swagger.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/9/24
 * Time: 11:17
 * Description: No Description
 */
@ApiModel("用户实体类")//给实体类加了一个文档注释
public class User {


    @ApiModelProperty("用户名")
    public  String username;
    @ApiModelProperty("密码")
    public  String password;


}
