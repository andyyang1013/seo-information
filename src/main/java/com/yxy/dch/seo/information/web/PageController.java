package com.yxy.dch.seo.information.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.entity.Channel;
import com.yxy.dch.seo.information.entity.Column;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.service.*;
import com.yxy.dch.seo.information.vo.ArticleVO;
import com.yxy.dch.seo.information.vo.ColumnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/")
public class PageController extends BaseController {
    @Autowired
    private IArticleService articleService;
    @Autowired
    private IBannerService bannerService;
    @Autowired
    private IColumnService columnService;
    @Autowired
    private ITagService tagService;
    @Autowired
    private IChannelService channelService;

    /**
     * 访问频道主页
     *
     * @return 频道主页
     */
    @RequestMapping("/")
    public ModelAndView index() {
        logger.info("访问频道主页");
        // 频道首页
        ModelAndView modelAndView = new ModelAndView("index");
        // 频道
        Channel channel = channelService.getDefaultChannel(null);
        modelAndView.addObject("channel", channel);
        // 栏目列表（包含栏目下的文章）
        modelAndView.addObject("columnList", columnService.getColumnListByIndexPage());
        // banner列表
        modelAndView.addObject("bannerList", bannerService.selectDisplayableBannerList(channel.getId()));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest());
        // 最新文章
        modelAndView.addObject("newest", articleService.newest());
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended());
        logger.info("访问频道主页返回{}", modelAndView);
        return modelAndView;
    }

    /**
     * 访问栏目页
     *
     * @param namePinyin 栏目名称拼音
     * @return 栏目页
     */
    @RequestMapping("/{namePinyin}/")
    public ModelAndView column(@PathVariable("namePinyin") String namePinyin) {
        logger.info("访问栏目页,param={}", namePinyin);
        // 栏目页
        ModelAndView modelAndView = new ModelAndView("column");
        // 栏目
        ColumnVO column = columnService.selectColumnByNamePinyin(namePinyin);
        modelAndView.addObject("column", column);
        // 频道
        modelAndView.addObject("channel", channelService.selectById(column.getChannelId()));
        // 文章列表
        PageHelper.startPage(1, 10, true);
        List<ArticleVO> articleList = articleService.getArticlesByColNamePinyin(namePinyin);
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(articleList);
        modelAndView.addObject("articleList", articleList);
        modelAndView.addObject("pageCount", pageInfo.getTotal() / 10 == 0 ? 1 : pageInfo.getTotal() / 10);
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
        logger.info("访问栏目页返回{}", modelAndView);
        return modelAndView;
    }

    /**
     * 访问栏目页(分页)
     *
     * @param namePinyin 栏目名称拼音
     * @param index      页码
     * @return 栏目页
     */
    @RequestMapping("/{namePinyin}?{index}")
    public ModelAndView column(@PathVariable("namePinyin") String namePinyin, @PathVariable("index") Integer index) {
        logger.info("访问栏目页(分页)");
        // 栏目页
        ModelAndView modelAndView = new ModelAndView("column");
        // 栏目
        ColumnVO column = columnService.selectColumnByNamePinyin(namePinyin);
        modelAndView.addObject("column", column);
        // 频道
        modelAndView.addObject("channel", channelService.selectById(column.getChannelId()));
        // 文章列表
        PageHelper.startPage(index, 10, true);
        List<ArticleVO> articleList = articleService.getArticlesByColNamePinyin(namePinyin);
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(articleList);
        modelAndView.addObject("articleList", articleList);
        modelAndView.addObject("pageCount", pageInfo.getTotal() / 10 == 0 ? 1 : pageInfo.getTotal() / 10);
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

    /**
     * 访问标签详细页
     *
     * @param id 标签id
     * @return 标签详细页
     */
    @RequestMapping("/tag/{id}.html")
    public ModelAndView tag(@PathVariable("id") String id) {
        logger.info("访问标签详细页,param={}", id);
        // 标签详细页
        ModelAndView modelAndView = new ModelAndView("tag");
        // 标签
        Tag tag = tagService.selectById(id);
        modelAndView.addObject("tag", tag);
        // 频道
        modelAndView.addObject("channel", channelService.getDefaultChannel(null));
        // 文章列表
        PageHelper.startPage(1, 10, true);
        List<ArticleVO> articleList = articleService.getArticlesByTagId(id);
        modelAndView.addObject("articleList", articleList);
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(articleList);
        modelAndView.addObject("pageCount", pageInfo.getTotal() / 10 == 0 ? 1 : pageInfo.getTotal() / 10);
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectList(new EntityWrapper<>(new Column())));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest());
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended());
        // 标签列表
        modelAndView.addObject("tagList", tagService.selectList(new EntityWrapper<>(new Tag())));
        logger.info("访问标签详细页返回{}", modelAndView);
        return modelAndView;
    }

    /**
     * 访问标签详情页(分页)
     *
     * @param id    标签id
     * @param index 页码
     * @return 标签详情页
     */
    @RequestMapping("/tag/{id}.html?{index}")
    public ModelAndView tag(@PathVariable("id") String id, @PathVariable("index") Integer index) {
        logger.info("访问标签详情页(分页)");
        // 标签详细页
        ModelAndView modelAndView = new ModelAndView("tag");
        // 标签
        Tag tag = tagService.selectById(id);
        modelAndView.addObject("tag", tag);
        // 频道
        modelAndView.addObject("channel", channelService.getDefaultChannel(null));
        // 文章列表
        PageHelper.startPage(index, 10, true);
        List<ArticleVO> articleList = articleService.getArticlesByTagId(id);
        modelAndView.addObject("articleList", articleList);
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(articleList);
        modelAndView.addObject("pageCount", pageInfo.getTotal() / 10 == 0 ? 1 : pageInfo.getTotal() / 10);
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

    /**
     * 访问文章页
     *
     * @param id 文章id
     * @return 文章页
     */
    @RequestMapping("/{id}.html")
    public ModelAndView detail(@PathVariable("id") String id) {
        logger.info("访问文章页");
        // 文章页
        ModelAndView modelAndView = new ModelAndView("detail");
        // 文章
        ArticleVO param = new ArticleVO();
        param.setId(id);
        ArticleVO article = articleService.view(param);
        modelAndView.addObject("article", article);
        // 频道
        modelAndView.addObject("channel", channelService.selectById(article.getColumn().getChannelId()));
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectList(new EntityWrapper<>(new Column())));
        // banner列表
        modelAndView.addObject("bannerList", bannerService.selectDisplayableBannerList(article.getColumn().getChannelId()));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest());
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended());
        // 标签列表
        modelAndView.addObject("tagList", tagService.selectList(new EntityWrapper<>(new Tag())));
        logger.info("访问文章页返回{}", modelAndView);
        return modelAndView;
    }

    /**
     * 访问标签首页
     *
     * @return 标签首页
     */
    @RequestMapping("/tag/")
    public ModelAndView tagHome() {
        logger.info("访问标签首页");
        // 标签首页页
        ModelAndView modelAndView = new ModelAndView("tag_home");
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectList(new EntityWrapper<>(new Column())));
        // 频道
        modelAndView.addObject("channel", channelService.getDefaultChannel(null));
        // 标签列表
        modelAndView.addObject("tagList", tagService.selectList(new EntityWrapper<>(new Tag())));
        logger.info("访问标签首页返回{}", modelAndView);
        return modelAndView;
    }

}
