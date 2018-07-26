package com.yxy.dch.seo.information.service.impl;

import com.yxy.dch.seo.information.config.pros.FrontEngineProperties;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.service.IModelService;
import com.yxy.dch.seo.information.vo.ArticleVO;
import com.yxy.dch.seo.information.vo.PageInfo;
import com.yxy.dch.seo.information.vo.ResponseT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 模型service impl
 *
 * @author yangzhen
 */
@Service
public class ModelServiceImpl implements IModelService {
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    @Autowired
    private FrontEngineProperties frontEngineProperties;

    @Override
    public PageInfo<ArticleVO> getHottest() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = frontEngineProperties.getSourceHottestUrl();
        // 请求头
        MultiValueMap<String, String> requestHeaders = new HttpHeaders();
        requestHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.MULTIPART_FORM_DATA_VALUE);
        // 请求体
        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("pageNum", 1);
        requestBody.put("pageSize", 10);
        // 请求
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, requestHeaders);
        ResponseEntity<ResponseT<PageInfo<ArticleVO>>> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<ResponseT<PageInfo<ArticleVO>>>() {
        });
        return response.getBody().getData();
    }

    @Override
    public ArticleVO getArticle(Long articleId) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        String url = frontEngineProperties.getSourceArticleViewUrl();
        // 请求头
        MultiValueMap<String, String> requestHeaders = new HttpHeaders();
        requestHeaders.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_UTF8_VALUE);
        // 请求体
        Map<String, Object> requestBody = new LinkedHashMap<>();
        requestBody.put("id", articleId);
        // 请求
        HttpEntity<Map<String, Object>> requestEntity = new HttpEntity<>(requestBody, requestHeaders);
        ResponseEntity<ResponseT<ArticleVO>> response = restTemplate.exchange(url, HttpMethod.POST, requestEntity, new ParameterizedTypeReference<ResponseT<ArticleVO>>() {
        });
        return response.getBody().getData();
    }
}
