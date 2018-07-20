package com.yxy.dch.seo.information.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yxy.dch.seo.information.entity.ArticleRelate;

/**
 * 相关文章mapper接口
 *
 * @author yangzhen
 */
public interface ArticleRelateMapper extends BaseMapper<ArticleRelate> {
    void deleteArticleRelate(Long id);
}
