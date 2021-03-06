package com.malex.service.impl;

import com.malex.model.entity.ArticleBlockEntity;
import com.malex.repository.ArticleBlockRepository;
import com.malex.repository.ImagesRepository;
import com.malex.service.ArticleBlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ArticleBlockServiceImpl implements ArticleBlockService {

    @Autowired
    private ArticleBlockRepository repository;

    @Autowired
    private ImagesRepository imagesRepository;

    @Override
    public ArticleBlockEntity save(ArticleBlockEntity entity) {
        return this.repository.saveAndFlush(entity);
    }

    @Override
    public ArticleBlockEntity update(ArticleBlockEntity entity) {
        return this.repository.saveAndFlush(entity);
    }

    @Override
    public void delete(Long id) {
        imagesRepository.findAll().stream().filter(image -> Objects.equals(image.getBlock().getId(), id)).forEach(image -> {
            image.setBlock(null);
        });
        this.repository.delete(id);
    }

    @Override
    public ArticleBlockEntity findById(Long id) {
        return this.repository.findOne(id);
    }

    @Override
    public List<ArticleBlockEntity> findAll() {
        return this.repository.findAll();
    }
}
