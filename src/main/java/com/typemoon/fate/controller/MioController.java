package com.typemoon.fate.controller;


import com.typemoon.fate.service.IMioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author fandz
 * @since 2021-03-30
 */
@RestController
@RequestMapping("/mio")
public class MioController {

    @Autowired
    IMioService mioService;
    /*8
    该方法是简易的测试shiro的账户认证
    通过前端页面发送的用户的密码（类似。。雾）比对配置里面的数据进行校验，并显示对应的结果
    该结果显示在服务器生成的页面上，而没有返回请求那页面加上注解
     */
    @RequestMapping("login")
    public String login(String user, String password) throws Exception {
        try {
            mioService.checkLogin(user, password);
            System.out.println("---------------登录成功---------------");
            System.out.println(user+"-----------------"+password);
            return "succse";
        } catch (Exception e) {
            System.out.println(user+"-----------------"+password);
            System.out.println("---------------失败------------------");
            return "errrrrrrrrrrrrrrrr";
        }



    }
}

