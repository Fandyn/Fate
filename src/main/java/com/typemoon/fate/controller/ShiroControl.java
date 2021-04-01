package com.typemoon.fate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShiroControl {

    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }


}
