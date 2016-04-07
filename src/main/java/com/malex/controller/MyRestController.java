package com.malex.controller;

import com.malex.model.dto.ImagesDTO;
import com.malex.model.entity.ArticleEntity;
import com.malex.model.enums.ArticleCategory;
import com.malex.model.enums.ImageType;
import com.malex.service.ArticleService;
import com.malex.service.ImagesService;
import org.apache.commons.lang3.EnumUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private ImagesService imagesService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(path = "/images", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ImagesDTO> imageGET() {
        return imagesService.findByIsAvailableDTO(true);
    }

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
            dto.setAvailable(true);
            imagesService.saveDTO(dto);
        }
    }

    @RequestMapping(path = "/images/{id}", method = RequestMethod.DELETE)
    public void imageDelete(@PathVariable Long id) {
        if (id > 0) {
            imagesService.delete(id);
        }
    }


    @RequestMapping(path = "/article", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ImagesDTO> articleGET() {
        // 1. List<ImagesDTO> -> findByIsAvailableDTO(true);

        // 2. List<String> -> Collections.list(ArticleCategory);
        List<ArticleCategory> enumList = EnumUtils.getEnumList(ArticleCategory.class);
        System.err.println(enumList);

        return imagesService.findByIsAvailableDTO(true);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/article", method = RequestMethod.POST)
    public void articlePOST(@RequestBody ArticleEntity entity) {
        System.err.println(entity.getTitle());
        System.err.println(entity.getDesctiption());
    }


}
