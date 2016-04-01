package com.malex.service.impl;

import com.malex.model.dto.ImagesDTO;
import com.malex.model.entity.ImagesEntity;
import com.malex.repository.ImagesRepository;
import com.malex.service.ImagesService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
    public List<ImagesEntity> findAll() {
        return this.repository.findAll();
    }
}
