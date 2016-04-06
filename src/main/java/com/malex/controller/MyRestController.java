package com.malex.controller;

import com.malex.model.dto.ImagesDTO;
import com.malex.model.entity.ArticleEntity;
import com.malex.model.enums.ImageType;
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

    // // Images: GET -> /images
    @RequestMapping(path = "/images", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ImagesDTO> imageGET() {
        return this.imagesService.findAllDTO();
    }

    // // Images: POST -> /images
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/images", method = RequestMethod.POST)
    public void imagePOST(@RequestParam("file") CommonsMultipartFile file,
                          @RequestParam("type") ImageType type) {
        if (!file.isEmpty()) {
            System.err.println(file.getOriginalFilename());
            System.err.println(type);
            System.err.println(true);

            ImagesDTO dto = new ImagesDTO();
            dto.setImg(file.getBytes());
            dto.setName(file.getOriginalFilename());
            dto.setType(type);
            dto.setAvalible(true);
            imagesService.saveDTO(dto);
        }
    }

    // Images: DELETE -> /images/{id}.
    @RequestMapping(path = "/images/{id}", method = RequestMethod.DELETE)
    public void imageDelete(@PathVariable Long id) {
        if (id > 0) {
            imagesService.delete(id);
        }
    }

    //Article
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/article", method = RequestMethod.POST)
    public void articlePOST(@RequestBody ArticleEntity entity) {
        System.err.println(entity.getTitle());
        System.err.println(entity.getDesctiption());
    }


}
