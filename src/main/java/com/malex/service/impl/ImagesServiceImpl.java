package com.malex.service.impl;

import com.malex.model.dto.ImagesDTO;
import com.malex.model.dto.ImagesDataDTO;
import com.malex.model.entity.ImagesEntity;
import com.malex.model.enums.ArticleCategory;
import com.malex.model.enums.ImageType;
import com.malex.repository.ImagesRepository;
import com.malex.service.ImagesService;
import org.apache.commons.lang3.EnumUtils;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImagesServiceImpl implements ImagesService {

    @Autowired
    private ImagesRepository repository;

    @Autowired
    private Mapper beanMapper;

    @Override
    public ImagesDTO saveDTO(ImagesDTO entityDTO) {
        ImagesEntity entity = beanMapper.map(entityDTO, ImagesEntity.class);
        entity = repository.save(entity);
        return beanMapper.map(entity, ImagesDTO.class);
    }

    @Override
    public List<ImagesDTO> findAllDTO() {
        List<ImagesDTO> entityListDTO = new ArrayList<>();
        List<ImagesEntity> entityList = repository.findAll();
        for (ImagesEntity entity : entityList) {
            entityListDTO.add(beanMapper.map(entity, ImagesDTO.class));
        }
        return entityListDTO;
    }

    @Override
    public List<ImagesDTO> findByIsAvailableDTO(boolean isAvailable) {
        List<ImagesDTO> entityListDTO = new ArrayList<>();
        List<ImagesEntity> entityList = repository.findByIsAvailable(isAvailable);
        for (ImagesEntity entity : entityList) {
            entityListDTO.add(beanMapper.map(entity, ImagesDTO.class));
        }
        return entityListDTO;
    }

    @Override
    public List<ImagesDTO> findByIsAvailableAndTypeDTO(boolean isAvailable, ImageType type) {
        List<ImagesDTO> entityListDTO = new ArrayList<>();
        List<ImagesEntity> entityList = repository.findByIsAvailableAndType(isAvailable, type);
        for (ImagesEntity entity : entityList) {
            entityListDTO.add(beanMapper.map(entity, ImagesDTO.class));
        }
        return entityListDTO;
    }

    @Override
    public ImagesDataDTO findAllWithData(boolean isAvailable, ImageType type) {
        ImagesDataDTO imagesDataDTO = new ImagesDataDTO();
        List<String> names = findByIsAvailableAndTypeDTO(isAvailable, type).stream().map(ImagesDTO::getName).collect(Collectors.toList());
        imagesDataDTO.setNameImg(names);
        imagesDataDTO.setEnumList(EnumUtils.getEnumList(ArticleCategory.class));
        return imagesDataDTO;
    }

    @Override
    public ImagesDTO findByNameDTO(String name) {
        ImagesEntity entity = repository.findByName(name);
        return beanMapper.map(entity, ImagesDTO.class);
    }

    @Override
    public ImagesEntity save(ImagesEntity entity) {
        return this.repository.saveAndFlush(entity);
    }

    @Override
    public ImagesEntity update(ImagesEntity entity) {
        return this.repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(id);
    }

    @Override
    public ImagesEntity findById(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public ImagesEntity findByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public List<ImagesEntity> findAll() {
        return this.repository.findAll();
    }

    @Override
    public List<ImagesEntity> findByIsAvailable(boolean isAvailable) {
        return repository.findByIsAvailable(isAvailable);
    }

    @Override
    public List<ImagesEntity> findByIsAvailableAndType(boolean isAvailable, ImageType type) {
        return repository.findByIsAvailableAndType(isAvailable, type);
    }
}
