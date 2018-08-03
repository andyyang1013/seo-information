package com.yxy.dch.seo.information.service.front.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.entity.Column;
import com.yxy.dch.seo.information.mapper.ArticleMapper;
import com.yxy.dch.seo.information.mapper.ColumnMapper;
import com.yxy.dch.seo.information.service.front.IFrontColumnService;
import com.yxy.dch.seo.information.vo.ColumnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontColumnServiceImpl extends ServiceImpl<ColumnMapper,Column> implements IFrontColumnService {
    @Autowired
    private ColumnMapper columnMapper;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public List<ColumnVO> getColumnListByIndexPage(String channelId) {
        List<ColumnVO> columnList = columnMapper.getColumnListByIndexPage(channelId);
        for (ColumnVO column : columnList) {
            List<Article> articleList = articleMapper.selectArticlesByColumnId(column.getId());
            column.setArticleList(articleList);
        }
        return columnList;
    }

    @Override
    public ColumnVO selectColumnByNamePinyin(String namePinyin) {
        return columnMapper.selectColumnByNamePinyin(namePinyin);
    }

    @Override
    public List<ColumnVO> selectColumnList(String channelId) {
        return columnMapper.selectDisplayColumnList(channelId);
    }
}
