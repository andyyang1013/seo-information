package com.yxy.dch.seo.information.service;

import com.yxy.dch.seo.information.vo.ArticleVO;
import com.yxy.dch.seo.information.vo.PageInfo;

/**
 * 模型service
 *
 * @author yangzhen
 */
public interface IModelService {
    PageInfo<ArticleVO> getHottest();
    ArticleVO getArticle(Long articleId);
}
