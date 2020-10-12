package com.kuang.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Bowei_Wu
 * Date: 2020/9/24
 * Time: 10:01
 * Description: No Description
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public  Docket docket(Environment environment){

//        获取项目的环境：
        environment.getActiveProfiles();
//        Profiles profiles = Profiles.of("dev");


//        通过environment.acceptsProfiles判断是否出在自己设定的环境当中
//        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
//                用来处理多组写作的分组问题
//                .groupName("Tiger")
//                .enable(flag)//是否启动swagger，如果为FALSE，则swagger不能在浏览器中访问
                .select()
//                RequestHandlerSelectors.配置要扫描的接口方式
//                basePackage指定要扫描的包
//                any():扫描全部
//                none():都不扫描
//                withClassAnnotation():扫描类上的注解，只会扫描类上面带@RestController的类，其中@的内容可以变化
//                withMethodAnnotataion():扫描方法上的注解，只会扫描方法上面带@RestController的方法，其中@的内容可以变化
                .apis(RequestHandlerSelectors.basePackage("com.kuang.swagger.controller"))
//                过滤什么路径
//                .paths(PathSelectors.ant("/kuang/**"))
                .build();
    }

    private ApiInfo apiInfo(){
        //作者信息
        Contact contact = new Contact("Tiger", "", "");

        return new ApiInfo(
                "Swagger接口文档",
                "描述",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());
    }



}