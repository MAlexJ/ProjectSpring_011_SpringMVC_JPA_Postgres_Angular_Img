package com.malex.model;


import com.malex.model.entity.ImagesEntity;
import com.malex.model.enums.ImageType;

import java.util.LinkedList;
import java.util.List;

public class ImagesEntityUtil {

    public static ImagesEntity getImagesEntity() {
        ImagesEntity entity = new ImagesEntity();
        entity.setName("image");
        entity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        entity.setAvalible(true);
        entity.setType(ImageType.NONE);
        return entity;
    }

    public static List<ImagesEntity> getImagesEntityList() {

        List<ImagesEntity> entityList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ImagesEntity entity = new ImagesEntity();
            entity.setName("image" + i);
            entity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
            entity.setAvalible((i % 2 == 0));
            entity.setType((i % 2 == 0) ? ImageType.NONE : ImageType.BLOCK);
            entityList.add(entity);

        }
        return entityList;
    }

}
