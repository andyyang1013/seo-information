package com.yxy.dch.seo.information.service.impl;

import com.yxy.dch.seo.information.service.IHtmlService;
import freemarker.template.TemplateException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlServiceImplTest {

    @Autowired
    private IHtmlService htmlService;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void createChannelHtml() throws IOException, TemplateException {
        htmlService.createChannelHtml();
        System.out.println();
    }

    @Test
    public void createArticleHtml() throws IOException, TemplateException {
        Long articleId = 1020208797588635649L;
        htmlService.createArticleHtml(articleId);
        System.out.println();
    }
}