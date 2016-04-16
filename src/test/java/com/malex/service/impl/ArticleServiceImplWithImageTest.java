package com.malex.service.impl;

import com.malex.config.AppConfigTest;
import com.malex.model.ImagesEntityUtil;
import com.malex.model.entity.ArticleBlockEntity;
import com.malex.model.entity.ArticleEntity;
import com.malex.model.entity.ImagesEntity;
import com.malex.model.enums.ArticleCategory;
import com.malex.model.enums.ImageType;
import com.malex.service.ArticleBlockService;
import com.malex.service.ArticleService;
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

import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfigTest.class})
public class ArticleServiceImplWithImageTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private ImagesService imagesService;

    @Autowired
    private ArticleBlockService articleBlockService;

    @Test
    @Rollback
    public void testCreateBlockInToArticle() {
        // given
        ArticleEntity articleEntity = new ArticleEntity(); // 1. -> Create Article
        articleEntity.setTitle("Title");
        articleEntity.setDescription("Descr22");
        articleEntity.setCategory(ArticleCategory.ANGULAR);
        ImagesEntity image = imagesService.save(ImagesEntityUtil.getImagesEntity()); // 2. -> Create Image
        articleEntity.setImage(image);
        ArticleEntity entity = articleService.save(articleEntity);

        // when
        ArticleBlockEntity blockEntity = new ArticleBlockEntity(); // 3. -> Create Block
        blockEntity.setText("lalalalal");
        blockEntity.setArticleEntity(entity);
        ArticleBlockEntity actualBlock = articleBlockService.save(blockEntity);

        ImagesEntity imagesEntity_01 = new ImagesEntity();  // 4. -> Create Image Block
        imagesEntity_01.setName("image1");
        imagesEntity_01.setImg(new byte[]{0, 11, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_01.setAvailable(true);
        imagesEntity_01.setType(ImageType.NONE);
        imagesEntity_01.setBlock(blockEntity);
        imagesService.save(imagesEntity_01);

        entity.setBlock(actualBlock);
        ArticleEntity expectArticle = articleService.update(entity); // 5. -> Update Article

        //then
        assertNotNull(expectArticle);
        assertEquals(expectArticle.getBlock(), actualBlock);
        assertEquals(expectArticle.getBlock().getId(), actualBlock.getId());
        assertEquals(expectArticle.getBlock(), expectArticle.getBlock());
    }

    /**
     * Modyfy Block in to Article (  articleBlockService.update(actualBlock); )
     */
    @Test
    @Rollback
    public void testModifyBlockInToArticle_1() {
        // given
        // 1. -> Create Article
        ArticleEntity article = new ArticleEntity();
        article.setTitle("Title");
        article.setDescription("Descr22");
        article.setCategory(ArticleCategory.ANGULAR);
        // 2. -> Create Image
        ImagesEntity image = imagesService.save(ImagesEntityUtil.getImagesEntity());
        article.setImage(image);
        ArticleEntity entity = articleService.save(article);
        // 3. -> Create Block
        ArticleBlockEntity block = new ArticleBlockEntity();
        block.setText("lalalalal");
        block.setArticleEntity(entity);
        ArticleBlockEntity articleBlock = articleBlockService.save(block);

        ImagesEntity imagesEntity_01 = new ImagesEntity();  // 4. -> Create Image Block
        imagesEntity_01.setName("image1");
        imagesEntity_01.setImg(new byte[]{0, 11, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_01.setAvailable(true);
        imagesEntity_01.setType(ImageType.NONE);
        imagesEntity_01.setBlock(articleBlock);
        imagesService.save(imagesEntity_01);

        // 4. -> Update Article
        entity.setBlock(articleBlock);
        ArticleEntity expectArticle = articleService.update(entity);

        // when
        ArticleBlockEntity actualBlock = expectArticle.getBlock();
        actualBlock.setText("FAFAFAFAFAFFAFAFAF");
        articleBlockService.update(actualBlock);
        ArticleEntity articleEntity = articleService.findById(expectArticle.getId());


        //then
        assertNotNull(articleEntity);
        assertEquals(articleEntity.getBlock(), actualBlock);
        assertEquals(articleEntity.getBlock().getId(), actualBlock.getId());
    }

    /**
     * Modyfy Block in to Article (  articleService.update(expectArticle);  )
     */
    @Test
    @Rollback
    public void testModifyBlockInToArticle_2() {
        // given
        // 1. -> Create Article
        ArticleEntity article = new ArticleEntity();
        article.setTitle("Title");
        article.setDescription("Descr22");
        article.setCategory(ArticleCategory.ANGULAR);
        // 2. -> Create Image
        ImagesEntity image = imagesService.save(ImagesEntityUtil.getImagesEntity());
        article.setImage(image);
        ArticleEntity entity = articleService.save(article);
        // 3. -> Create Block
        ArticleBlockEntity block = new ArticleBlockEntity();
        block.setText("lalalalal");
        block.setArticleEntity(entity);
        ArticleBlockEntity articleBlock = articleBlockService.save(block);

        ImagesEntity imagesEntity_01 = new ImagesEntity();  // 4. -> Create Image Block
        imagesEntity_01.setName("image1");
        imagesEntity_01.setImg(new byte[]{0, 11, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_01.setAvailable(true);
        imagesEntity_01.setType(ImageType.NONE);
        imagesEntity_01.setBlock(articleBlock);
        imagesService.save(imagesEntity_01);

        // 4. -> Update Article
        entity.setBlock(articleBlock);
        ArticleEntity expectArticle = articleService.update(entity);

        // when
        ArticleBlockEntity actualBlock = expectArticle.getBlock();
        actualBlock.setText("FAFAFAFAFAFFAFAFAF");
        expectArticle.setBlock(actualBlock);
        ArticleEntity articleEntity = articleService.update(expectArticle);

        //then
        assertNotNull(articleEntity);
        assertEquals(articleEntity.getBlock(), actualBlock);
        assertEquals(articleEntity.getBlock().getId(), actualBlock.getId());
    }

    @Test
    @Rollback
    public void testDeleteBlockInToArticle() {
        // given
        // 1. -> Create Article
        ArticleEntity article = new ArticleEntity();
        article.setTitle("Title");
        article.setDescription("Descr22");
        article.setCategory(ArticleCategory.ANGULAR);
        // 2. -> Create Image
        ImagesEntity image = imagesService.save(ImagesEntityUtil.getImagesEntity());
        article.setImage(image);
        ArticleEntity entity = articleService.save(article);
        // 3. -> Create Block
        ArticleBlockEntity block = new ArticleBlockEntity();
        block.setText("lalalalal");
        block.setArticleEntity(entity);
        ArticleBlockEntity articleBlock = articleBlockService.save(block);

        ImagesEntity imagesEntity_01 = new ImagesEntity();  // 4. -> Create Image Block
        imagesEntity_01.setName("image1");
        imagesEntity_01.setImg(new byte[]{0, 11, 2, 3, 4, 5, 6, 7, 8, 9});
        imagesEntity_01.setAvailable(true);
        imagesEntity_01.setType(ImageType.NONE);
        imagesEntity_01.setBlock(articleBlock);
        imagesService.save(imagesEntity_01);

        // 4. -> Update Article
        entity.setBlock(articleBlock);
        ArticleEntity expectArticle = articleService.update(entity);

        // when
        articleService.delete(expectArticle.getId());
        List<ArticleEntity> list = articleService.findAll();
        List<ArticleBlockEntity> blockEntityList = articleBlockService.findAll();

        //then
        assertNotNull(list);
        assertTrue(list.isEmpty());
        assertEquals(blockEntityList.size(),1);
    }

}
