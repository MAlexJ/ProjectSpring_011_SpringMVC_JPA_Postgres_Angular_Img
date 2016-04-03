package com.malex.service.impl;


import com.malex.config.AppConfigTest;
import com.malex.model.entity.ImagesEntity;
import com.malex.model.enums.ImageType;
import com.malex.service.ImagesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.LinkedList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfigTest.class})
public class ImagesServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ImagesService imagesService;

    //public ImagesEntity save(ImagesEntity entity)
    @Test
    @Rollback
    public void testSave() {
        // given
        ImagesEntity expectEntity = new ImagesEntity();
        expectEntity.setName("image");
        expectEntity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        expectEntity.setAvalible(true);
        expectEntity.setType(ImageType.NONE);

        // when
        ImagesEntity actualEntity = imagesService.save(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);

    }

    //public ImagesEntity update(ImagesEntity entity)
    @Test
    @Rollback
    public void testUpdate() {
        // given
        ImagesEntity entity = new ImagesEntity();
        entity.setName("image");
        entity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        entity.setAvalible(true);
        entity.setType(ImageType.NONE);

        ImagesEntity expectEntity = imagesService.save(entity);
        expectEntity.setName("image2");
        expectEntity.setImg(new byte[]{3, 1, 5, 4, 7, 5});
        expectEntity.setAvalible(false);
        expectEntity.setType(ImageType.ARTICLE);

        // when
        ImagesEntity actualEntity = imagesService.update(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity.getId(), actualEntity.getId());
        assertEquals(expectEntity, actualEntity);
    }

    //public void delete(Long id)
    @Test
    @Rollback
    public void testDelete() {
        // given
        ImagesEntity entity = new ImagesEntity();
        entity.setName("image");
        entity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        entity.setAvalible(true);
        entity.setType(ImageType.NONE);

        ImagesEntity expectEntity = imagesService.save(entity);

        // when
        imagesService.delete(expectEntity.getId());

        //then
        List<ImagesEntity> entityList = imagesService.findAll();
        assertTrue(entityList.isEmpty());
    }

    //public ImagesEntity findById(Long id)
    @Test
    @Rollback
    public void testFindById() {
        // given
        ImagesEntity entity = new ImagesEntity();
        entity.setName("image");
        entity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        entity.setAvalible(true);
        entity.setType(ImageType.NONE);

        ImagesEntity expectEntity = imagesService.save(entity);

        // when
        ImagesEntity actualEntity = imagesService.findById(expectEntity.getId());

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity.getId(), actualEntity.getId());
        assertEquals(expectEntity, actualEntity);

    }

    // public List<ImagesEntity> findAll()
    @Test
    @Rollback
    public void testFindAll() {
        // given
        List<ImagesEntity> expectEntityList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ImagesEntity entity = new ImagesEntity();
            entity.setName("image" + i);
            entity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
            entity.setAvalible((i % 2 == 0));
            entity.setType((i % 2 == 0) ? ImageType.NONE : ImageType.BLOCK);
            expectEntityList.add(entity);
            imagesService.save(entity);
        }

        // when
        List<ImagesEntity> actualEntityList = imagesService.findAll();

        //then
        assertNotNull(actualEntityList);
        assertEquals(expectEntityList, actualEntityList);
    }

}
