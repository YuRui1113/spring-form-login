/*
 * File: src\main\java\com\taylor\springformlogin\controllers\LoginController.java
 * Project: spring-form-login
 * Created Date: Thursday, December 28th 2023, 11:41:19 am
 * Author: Rui Yu
 * -----
 * Last Modified: Thursday, 28th December 2023 8:55:56 pm
 * Modified By: Rui Yu (yurui_113@hotmail.com>)
 * -----
 * Copyright (c) 2023 Rui Yu
 * 
 * All shall be well and all shall be well and all manner of things shall be well.
 * Nope...we're doomed!
 * -----
 * HISTORY:
 * Date      	By	Comments
 * ----------	---	----------------------------------------------------------
 */

package com.taylor.springformlogin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}