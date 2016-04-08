package com.malex.service.impl;

import com.malex.model.dto.ArticleDTO;
import com.malex.model.dto.ArticleFindDTO;
import com.malex.model.entity.ArticleEntity;
import com.malex.repository.ArticleRepository;
import com.malex.service.ArticleService;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository repository;

    @Autowired
    private Mapper beanMapper;

    @Override
    public ArticleDTO saveDTO(ArticleDTO entityDTO) {
        ArticleEntity entity = beanMapper.map(entityDTO, ArticleEntity.class);
        entity = repository.save(entity);
        return beanMapper.map(entity, ArticleDTO.class);
    }

    @Override
    public List<ArticleFindDTO> findAllDTO() {
        List<ArticleFindDTO> listDTO = new ArrayList<>();
        for (ArticleEntity entity : findAll()) {
            listDTO.add(beanMapper.map(entity, ArticleFindDTO.class));
        }
        return listDTO;
    }

    @Override
    public ArticleEntity save(ArticleEntity entity) {
        return this.repository.saveAndFlush(entity);
    }

    @Override
    public ArticleEntity update(ArticleEntity entity) {
        return this.repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        this.repository.delete(id);
    }

    @Override
    public ArticleEntity findById(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<ArticleEntity> findAll() {
        return this.repository.findAll();
    }

}
