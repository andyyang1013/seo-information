package com.yxy.dch.seo.information.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.entity.Column;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.service.IArticleService;
import com.yxy.dch.seo.information.service.IBannerService;
import com.yxy.dch.seo.information.service.IColumnService;
import com.yxy.dch.seo.information.service.ITagService;
import com.yxy.dch.seo.information.vo.ArticleVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class PageController {
    @Autowired
    private IArticleService articleService;
    @Autowired
    private IBannerService bannerService;
    @Autowired
    private IColumnService columnService;
    @Autowired
    private ITagService tagService;
    private static final String domain = "http://www.daicaihang.com/news/";

    @RequestMapping("/")
    public ModelAndView index() {
        // 频道首页
        ModelAndView modelAndView = new ModelAndView("index");
        // 栏目列表（包含栏目下的文章）
        modelAndView.addObject("columnList", columnService.getColumnListByIndexPage());
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest());
        // 最新文章
        modelAndView.addObject("newest", articleService.newest());
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended());
        return modelAndView;
    }

    @RequestMapping("/{namePinyin}/")
    public ModelAndView column(@PathVariable("namePinyin") String namePinyin) {
        // 栏目页
        ModelAndView modelAndView = new ModelAndView("column");
        // 文章列表
        PageHelper.startPage(1, 10, true);
        List<ArticleVO> articleList = articleService.getArticlesByColNamePinyin(namePinyin);
        modelAndView.addObject("articleList", articleList);
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectList(new EntityWrapper<>(new Column())));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest());
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended());
        // 日排行榜
        PageHelper.startPage(1, 10, true);
        List<ArticleVO> topArticles = articleService.dayTopArticles();
        modelAndView.addObject("dayTopArticles", topArticles);
        // 周排行榜
        PageHelper.startPage(1, 10, true);
        List<ArticleVO> weekTopArticles = articleService.weekTopArticles();
        modelAndView.addObject("weekTopArticles", weekTopArticles);
        // 标签列表
        modelAndView.addObject("tagList", tagService.selectList(new EntityWrapper<>(new Tag())));
        return modelAndView;
    }

    @RequestMapping("/tag/{id}.html")
    public ModelAndView tag(@PathVariable("id") String id) {
        // 标签详细页
        ModelAndView modelAndView = new ModelAndView("tag");
        // 文章列表
        PageHelper.startPage(1, 10, true);
        List<ArticleVO> articleList = articleService.getArticlesByTagId(id);
        modelAndView.addObject("articleList", articleList);
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectList(new EntityWrapper<>(new Column())));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest());
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended());
        // 标签列表
        modelAndView.addObject("tagList", tagService.selectList(new EntityWrapper<>(new Tag())));
        return modelAndView;
    }

    @RequestMapping("/{id}.html")
    public ModelAndView detail(@PathVariable("id") String id) {
        // 文章页
        ModelAndView modelAndView = new ModelAndView("detail");
        // 文章
        ArticleVO param=new ArticleVO();
        param.setId(id);
        ArticleVO article = articleService.view(param);
        modelAndView.addObject("article", article);
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectList(new EntityWrapper<>(new Column())));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest());
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended());
        // 标签列表
        modelAndView.addObject("tagList", tagService.selectList(new EntityWrapper<>(new Tag())));
        return modelAndView;
    }

}
