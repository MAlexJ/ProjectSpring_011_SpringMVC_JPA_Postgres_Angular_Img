package com.malex.repository;

import com.malex.model.entity.ArticleEntity;
import com.malex.model.enums.ArticleCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<ArticleEntity, Long> {

    List<ArticleEntity> findByCategory(ArticleCategory category);
}
