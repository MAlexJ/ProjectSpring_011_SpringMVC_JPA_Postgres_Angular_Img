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
        expectEntity.setAvailable(true);
        expectEntity.setType(ImageType.NONE);

        // when
        ImagesEntity actualEntity = imagesService.save(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity, actualEntity);

    }

    //public ImagesEntity save(ImagesEntity entity)
    @Test
    @Rollback
    public void testSaveType() {
        // given
        ImagesEntity expectEntity = new ImagesEntity();
        expectEntity.setName("image");
        expectEntity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        expectEntity.setAvailable(true);
        expectEntity.setType(ImageType.ARTICLE);

        // when
        ImagesEntity actualEntity = imagesService.save(expectEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(ImageType.ARTICLE, actualEntity.getType());

    }

    //public ImagesEntity update(ImagesEntity entity)
    @Test
    @Rollback
    public void testUpdate() {
        // given
        ImagesEntity entity = new ImagesEntity();
        entity.setName("image");
        entity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        entity.setAvailable(true);
        entity.setType(ImageType.NONE);

        ImagesEntity expectEntity = imagesService.save(entity);
        expectEntity.setName("image2");
        expectEntity.setImg(new byte[]{3, 1, 5, 4, 7, 5});
        expectEntity.setAvailable(false);
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
        entity.setAvailable(true);
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
        entity.setAvailable(true);
        entity.setType(ImageType.NONE);

        ImagesEntity expectEntity = imagesService.save(entity);

        // when
        ImagesEntity actualEntity = imagesService.findById(expectEntity.getId());

        //then
        assertNotNull(actualEntity);
        assertEquals(expectEntity.getId(), actualEntity.getId());
        assertEquals(expectEntity, actualEntity);
    }

    //  ImagesEntity findByName(String name);
    @Test
    @Rollback
    public void testFindByName() {

        // given
        ImagesEntity entity = new ImagesEntity();
        String name = "image";
        entity.setName(name);
        entity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        entity.setAvailable(true);
        entity.setType(ImageType.NONE);

        ImagesEntity expectEntity = imagesService.save(entity);

        // when
        ImagesEntity actualEntity = imagesService.findByName(name);

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
            entity.setAvailable((i % 2 == 0));
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

    // List<ImagesEntity> findByIsAvailable(boolean isAvailable);
    @Test
    @Rollback
    public void testFindByIsAvailable() {
        // given
        List<ImagesEntity> expectEntityList = new LinkedList<>();
        for (int i = 0; i < 5; i++) {
            ImagesEntity entity = new ImagesEntity();
            entity.setName("image" + i);
            entity.setImg(new byte[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
            entity.setAvailable((i % 2 == 0));
            entity.setType(ImageType.NONE);
            expectEntityList.add(entity);
            imagesService.save(entity);
        }

        // when
        List<ImagesEntity> actualEntityList = imagesService.findByIsAvailable(true);

        //then
        assertNotNull(actualEntityList);
        assertEquals(3, actualEntityList.size());
    }


    //List<ImagesEntity> findByIsAvailableOrType(boolean isAvailable, ImageType type);
    @Test
    @Rollback
    public void testFindByIsAvailableOrType() {
        // given
        ImagesEntity imagesEntity_01 = new ImagesEntity();
        imagesEntity_01.setName("image1");
        imagesEntity_01.setImg(new byte[]{4, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_01.setAvailable(true);
        imagesEntity_01.setType(ImageType.NONE);

        ImagesEntity imagesEntity_02 = new ImagesEntity();
        imagesEntity_02.setName("image2");
        imagesEntity_02.setImg(new byte[]{57, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_02.setAvailable(false);
        imagesEntity_02.setType(ImageType.ARTICLE);

        ImagesEntity imagesEntity_03 = new ImagesEntity();
        imagesEntity_03.setName("image3");
        imagesEntity_03.setImg(new byte[]{45, 1, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_03.setAvailable(true);
        imagesEntity_03.setType(ImageType.ARTICLE);

        imagesService.save(imagesEntity_01);
        imagesService.save(imagesEntity_02);
        ImagesEntity actualEntity_03 = imagesService.save(imagesEntity_03);

        // when
        List<ImagesEntity> actualEntityList = imagesService.findByIsAvailableAndType(true, ImageType.ARTICLE);

        //then
        assertNotNull(actualEntityList);
        assertEquals(1, actualEntityList.size());
        assertTrue(actualEntityList.contains(actualEntity_03));
    }
}
