package com.monour.app.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Scope("session")
public class NavigationController {

    @GetMapping("/landing")
    public String landingPage(){
        return "landing";
    }
}
