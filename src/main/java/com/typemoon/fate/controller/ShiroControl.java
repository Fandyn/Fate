package com.typemoon.fate.controller;

import com.typemoon.fate.service.IMioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class ShiroControl {

    @Autowired
    IMioService mioService;

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
        //会跳转到名字为这个的页面
    }

    @RequestMapping("/login")
    public String login(String user, String password) throws Exception {
        try {
            mioService.checkLogin(user, password);
            System.out.println("---------------登录成功---------------");
            System.out.println(user+"-----------------"+password);
            return "index";
        } catch (Exception e) {
            System.out.println(user+"-----------------"+password);
            System.out.println("---------------失败------------------");
            return "login";
        }
    }
}
