package com.malex.service;


import com.malex.model.entity.ArticleBlockEntity;

import java.util.List;

public interface ArticleBlockService {

    ArticleBlockEntity save(ArticleBlockEntity entity);

    ArticleBlockEntity update(ArticleBlockEntity entity);

    void delete(Long id);

    ArticleBlockEntity findById(Long id);

    List<ArticleBlockEntity> findAll();

}
