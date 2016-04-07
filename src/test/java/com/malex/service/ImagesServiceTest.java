package com.malex.service;

import com.malex.config.AppConfigTest;
import com.malex.model.enums.ArticleCategory;
import org.apache.commons.lang3.EnumUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {AppConfigTest.class})
public class ImagesServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

    @Test
    @Rollback
    public void test() {

    }

}
