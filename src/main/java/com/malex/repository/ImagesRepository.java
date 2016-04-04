package com.malex.repository;

import com.malex.model.entity.ImagesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ImagesRepository extends JpaRepository<ImagesEntity, Long> {

   // @Query("SELECT i FROM ImagesEntity i WHERE i.name = :name")
    ImagesEntity findByName(@Param("name") String name);

}
