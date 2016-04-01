package com.malex.service.impl;

import com.malex.model.entity.ArticleEntity;
import com.malex.repository.ArticleRepository;
import com.malex.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository repository;

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
