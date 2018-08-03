package com.yxy.dch.seo.information.service.front;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.ArticleReadRecord;
import com.yxy.dch.seo.information.entity.Channel;

import java.util.List;

public interface IFrontArticleReadRecordService extends IService<ArticleReadRecord> {
    List<ArticleReadRecord> dayTopArticles();

    List<ArticleReadRecord> weekTopArticles();
}
