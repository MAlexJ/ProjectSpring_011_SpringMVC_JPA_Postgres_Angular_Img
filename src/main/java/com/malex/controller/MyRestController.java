package com.malex.controller;

import com.malex.model.dto.ImagesDTO;
import com.malex.model.entity.ArticleEntity;
import com.malex.service.ArticleService;
import com.malex.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

// https://www.npmjs.com/package/ng-file-upload#server example upload Angular + Spring MVC
@RestController
public class MyRestController {

    @Autowired
    private ImagesService imagesService;

    @Autowired
    private ArticleService articleService;

    // Images
    @RequestMapping(path = "/images", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ImagesDTO> imageGET() {
        return this.imagesService.findAllDTO();
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/images", method = RequestMethod.POST)
    public void imagePOST(@RequestParam("file") CommonsMultipartFile file) {
//        if (!file.isEmpty()) {
//            System.err.println(file.getOriginalFilename());
//            ImagesDTO entity = new ImagesDTO();
//            entity.setName(file.getOriginalFilename());
//            entity.setImg(file.getBytes());
//            imagesService.saveDTO(entity);
//        }
    }

    //Article
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/article", method = RequestMethod.POST)
    public void articlePOST(@RequestBody ArticleEntity entity) {
        System.err.println(entity.getTitle());
        System.err.println(entity.getDesctiption());
    }


}
