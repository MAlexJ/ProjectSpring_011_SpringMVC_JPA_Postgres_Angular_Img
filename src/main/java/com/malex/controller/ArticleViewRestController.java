package com.malex.controller;

import com.malex.model.entity.ArticleEntity;
import com.malex.model.enums.ArticleCategory;
import com.malex.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ArticleViewRestController {

    @Autowired
    private ArticleService articleService;

//    @RequestMapping(path = "/articleView/{category}/{id}", method = RequestMethod.GET)
//    @ResponseBody
//    public ArticleEntity getArticleViewByCategoryAndId(@PathVariable ArticleCategory category,
//                                                       @PathVariable Long id) {
//        System.err.println(id);
//        System.err.println(category);
//        return articleService.findById(id);
//    }
}
