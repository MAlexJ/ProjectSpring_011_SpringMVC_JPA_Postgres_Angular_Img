package com.malex.controller;

import com.malex.model.dto.ArticleDTO;
import com.malex.model.dto.ArticleFindDTO;
import com.malex.model.dto.ImagesDTO;
import com.malex.model.dto.ImagesDataDTO;
import com.malex.model.entity.ArticleEntity;
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
public class AdminArticleRestController {

    @Autowired
    private ImagesService imagesService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(path = "/articleImageType/{type}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ImagesDataDTO articleGET(@PathVariable ImageType type) {
        return imagesService.findAllWithData(true, type);
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(path = "/article", method = RequestMethod.POST)
    public void articlePOST(@RequestBody CreateArticleVO entity) {
        // ImagesDTO imagesDTO = imagesService.findByNameDTO(entity.getImageName()); //TODO implements config DOZER

        ImagesEntity imagesEntity = imagesService.findByName(entity.getImageName());
        imagesEntity.setAvailable(false);

        ArticleDTO articleDTO = new ArticleDTO();
        articleDTO.setTitle(entity.getTitle());
        articleDTO.setDescription(entity.getDescription());
        articleDTO.setCategory(entity.getEnumType());
        articleDTO.setImage(imagesService.update(imagesEntity));

        articleService.saveDTO(articleDTO);
    }

    @RequestMapping(path = "/article/{id}", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ArticleEntity articleGet(@PathVariable Long id) {
        return articleService.findById(id);
    }

    @RequestMapping(path = "/category", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ArticleFindDTO> categoryGET() {
        return articleService.findAllDTO();
    }
}
