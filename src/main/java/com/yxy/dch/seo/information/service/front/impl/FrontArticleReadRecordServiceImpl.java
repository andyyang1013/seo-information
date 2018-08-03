package com.yxy.dch.seo.information.service.front.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.ArticleReadRecord;
import com.yxy.dch.seo.information.mapper.ArticleReadRecordMapper;
import com.yxy.dch.seo.information.service.front.IFrontArticleReadRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontArticleReadRecordServiceImpl extends ServiceImpl<ArticleReadRecordMapper, ArticleReadRecord> implements IFrontArticleReadRecordService {
    @Autowired
    private ArticleReadRecordMapper articleReadRecordMapper;

    @Override
    public List<ArticleReadRecord> dayTopArticles() {
        return articleReadRecordMapper.dayTopArticles();
    }

    @Override
    public List<ArticleReadRecord> weekTopArticles() {
        return articleReadRecordMapper.weekTopArticles();
    }
}
