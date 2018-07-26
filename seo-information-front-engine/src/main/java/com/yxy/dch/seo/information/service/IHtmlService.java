package com.yxy.dch.seo.information.service;

import freemarker.template.TemplateException;

import java.io.IOException;

/**
 * html service
 * @author yangzhen
 */
public interface IHtmlService {
    void createChannelHtml() throws IOException, TemplateException;

    void createArticleHtml(Long articleId) throws IOException, TemplateException;
}
