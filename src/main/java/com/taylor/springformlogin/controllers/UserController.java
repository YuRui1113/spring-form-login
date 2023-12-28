/*
 * File: src\main\java\com\taylor\springformlogin\controllers\UserController.java
 * Project: spring-form-login
 * Created Date: Thursday, December 28th 2023, 11:42:07 am
 * Author: Rui Yu (yurui_113@hotmail.com)
 * -----
 * Last Modified: Thursday, 28th December 2023 8:56:26 pm
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
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("/user/index")
    public String userIndex() {
        return "user/index";
    }
}