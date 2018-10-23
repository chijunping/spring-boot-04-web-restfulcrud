package com.atguigu.springboot.controller;


import com.atguigu.springboot.exception.UserNotExistException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.Map;

@Controller
public class HelloController {


    /**
     * 当访问 "/"、"/index.html" 时，都是转发到/template/index.html页面
     *
     * @return
     */
    /*
    @RequestMapping({"/","/index.html"})
    public String index(){
        return "index";
    }*/
    @ResponseBody
    @RequestMapping("/hello")
    public String hello(@RequestParam("user") String user) {
        if (user.equals("aaa")) {
            throw new UserNotExistException();
        }
        return "Hello World";
    }

    /**
     * 跳转到 success.html 页面
     *
     * @param map
     * @return
     */
    //查出用户数据，在页面展示
    @RequestMapping("/success")
    public String success(Map<String, Object> map) {
        map.put("hello", "<h1>你好</h1>");
        map.put("users", Arrays.asList("zhangsan", "lisi", "wangwu"));
        return "success";
    }


}
