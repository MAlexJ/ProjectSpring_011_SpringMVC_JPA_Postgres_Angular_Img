package com.malex.controller;

import com.malex.model.entity.ArticleEntity;
import com.malex.model.enums.ArticleCategory;
import com.malex.service.ArticleService;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LessonRestController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping(path = "/homeGetListCategory", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArticleCategory> homePage_Category_GET() {
        return EnumUtils.getEnumList(ArticleCategory.class);
    }

    @RequestMapping(path = "/homeListLesson/{category}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ArticleEntity> homePage_ListLesson_GET(@PathVariable ArticleCategory category) {
        System.err.println(category);
        return articleService.findByCategory(category);
    }

    @RequestMapping(path = "/homeLesson/{category}/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArticleEntity homePage_Lesson_GET(@PathVariable ArticleCategory category,
                                                   @PathVariable Long id) {
        System.err.println(id);
        System.err.println(category);
        return articleService.findById(id);
    }

}
