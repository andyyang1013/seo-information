package com.yxy.dch.seo.information.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yxy.dch.seo.information.entity.ArticleReadRecord;

import java.util.List;

/**
 * 文章阅读记录mapper接口
 *
 * @author yangzhen
 */
public interface ArticleReadRecordMapper extends BaseMapper<ArticleReadRecord> {
    List<ArticleReadRecord> dayTopArticles();

    List<ArticleReadRecord> weekTopArticles();
}
