package com.malex.repository;

import com.malex.model.entity.ImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagesRepository extends JpaRepository<ImagesEntity, Long> {
}
