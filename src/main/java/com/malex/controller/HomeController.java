package com.malex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/")
public class HomeController {

    // ************  Home Page  ******************

    @RequestMapping(method = RequestMethod.GET)
    public String indexPage_GET(){
        return "index";
    }

    @RequestMapping(path = "/home", method = RequestMethod.GET)
    public String homePage_GET() {
        return "views/home";
    }

    // ************ Lesson Page ******************

    @RequestMapping(path = "/angular", method = RequestMethod.GET)
    public String angularPage_GET() {
        return "views/angular";
    }

    @RequestMapping(path = "/java", method = RequestMethod.GET)
    public String javaPage_GET() {
        return "views/java";
    }

    @RequestMapping(path = "/spring", method = RequestMethod.GET)
    public String springPage_GET() {
        return "views/spring";
    }

    @RequestMapping(path = "/postgres", method = RequestMethod.GET)
    public String postgresPage_GET() {
        return "views/postgres";
    }

    @RequestMapping(path = "/info", method = RequestMethod.GET)
    public String infoPage_GET() {
        return "views/info";
    }


    // ************  Admin Page ******************

    @RequestMapping(path = "/adminImage", method = RequestMethod.GET)
    public String adminImagePage_GET() {
        return "views/adminImage";
    }

    @RequestMapping(path = "/adminArticle", method = RequestMethod.GET)
    public String adminArticlePage_GET() {
        return "views/adminArticle";
    }

}
