package com.yxy.dch.seo.information.web;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.entity.ArticleReadRecord;
import com.yxy.dch.seo.information.entity.Channel;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.service.front.*;
import com.yxy.dch.seo.information.vo.ArticleVO;
import com.yxy.dch.seo.information.vo.ColumnVO;
import org.apache.commons.lang3.StringUtils;
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
    private IFrontArticleService articleService;
    @Autowired
    private IFrontBannerService bannerService;
    @Autowired
    private IFrontColumnService columnService;
    @Autowired
    private IFrontTagService tagService;
    @Autowired
    private IFrontChannelService channelService;
    @Autowired
    private IFrontArticleReadRecordService articleReadRecordService;

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
        if (channel == null){
            logger.error("访问频道首页错误{}",CodeMsg.seo_channel_not_exist.getMsg());
            throw new BizException(CodeMsg.seo_channel_not_exist);
        }
        modelAndView.addObject("channel", channel);
        // 栏目列表（包含栏目下的文章）
        List<ColumnVO> columnList = columnService.getColumnListByIndexPage(channel.getId());
        modelAndView.addObject("columnList", columnList);
        // banner列表
        modelAndView.addObject("bannerList", bannerService.selectDisplayableBannerList(channel.getId()));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest(6));
        // 最新文章
        modelAndView.addObject("newest", articleService.newest(6));
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended(6));
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
        Channel channel = channelService.selectById(column.getChannelId());
        modelAndView.addObject("channel", channel);
        // 文章列表
        PageHelper.startPage(1, 10, true);
        List<ArticleVO> articleList = articleService.getArticlesByColNamePinyin(namePinyin);
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(articleList);
        modelAndView.addObject("articleList", articleList);
        long pageCount = pageInfo.getTotal() / 10 == 0 ? 1 : pageInfo.getTotal() / 10;
        modelAndView.addObject("pageCount", pageCount);
        // 上一页码
        modelAndView.addObject("lastPage",1);
        // 下一页码
        modelAndView.addObject("nextPage",pageCount > 1 ? 2 : 1);
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectColumnList(channel.getId()));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest(8));
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended(8));
        // 日排行榜
        PageHelper.startPage(1, 8, true);
        List<ArticleReadRecord> topArticles = articleReadRecordService.dayTopArticles();
        modelAndView.addObject("dayTopArticles", topArticles);
        // 周排行榜
        PageHelper.startPage(1, 8, true);
        List<ArticleReadRecord> weekTopArticles = articleReadRecordService.weekTopArticles();
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
        Channel channel = channelService.selectById(column.getChannelId());
        modelAndView.addObject("channel", channel);
        // 文章列表
        PageHelper.startPage(index, 10, true);
        List<ArticleVO> articleList = articleService.getArticlesByColNamePinyin(namePinyin);
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(articleList);
        modelAndView.addObject("articleList", articleList);
        long pageCount = pageInfo.getTotal() / 10 == 0 ? 1 : pageInfo.getTotal() / 10;
        modelAndView.addObject("pageCount", pageCount);
        // 上一页码
        modelAndView.addObject("lastPage",index == 1 ? 1 : index - 1);
        // 下一页码
        modelAndView.addObject("nextPage",index == pageCount ? pageCount : index + 1);
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectColumnList(channel.getId()));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest(8));
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended(8));
        // 日排行榜
        PageHelper.startPage(1, 8, true);
        List<ArticleReadRecord> topArticles = articleReadRecordService.dayTopArticles();
        modelAndView.addObject("dayTopArticles", topArticles);
        // 周排行榜
        PageHelper.startPage(1, 8, true);
        List<ArticleReadRecord> weekTopArticles = articleReadRecordService.weekTopArticles();
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
        Channel channel = channelService.getDefaultChannel(null);
        modelAndView.addObject("channel", channel);
        // 文章列表
        PageHelper.startPage(1, 10, true);
        List<ArticleVO> articleList = articleService.getArticlesByTagId(id);
        modelAndView.addObject("articleList", articleList);
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(articleList);
        long pageCount = pageInfo.getTotal() / 10 == 0 ? 1 : pageInfo.getTotal() / 10;
        modelAndView.addObject("pageCount", pageCount);
        // 上一页码
        modelAndView.addObject("lastPage",1);
        // 下一页码
        modelAndView.addObject("nextPage",pageCount > 1 ? 2 : 1);
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectColumnList(channel.getId()));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest(8));
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended(8));
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
        Channel channel = channelService.getDefaultChannel(null);
        modelAndView.addObject("channel", channel);
        // 文章列表
        PageHelper.startPage(index, 10, true);
        List<ArticleVO> articleList = articleService.getArticlesByTagId(id);
        modelAndView.addObject("articleList", articleList);
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(articleList);
        long pageCount = pageInfo.getTotal() / 10 == 0 ? 1 : pageInfo.getTotal() / 10;
        modelAndView.addObject("pageCount", pageCount);
        // 上一页码
        modelAndView.addObject("lastPage",index == 1 ? 1 : index - 1);
        // 下一页码
        modelAndView.addObject("nextPage",index == pageCount ? pageCount : index + 1);
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectColumnList(channel.getId()));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest(8));
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended(8));
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
        //经过nginx代理，获取真实的客户端请求地址.如果为空直接取客户端地址
        String clientIp = request.getHeader("X-Forwarded-For");
        if (StringUtils.isEmpty(clientIp)) {
            clientIp = request.getRemoteAddr();
        } else {
            clientIp = clientIp.split(",")[0];
        }
        // 文章页
        ModelAndView modelAndView = new ModelAndView("detail");
        // 文章
        ArticleVO param = new ArticleVO();
        param.setId(id);
        param.setClientIp(clientIp);
        ArticleVO article = articleService.view(param);
        modelAndView.addObject("article", article);
        // 上一篇文章
        ArticleVO lastArticle = articleService.selectLastArticle(article.getColumnId(),article.getId());
        modelAndView.addObject("lastArticle",lastArticle);
        // 下一篇文章
        ArticleVO nextArticle = articleService.selectNextArticle(article.getColumnId(),article.getId());
        modelAndView.addObject("nextArticle",nextArticle);
        // 频道
        Channel channel = channelService.selectById(article.getColumn().getChannelId());
        modelAndView.addObject("channel", channel);
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectColumnList(channel.getId()));
        // banner列表
        modelAndView.addObject("bannerList", bannerService.selectDisplayableBannerList(article.getColumn().getChannelId()));
        // 热门文章
        modelAndView.addObject("hottest", articleService.hottest(8));
        // 推荐文章
        modelAndView.addObject("recommended", articleService.recommended(8));
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
        // 频道
        Channel channel = channelService.getDefaultChannel(null);
        modelAndView.addObject("channel", channel);
        // 栏目列表
        modelAndView.addObject("columnList", columnService.selectColumnList(channel.getId()));
        // 标签列表
        modelAndView.addObject("tagList", tagService.selectList(new EntityWrapper<>(new Tag())));
        logger.info("访问标签首页返回{}", modelAndView);
        return modelAndView;
    }

}
