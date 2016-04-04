package com.malex.service;

import com.malex.model.dto.ImagesDTO;
import com.malex.model.entity.ImagesEntity;

import java.util.List;

public interface ImagesService {

    // ImagesDTO
    ImagesDTO saveDTO(ImagesDTO entityDTO);

    List<ImagesDTO> findAllDTO();

    // ImagesEntity
    ImagesEntity save(ImagesEntity entity);

    ImagesEntity update(ImagesEntity entity);

    void delete(Long id);

    ImagesEntity findById(Long id);

    ImagesEntity findByName(String name);

    List<ImagesEntity> findAll();
}
