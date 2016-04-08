package com.malex.service;

import com.malex.model.dto.ImagesDTO;
import com.malex.model.dto.ImagesDataDTO;
import com.malex.model.entity.ImagesEntity;
import com.malex.model.enums.ImageType;

import java.util.List;

public interface ImagesService {

    // ImagesDTO
    ImagesDTO saveDTO(ImagesDTO entityDTO);

    List<ImagesDTO> findAllDTO();

    List<ImagesDTO> findByIsAvailableDTO(boolean isAvailable);

    ImagesDataDTO findAllWithData(boolean isAvailable, ImageType type);

    ImagesDTO findByNameDTO(String name);

    List<ImagesDTO> findByIsAvailableAndTypeDTO(boolean isAvailable, ImageType type);

    // ImagesEntity
    ImagesEntity save(ImagesEntity entity);

    ImagesEntity update(ImagesEntity entity);

    void delete(Long id);

    ImagesEntity findById(Long id);

    ImagesEntity findByName(String name);

    List<ImagesEntity> findAll();

    List<ImagesEntity> findByIsAvailable(boolean isAvailable);

    List<ImagesEntity> findByIsAvailableAndType(boolean isAvailable, ImageType type);
}
