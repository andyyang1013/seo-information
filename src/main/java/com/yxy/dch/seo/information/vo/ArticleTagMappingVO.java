package com.yxy.dch.seo.information.vo;

import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.entity.ArticleTagMapping;
import com.yxy.dch.seo.information.entity.Tag;
import lombok.Data;

/**
 * 文章标签关联VO
 *
 * @author yangzhen
 */
@Data
public class ArticleTagMappingVO extends ArticleTagMapping {
    /**
     * 文章
     */
    private Article article;
    /**
     * 标签
     */
    private Tag tag;
}
