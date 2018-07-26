package com.yxy.dch.seo.information.service.impl;

import com.yxy.dch.seo.information.service.IModelService;
import com.yxy.dch.seo.information.vo.ArticleVO;
import com.yxy.dch.seo.information.vo.PageInfo;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelServiceImplTest {
    @Autowired
    private IModelService modelService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getHottest() {
        PageInfo<ArticleVO> articleList = this.modelService.getHottest();
        System.out.println();
    }
}