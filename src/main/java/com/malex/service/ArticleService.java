package com.malex.service;

import com.malex.model.dto.ArticleDTO;
import com.malex.model.dto.ArticleFindDTO;
import com.malex.model.entity.ArticleEntity;
import com.malex.model.enums.ArticleCategory;

import java.util.List;

public interface ArticleService {

    // ArticleDTO
    ArticleDTO saveDTO(ArticleDTO entity);

    // ArticleFindDTO
    List<ArticleFindDTO> findAllDTO();

    ArticleDTO findByIdDTO(Long id);

    // ArticleEntity
    ArticleEntity save(ArticleEntity entity);

    ArticleEntity update(ArticleEntity entity);

    void delete(Long id);

    ArticleEntity findById(Long id);

    List<ArticleEntity> findAll();

    List<ArticleEntity> findByCategory(ArticleCategory category);

}
