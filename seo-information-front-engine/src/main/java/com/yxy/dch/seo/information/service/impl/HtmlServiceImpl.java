package com.yxy.dch.seo.information.service.impl;

import com.yxy.dch.seo.information.config.pros.FrontEngineProperties;
import com.yxy.dch.seo.information.service.IHtmlService;
import com.yxy.dch.seo.information.service.IModelService;
import com.yxy.dch.seo.information.vo.ArticleVO;
import com.yxy.dch.seo.information.vo.PageInfo;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * html service impl
 * @author yangzhen
 */
@Service
public class HtmlServiceImpl implements IHtmlService {
    @Autowired
    private IModelService modelService;
    @Autowired
    private Configuration configuration;
    @Autowired
    private FrontEngineProperties frontEngineProperties;
    @Override
    public void createChannelHtml() throws IOException, TemplateException {
        PageInfo<ArticleVO> hottest = modelService.getHottest();
        Template template = configuration.getTemplate("channel.ftl");
        File file = new File(frontEngineProperties.getHtmlPath() + "/" + "test.html");
        Writer writer = new OutputStreamWriter(new FileOutputStream(file), "UTF-8");
        Map<String, Object> model = new HashMap<>();
        model.put("hottest", hottest);
        template.process(model, writer);
    }

    @Override
    public void createArticleHtml(Long articleId) throws IOException, TemplateException {
        Template template = configuration.getTemplate("article.ftl");

        Map<String, Object> model=new HashMap<>();
        ArticleVO article = modelService.getArticle(articleId);
        model.put("article",article);

        String dir = frontEngineProperties.getHtmlPath();
        String fileName = article.getId() + ".html";
        String pathname = dir + "/" + fileName;
        File file = new File(pathname);
        Writer write = new OutputStreamWriter(new FileOutputStream(file),"UTF-8");

        template.process(model,write);
    }
}
