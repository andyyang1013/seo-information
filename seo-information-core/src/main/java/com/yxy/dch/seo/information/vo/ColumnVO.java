package com.yxy.dch.seo.information.vo;

import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.entity.Column;
import lombok.Data;

import java.util.List;

@Data
public class ColumnVO extends Column {
    /**
     * 序号
     */
    private String index;
    /**
     * 栏目下面的文章列表
     */
    private List<Article> articleList;
}
