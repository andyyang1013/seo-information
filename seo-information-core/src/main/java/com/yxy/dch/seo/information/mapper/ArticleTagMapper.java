package com.yxy.dch.seo.information.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yxy.dch.seo.information.entity.ArticleTagMapping;
import com.yxy.dch.seo.information.vo.ArticleTagMappingVO;

import java.util.List;

/**
 * 文章标签关联mapper接口
 *
 * @author yangzhen
 */
public interface ArticleTagMapper extends BaseMapper<ArticleTagMapping> {
    List<ArticleTagMappingVO> selectMappingList(String articleId);
}
