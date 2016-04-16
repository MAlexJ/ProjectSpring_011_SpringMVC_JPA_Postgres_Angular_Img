package com.malex.service.impl;

import com.malex.config.AppConfigTest;
import com.malex.model.ImagesEntityUtil;
import com.malex.model.entity.ArticleBlockEntity;
import com.malex.model.entity.ImagesEntity;
import com.malex.model.enums.ImageType;
import com.malex.service.ArticleBlockService;
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

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.*;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfigTest.class})
public class ArticleBlockServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ArticleBlockService articleBlockService;

    @Autowired
    private ImagesService imagesService;

    // 1. Test:  ArticleBlockEntity save(ArticleBlockEntity entity);

    /**
     * Create ArticleBlockEntity without ImageEntity it is possible.
     */
    @Test
    @Rollback
    public void testSaveWithoutImageEntity() {
        // given
        ArticleBlockEntity entity = new ArticleBlockEntity();
        entity.setText("lalalalalalal");

        // when
        ArticleBlockEntity actualEntity = articleBlockService.save(entity);

        //then
        assertNotNull(actualEntity);
        assertEquals(entity, actualEntity);
    }

    // 2. Test:  ArticleBlockEntity save(ArticleBlockEntity entity);

    /**
     * Create ArticleBlockEntity with ImageEntity it is possible.
     */
    @Test
    @Rollback
    public void testSaveWithImageEntity_1() {
        // given
        ArticleBlockEntity entity = new ArticleBlockEntity();
        entity.setText("lalalalalalal");
        ArticleBlockEntity actualEntity = articleBlockService.save(entity);

        // when
        ImagesEntity imagesEntity = ImagesEntityUtil.getImagesEntity();
        imagesEntity.setBlock(actualEntity);
        ImagesEntity image = imagesService.save(imagesEntity);

        //then
        assertNotNull(actualEntity);
        assertEquals(entity, actualEntity);
        assertEquals(entity, image.getBlock());
    }

    // 3. Test:  ArticleBlockEntity save(ArticleBlockEntity entity);

    /**
     * Create ArticleBlockEntity with ImageEntity it is possible.
     */
    @Test
    @Rollback
    public void testSaveWithImageEntity_2() {
        // given
        ArticleBlockEntity entity = new ArticleBlockEntity();
        entity.setText("lalalalalalal");
        ArticleBlockEntity actualEntity = articleBlockService.save(entity);

        // when
        ImagesEntity imagesEntity_01 = new ImagesEntity();
        imagesEntity_01.setName("image1");
        imagesEntity_01.setImg(new byte[]{0, 11, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_01.setAvailable(true);
        imagesEntity_01.setType(ImageType.NONE);
        imagesEntity_01.setBlock(actualEntity);
        ImagesEntity image_01 = imagesService.save(imagesEntity_01);

        ImagesEntity imagesEntity_02 = new ImagesEntity();
        imagesEntity_02.setName("image2");
        imagesEntity_02.setImg(new byte[]{0, 13, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_02.setAvailable(true);
        imagesEntity_02.setType(ImageType.BLOCK);
        imagesEntity_02.setBlock(actualEntity);
        ImagesEntity image_02 = imagesService.save(imagesEntity_02);

        ImagesEntity imagesEntity_03 = new ImagesEntity();
        imagesEntity_03.setName("image3");
        imagesEntity_03.setImg(new byte[]{0, 14, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_03.setAvailable(false);
        imagesEntity_03.setType(ImageType.ARTICLE);
        imagesEntity_03.setBlock(actualEntity);
        ImagesEntity image_03 = imagesService.save(imagesEntity_03);


        //then
        assertNotNull(actualEntity);
        assertEquals(entity, actualEntity);
        assertEquals(entity, image_01.getBlock());
        assertEquals(entity, image_02.getBlock());
        assertEquals(entity, image_03.getBlock());

        assertNull(actualEntity.getImages());
    }

    // 4. Test 1: ArticleBlockEntity update(ArticleBlockEntity entity);

    /**
     * Update ArticleBlockEntity without update ImageEntity.
     */
    @Test
    @Rollback
    public void testUpdate_1() {
        // given
        ArticleBlockEntity entity = new ArticleBlockEntity();
        entity.setText("lalalalalalal");
        ArticleBlockEntity e = articleBlockService.save(entity);

        // when
        ArticleBlockEntity actualEntity = articleBlockService.findById(e.getId());
        actualEntity.setText("AFAF");
        ArticleBlockEntity expectEntity = articleBlockService.update(actualEntity);

        //then
        assertNotNull(expectEntity);
        assertEquals(actualEntity, expectEntity);
        assertEquals(actualEntity.getId(), expectEntity.getId());
    }

    // 5. Test 1: ArticleBlockEntity update(ArticleBlockEntity entity);

    /**
     * Update ArticleBlockEntity wit update ImageEntity.
     */
    @Test
    @Rollback
    public void testUpdate_2() {
        // given
        ArticleBlockEntity entity = new ArticleBlockEntity();
        entity.setText("lalalalalalal");
        ArticleBlockEntity e = articleBlockService.save(entity);

        ImagesEntity imagesEntity_01 = new ImagesEntity();
        imagesEntity_01.setName("image1");
        imagesEntity_01.setImg(new byte[]{0, 11, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_01.setAvailable(true);
        imagesEntity_01.setType(ImageType.NONE);
        imagesEntity_01.setBlock(entity);
        ImagesEntity image_01 = imagesService.save(imagesEntity_01);

        // when
        ArticleBlockEntity actualEntity = articleBlockService.findById(e.getId());
        actualEntity.setText("AFAF");
        ArticleBlockEntity expectEntity = articleBlockService.update(actualEntity);

        //then
        assertNotNull(expectEntity);
        assertEquals(actualEntity, expectEntity);
        assertEquals(actualEntity.getId(), expectEntity.getId());
        assertEquals(expectEntity, image_01.getBlock());
    }

    // 6. Test 1: void delete(Long id);

    /**
     * Delete ArticleBlockEntity without update ImageEntity.
     */
    @Test
    @Rollback
    public void testDelete_1() {
        // given
        ArticleBlockEntity entity = new ArticleBlockEntity();
        entity.setText("lalalalalalal");
        ArticleBlockEntity articleBlockEntity = articleBlockService.save(entity);

        // when
        articleBlockService.delete(articleBlockEntity.getId());
        List<ArticleBlockEntity> entityList = articleBlockService.findAll();

        //then
        assertTrue(entityList.isEmpty());
    }

    // 7. Test 1: void delete(Long id);

    /**
     * Delete ArticleBlockEntity wit update ImageEntity.
     */
    @Test
    @Rollback
    public void testDelete_2() {
        // given
        ArticleBlockEntity entity = new ArticleBlockEntity();
        entity.setText("lalalalalalal");
        ArticleBlockEntity articleBlockEntity = articleBlockService.save(entity);

        ImagesEntity imagesEntity_01 = new ImagesEntity();
        imagesEntity_01.setName("image1");
        imagesEntity_01.setImg(new byte[]{0, 11, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_01.setAvailable(true);
        imagesEntity_01.setType(ImageType.NONE);
        imagesEntity_01.setBlock(entity);
        imagesService.save(imagesEntity_01);

        // when
        articleBlockService.delete(articleBlockEntity.getId());
        List<ArticleBlockEntity> entityList = articleBlockService.findAll();
        List<ImagesEntity> imagesEntityList = imagesService.findAll();

        //then
        assertTrue(entityList.isEmpty());
        assertTrue(!imagesEntityList.isEmpty());
        assertEquals(imagesEntityList.size(), 1);
    }

    // 8. Test 1: ArticleEntity findById(Long id);

    /**
     * Find ArticleBlockEntity without equals Image
     */
    @Test
    @Rollback
    public void testFindById() {
        // given
        ArticleBlockEntity entity = new ArticleBlockEntity();
        entity.setText("lalalalalalal");
        ArticleBlockEntity articleBlockEntity = articleBlockService.save(entity);

        // when
        ArticleBlockEntity actualEntity = articleBlockService.findById(articleBlockEntity.getId());

        //then
        assertNotNull(actualEntity);
        assertEquals(entity, actualEntity);

    }

    // 8. Test 1: ArticleEntity findById(Long id);

    /**
     * FindAll ArticleBlockEntity without equals Image
     */
    @Test
    @Rollback
    public void testFindAll() {
        // given
        List<ArticleBlockEntity> entityList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ArticleBlockEntity entity = new ArticleBlockEntity();
            entity.setText("lalalalalalal__" + i);
            entityList.add(articleBlockService.save(entity));
        }

        // when
        List<ArticleBlockEntity> all = articleBlockService.findAll();

        //then
        assertNotNull(all);
        assertEquals(entityList, all);

    }

}
