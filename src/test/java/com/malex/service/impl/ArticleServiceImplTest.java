package com.malex.service.impl;

import com.malex.config.AppConfigTest;
import com.malex.model.ImagesEntityUtil;
import com.malex.model.dto.ArticleFindDTO;
import com.malex.model.entity.ArticleEntity;
import com.malex.model.entity.ImagesEntity;
import com.malex.model.enums.ArticleCategory;
import com.malex.model.enums.ImageType;
import com.malex.service.ArticleService;
import com.malex.service.ImagesService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfigTest.class})
public class ArticleServiceImplTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Autowired
    private ArticleService articleService;

    @Autowired
    private ImagesService imagesService;


    // 1. Test:  ArticleEntity save(ArticleEntity entity);

    /**
     * Create ArticleEntity without ImageEntity it is impossible. ->> DataIntegrityViolationException
     */
    @Test(expected = DataIntegrityViolationException.class)
    @Rollback
    public void testSaveWithoutImageEntity() {
        // given
        ArticleEntity articleEntity = new ArticleEntity();
        articleEntity.setTitle("Title");
        articleEntity.setDescription("Descr");
        articleEntity.setCategory(ArticleCategory.NONE);

        // when
        ArticleEntity actualArticleEntity = articleService.save(articleEntity);
    }

    // 2. Test:  ArticleEntity save(ArticleEntity entity);

    /**
     * Create ArticleEntity with ImageEntity ->> InvalidDataAccessApiUsageException: org.hibernate.TransientPropertyValueException: Not-null property
     */
    @Test(expected = InvalidDataAccessApiUsageException.class)
    @Rollback
    public void testSaveWithImageEntity() {
        // given
        ArticleEntity expectArticleEntity = new ArticleEntity();
        expectArticleEntity.setTitle("Title");
        expectArticleEntity.setDescription("Descr");
        expectArticleEntity.setCategory(ArticleCategory.ANGULAR_JS);
        expectArticleEntity.setImage(ImagesEntityUtil.getImagesEntity());

        // when
        ArticleEntity actualArticleEntity = articleService.save(expectArticleEntity);

        //then
        assertNotNull(actualArticleEntity);
        assertEquals(expectArticleEntity, actualArticleEntity);
    }

    // 3. Test:  ArticleEntity save(ArticleEntity entity);

    /**
     * Create ArticleEntity with ImageEntity. First ImageEntity save in the DataBase.
     */
    @Test
    @Rollback
    public void testSaveWithImageEntitySaveImageToDB() {
        // given
        ArticleEntity expectArticleEntity = new ArticleEntity();
        expectArticleEntity.setTitle("Title");
        expectArticleEntity.setDescription("Descr");
        expectArticleEntity.setCategory(ArticleCategory.ANGULAR_JS);
        ImagesEntity imagesEntity = imagesService.save(ImagesEntityUtil.getImagesEntity());
        expectArticleEntity.setImage(imagesEntity);

        // when
        ArticleEntity actualArticleEntity = articleService.save(expectArticleEntity);

        //then
        assertNotNull(actualArticleEntity);
        assertEquals(expectArticleEntity, actualArticleEntity);
    }


    // 4. Test 1: ArticleEntity update(ArticleEntity entity);

    /**
     * Update ArticleEntity without update ImageEntity.
     */
    @Test
    @Rollback
    public void testUpdate() {
        // given
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle("Title");
        entity.setDescription("Descr");
        entity.setCategory(ArticleCategory.POSTGRES);
        ImagesEntity imagesEntity = imagesService.save(ImagesEntityUtil.getImagesEntity());
        entity.setImage(imagesEntity);

        ArticleEntity actualArticleEntity = articleService.save(entity);

        // when
        actualArticleEntity.setDescription("NewDesk");
        actualArticleEntity.setTitle("NewTitle");
        ArticleEntity expectArticleEntity = articleService.update(actualArticleEntity);

        //then
        assertNotNull(actualArticleEntity);
        assertEquals(expectArticleEntity.getImage().getId(), actualArticleEntity.getImage().getId());
        assertEquals(expectArticleEntity.getId(), actualArticleEntity.getId());
        assertEquals(expectArticleEntity, actualArticleEntity);

    }

    // 5. Test 2: ArticleEntity update(ArticleEntity entity);

    /**
     * Update ArticleEntity with update ImageEntity.
     */
    @Test
    @Rollback
    public void testUpdateWithImageEntity() {
        // given
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle("Title");
        entity.setDescription("Descr");
        entity.setCategory(ArticleCategory.POSTGRES);
        ImagesEntity imagesEntity = imagesService.save(ImagesEntityUtil.getImagesEntity());
        entity.setImage(imagesEntity);

        ArticleEntity actualArticleEntity = articleService.save(entity);

        // when
        actualArticleEntity.setDescription("NewDesk");
        actualArticleEntity.setTitle("NewTitle");
        actualArticleEntity.getImage().setType(ImageType.BLOCK);
        actualArticleEntity.getImage().setAvailable(false);
        actualArticleEntity.getImage().setName("newNAme");

        ArticleEntity expectArticleEntity = articleService.update(actualArticleEntity);

        //then
        assertNotNull(actualArticleEntity);
        assertEquals(expectArticleEntity.getImage().getId(), actualArticleEntity.getImage().getId());
        assertEquals(expectArticleEntity.getId(), actualArticleEntity.getId());
        assertEquals(expectArticleEntity, actualArticleEntity);

    }


    // 6. Test 1: void delete(Long id);
    @Test
    @Rollback
    public void testDelete() {
        // given
        ArticleEntity expectArticleEntity = new ArticleEntity();
        expectArticleEntity.setTitle("Title");
        expectArticleEntity.setDescription("Descr");
        expectArticleEntity.setCategory(ArticleCategory.POSTGRES);

        // need update ImageEntity
        ImagesEntity imagesEntity = ImagesEntityUtil.getImagesEntity();
        imagesEntity.setAvailable(true);
        imagesEntity.setType(ImageType.ARTICLE);
        ImagesEntity expectImagesEntity = imagesService.save(imagesEntity);

        expectArticleEntity.setImage(expectImagesEntity);

        ArticleEntity actualArticleEntity = articleService.save(expectArticleEntity);
        Long idImage = actualArticleEntity.getImage().getId();

        // when
        articleService.delete(actualArticleEntity.getId());

        //then

        assertTrue(articleService.findAll().isEmpty());
        assertTrue(!imagesService.findAll().isEmpty());
        assertEquals(expectImagesEntity, imagesService.findById(idImage));

    }

    // 7. Test 1: ArticleEntity findById(Long id);

    /**
     * Find ArticleEntity without equals Image
     */
    @Test
    @Rollback
    public void testFindById() {
        // given
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle("Title");
        entity.setDescription("Descr");
        entity.setCategory(ArticleCategory.POSTGRES);
        ImagesEntity imagesEntity = imagesService.save(ImagesEntityUtil.getImagesEntity());
        entity.setImage(imagesEntity);

        ArticleEntity expectArticleEntity = articleService.save(entity);

        // when
        ArticleEntity actualArticleEntity = articleService.findById(expectArticleEntity.getId());

        //then
        assertNotNull(actualArticleEntity);
        assertEquals(expectArticleEntity.getImage().getId(), actualArticleEntity.getImage().getId());
        assertEquals(expectArticleEntity.getId(), actualArticleEntity.getId());
        assertEquals(expectArticleEntity, actualArticleEntity);
    }

    // 8. Test 1: ArticleEntity findById(Long id);

    /**
     * Find ArticleEntity with equals ImageEntity
     */
    @Test
    @Rollback
    public void testFindByIdWithImageEntity() {
        // given
        ArticleEntity entity = new ArticleEntity();
        entity.setTitle("Title");
        entity.setDescription("Descr");
        entity.setCategory(ArticleCategory.POSTGRES);

        ImagesEntity expectImagesEntity = imagesService.save(ImagesEntityUtil.getImagesEntity());
        entity.setImage(expectImagesEntity);

        ArticleEntity expectArticleEntity = articleService.save(entity);

        // when
        ArticleEntity actualArticleEntity = articleService.findById(expectArticleEntity.getId());

        //then
        assertNotNull(actualArticleEntity);
        assertEquals(expectImagesEntity.getId(), actualArticleEntity.getImage().getId());
        assertEquals(expectImagesEntity, actualArticleEntity.getImage());
        assertEquals(expectArticleEntity.getId(), actualArticleEntity.getId());
        assertEquals(expectArticleEntity, actualArticleEntity);
    }

    // 9. List<ArticleEntity> findAll();
    @Test
    @Rollback
    public void testFindAll() {
        // given
        List<ArticleEntity> expectArticleEntityList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ArticleEntity entity = new ArticleEntity();
            entity.setTitle("Title");
            entity.setDescription("Descr");
            entity.setCategory(ArticleCategory.POSTGRES);

            ImagesEntity img = ImagesEntityUtil.getImagesEntity();
            img.setName("ManeImg" + i);
            ImagesEntity expectImagesEntity = imagesService.save(img);
            entity.setImage(expectImagesEntity);
            expectArticleEntityList.add(articleService.save(entity));
        }

        // when
        List<ArticleEntity> actualArticleEntityList = articleService.findAll();

        //then
        assertNotNull(actualArticleEntityList);
        assertEquals(expectArticleEntityList, actualArticleEntityList);
    }

    // 10. public List<ArticleFindDTO> findAllDTO()
    @Test
    @Rollback
    public void testFindAllDTO() {
        // given
        for (int i = 0; i < 2; i++) {
            ArticleEntity entity = new ArticleEntity();
            entity.setTitle("Title");
            entity.setDescription("Descr");
            entity.setCategory(ArticleCategory.ANGULAR_JS);

            ImagesEntity img = ImagesEntityUtil.getImagesEntity();
            img.setName("ManeImg" + i);
            ImagesEntity expectImagesEntity = imagesService.save(img);
            entity.setImage(expectImagesEntity);
            articleService.save(entity);
        }

        // when
        List<ArticleFindDTO> allDTO = articleService.findAllDTO();

        //then
        assertNotNull(allDTO);
        assertEquals(2, allDTO.size());
    }

    // 11. List<ArticleEntity> findByCategory(ArticleCategory category);
    @Test
    @Rollback
    public void testFindByCategory() {
        // given
        for (int i = 0; i < 5; i++) {
            ArticleEntity entity = new ArticleEntity();
            entity.setTitle("Title");
            entity.setDescription("Descr");
            entity.setCategory((i % 2 == 0) ? ArticleCategory.JAVA_SE : ArticleCategory.NONE);

            ImagesEntity img = ImagesEntityUtil.getImagesEntity();
            img.setName("ManeImg" + i);
            ImagesEntity expectImagesEntity = imagesService.save(img);
            entity.setImage(expectImagesEntity);
            articleService.save(entity);
        }
        // when
        List<ArticleEntity> actualListByCategory = articleService.findByCategory(ArticleCategory.JAVA_SE);

        //then
        assertNotNull(actualListByCategory);
        assertEquals(3, actualListByCategory.size());
    }

}
