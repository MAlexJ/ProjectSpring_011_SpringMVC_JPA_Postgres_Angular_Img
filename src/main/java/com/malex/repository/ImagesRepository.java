package com.malex.repository;

import com.malex.model.entity.ImagesEntity;
import com.malex.model.enums.ImageType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImagesRepository extends JpaRepository<ImagesEntity, Long> {

    ImagesEntity findByName(String name);

    List<ImagesEntity> findByIsAvailable(boolean isAvailable);

    List<ImagesEntity> findByIsAvailableAndType(boolean isAvailable, ImageType type);
}
