package com.malex.controller;


import com.malex.model.entity.ArticleEntity;
import com.malex.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private ArticleRepository articleRepository;

    // GET /article/ (Index) – получает список всех объектов.
    @RequestMapping(path = "/article",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ArticleEntity> listGoodsEntity() {
        System.err.println(this.articleRepository.findAll());
        return this.articleRepository.findAll();
    }

}
