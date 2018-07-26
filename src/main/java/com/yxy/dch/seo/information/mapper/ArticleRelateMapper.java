package com.yxy.dch.seo.information.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yxy.dch.seo.information.entity.ArticleRelate;
import com.yxy.dch.seo.information.vo.ArticleRelateVO;

import java.util.List;

/**
 * 相关文章mapper接口
 *
 * @author yangzhen
 */
public interface ArticleRelateMapper extends BaseMapper<ArticleRelate> {
    void deleteArticleRelate(String id);

    List<ArticleRelateVO> selectRelateList(String articleId);
}
