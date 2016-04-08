package com.malex.model;


import com.malex.model.entity.ImagesEntity;
import com.malex.model.enums.ImageType;

public class ImagesEntityUtil {

    public static ImagesEntity getImagesEntity() {
        ImagesEntity entity = new ImagesEntity();
        entity.setName("image");
        entity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        entity.setAvailable(true);
        entity.setType(ImageType.NONE);
        return entity;
    }

}
