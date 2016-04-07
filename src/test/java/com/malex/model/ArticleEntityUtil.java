package com.malex.model;


import com.malex.model.entity.ArticleEntity;
import com.malex.model.entity.ImagesEntity;
import com.malex.model.enums.ArticleCategory;

import java.util.LinkedList;
import java.util.List;

public class ArticleEntityUtil {

    public static ArticleEntity getArticleEntity(){
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle("Title");
        entity.setDesctiption("Descr");
        entity.setCategory(ArticleCategory.POSTGRES);
        entity.setImage(ImagesEntityUtil.getImagesEntity());
        return entity;
    }

    public static List<ArticleEntity> getArticleEntityList(){
        List<ArticleEntity> entityList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ArticleEntity entity = new ArticleEntity();
            entity.setTitle("Title"+i);
            entity.setDesctiption("Descr"+i);
            entity.setCategory(ArticleCategory.POSTGRES);

            ImagesEntity imagesEntity = ImagesEntityUtil.getImagesEntity();
            imagesEntity.setName("Name"+i);

            entity.setImage(imagesEntity);
            entityList.add(entity);
        }

        return entityList;
    }
}
