package com.malex.controller;

import com.malex.model.dto.ImagesDTO;
import com.malex.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import java.util.List;

@RestController
public class MyRestController {

    @Autowired
    private ImagesService imagesService;

    @RequestMapping(path = "/images", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<ImagesDTO> get() {
        return this.imagesService.findAllDTO();
    }

    @RequestMapping(path = "/images", method = RequestMethod.POST)
    public void post(@RequestParam("file") CommonsMultipartFile file) {
        if (!file.isEmpty()) {
            System.err.println(file.getOriginalFilename());
            ImagesDTO entity = new ImagesDTO();
            entity.setName(file.getOriginalFilename());
            entity.setImg(file.getBytes());
            imagesService.saveDTO(entity);
        }
    }


}
