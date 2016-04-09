package com.malex.controller;

import com.malex.model.entity.ArticleEntity;
import com.malex.model.enums.ArticleCategory;
import com.malex.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleRestController {

    @Autowired
    private ArticleService articleService;


    @RequestMapping(path = "/articleJavaSE", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ArticleEntity> articleJavaSeGET() {
        return articleService.findByCategory(ArticleCategory.JAVA_SE);
    }

}
