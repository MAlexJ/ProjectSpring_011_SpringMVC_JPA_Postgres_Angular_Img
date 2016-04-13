package com.malex.controller;

import com.malex.model.enums.ArticleCategory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ArticleViewController {

    @RequestMapping(path = "/articleView/{category}/{id}", method = RequestMethod.GET)
    public String getArticleViewByCategoryAndId(@PathVariable ArticleCategory category,
                                                @PathVariable Long id) {
        System.err.println(id);
        System.err.println(category);
        return "views/articleView";
    }
}
