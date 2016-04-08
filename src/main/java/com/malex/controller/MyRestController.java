package com.malex.controller;

import com.malex.model.dto.ArticleDTO;
import com.malex.model.dto.ImagesDTO;
import com.malex.model.dto.ImagesDataDTO;
import com.malex.model.entity.ImagesEntity;
import com.malex.model.enums.ImageType;
import com.malex.model.vo.CreateArticleVO;
import com.malex.service.ArticleService;
import com.malex.service.ImagesService;
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
    public ImagesDataDTO articleGET() {
        return imagesService.findAllWithData(true, ImageType.ARTICLE);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/article", method = RequestMethod.POST)
    public void articlePOST(@RequestBody CreateArticleVO entity) {
        System.err.println(entity.getDescription());
        System.err.println(entity.getTitle());
        System.err.println(entity.getImageName());
        System.err.println(entity.getEnumType());

        // ImagesDTO imagesDTO = imagesService.findByNameDTO(entity.getImageName()); //TODO implements config DOZER

        ImagesEntity imagesEntity = imagesService.findByName(entity.getImageName());

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setTitle(entity.getTitle());
        articleDTO.setDescription(entity.getDescription());
        articleDTO.setCategory(entity.getEnumType());
        articleDTO.setImage(imagesEntity);

        articleService.saveDTO(articleDTO);
    }


}
