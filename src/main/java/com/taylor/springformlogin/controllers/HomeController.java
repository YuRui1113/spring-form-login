/*
 * File: src\main\java\com\taylor\springformlogin\controllers\HomeController.java
 * Project: spring-form-login
 * Created Date: Thursday, December 28th 2023, 11:40:51 am
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Thursday, 28th December 2023 8:55:38 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2023 Rui Yu
 * -----
 * HISTORY:
 * Date                     	By       	Comments
 * -------------------------	---------	----------------------------------------------------------
 * Thursday, December 28th 2023	Rui Yu		Initial version
 */

package com.taylor.springformlogin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage() {
        return "redirect:index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/anonymous")
    public String anonymous(Model model) {
        model.addAttribute("helloText", "匿名页面是匿名用户可以访问的公共内容。");
        return "anonymous";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}