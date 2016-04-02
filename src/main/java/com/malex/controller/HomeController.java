package com.malex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    @RequestMapping(method = RequestMethod.GET)
    public String get(){
        return "index";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String getHome() {
        return "views/home";
    }

    @RequestMapping(path = "/article", method = RequestMethod.GET)
    public String getCrud() {
        return "views/article";
    }

    @RequestMapping(path = "/adminArticle", method = RequestMethod.GET)
    public String getLogin() {
        return "views/adminArticle";
    }

}
