package com.yxy.dch.seo.information.api;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.service.IArticleService;
import com.yxy.dch.seo.information.vo.ArticleVO;
import com.yxy.dch.seo.information.vo.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 文章controller
 *
 * @author yangzhen
 */
@RestController
@RequestMapping("/article")
@Api
public class ArticleController extends BaseController {
    @Autowired
    private IArticleService articleService;

    /**
     * 查看文章
     *
     * @param param 文章
     * @return 文章
     */
    @PostMapping("/read")
    public ArticleVO read(ArticleVO param) {
        return articleService.read(param);
    }

    /**
     * 查询热门文章列表
     *
     * @param page 分页参数
     * @return 热门文章列表
     */
    @PostMapping("/hottest")
    public PageInfo<ArticleVO> hottest(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<ArticleVO> list = articleService.hottest();
        return new PageInfo<>(list);
    }

    /**
     * 查询最新文章列表
     *
     * @param page 分页参数
     * @return 最新文章列表
     */
    @PostMapping("/newest")
    public PageInfo<ArticleVO> newest(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<ArticleVO> list = articleService.newest();
        return new PageInfo<>(list);
    }

    /**
     * 查询推荐文章列表
     *
     * @param page 分页参数
     * @return 推荐文章列表
     */
    @PostMapping("/recommended")
    public PageInfo<ArticleVO> recommended(Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<ArticleVO> list = articleService.recommended();
        return new PageInfo<>(list);
    }

    /**
     * 查询栏目下文章
     *
     * @param param 文章
     * @param page  分页参数
     * @return 栏目下的文章
     */
    @PostMapping("/filter/column")
    public PageInfo<ArticleVO> filterByColumn(ArticleVO param, Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<ArticleVO> list = articleService.filterByColumn(param);
        return new PageInfo<>(list);
    }

    /**
     * 查询标签下文章
     *
     * @param param 文章
     * @param page  分页参数
     * @return 标签下的文章
     */
    @PostMapping("/filter/tag")
    public PageInfo<ArticleVO> filterByTag(ArticleVO param, Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<ArticleVO> list = articleService.filterByTag(param);
        return new PageInfo<>(list);
    }

}
