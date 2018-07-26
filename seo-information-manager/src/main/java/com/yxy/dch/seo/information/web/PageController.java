package com.yxy.dch.seo.information.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.service.IArticleService;
import com.yxy.dch.seo.information.service.IBannerService;
import com.yxy.dch.seo.information.service.IColumnService;
import com.yxy.dch.seo.information.vo.ArticleVO;
import com.yxy.dch.seo.information.vo.BannerVO;
import com.yxy.dch.seo.information.vo.ColumnVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/page")
public class PageController {
    @Autowired
    private IArticleService articleService;
    @Autowired
    private IBannerService bannerService;
    @Autowired
    private IColumnService columnService;
    private static final String domain = "http://www.daicaihang.com/news/";

    @RequestMapping("/index")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("index");
//        modelAndView.addObject("bannerList", list(new BannerVO()));
//        modelAndView.addObject("hottest", hottest(1, 10));
//        modelAndView.addObject("newest", newest(1, 10));
//        modelAndView.addObject("recommended", recommended(1, 10));
        modelAndView.addObject("columnList", getColumnListByIndexPage());
        modelAndView.addObject("hottest", getHottest());
        return modelAndView;
    }

    @RequestMapping("/detail")
    public ModelAndView detail(String id) {
        ModelAndView modelAndView = new ModelAndView("detail");
        modelAndView.addObject("columnList", getColumnListByIndexPage());
        modelAndView.addObject("article", getArticle(id));
        return modelAndView;
    }

    private ArticleVO getArticle(String id) {
        ArticleVO param = new ArticleVO();
        param.setId(id);
        return articleService.view(param);
    }

    /**
     * 热门文章
     *
     * @return 热门文章
     */
    private List<ArticleVO> getHottest() {
        PageHelper.startPage(1, 10, true);
        List<ArticleVO> list = articleService.hottest();
        return list;
    }

    private PageInfo<ArticleVO> hottest(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<ArticleVO> list = articleService.hottest();
        for (ArticleVO vo : list) {
            vo.setHref(domain + vo.getId() + ".html");
        }
        return new PageInfo<>(list);
    }

    public List<BannerVO> list(BannerVO param) {
        return bannerService.listOrderBy(param);
    }

    public PageInfo<ArticleVO> newest(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<ArticleVO> list = articleService.newest();
        for (ArticleVO vo : list) {
            vo.setHref(domain + vo.getId() + ".html");
        }
        return new PageInfo<>(list);
    }

    public PageInfo<ArticleVO> recommended(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize, true);
        List<ArticleVO> list = articleService.recommended();
        for (ArticleVO vo : list) {
            vo.setHref(domain + vo.getId() + ".html");
        }
        return new PageInfo<>(list);
    }

    /**
     * 查询首页的页头栏目列表
     *
     * @return 首页的页头栏目列表
     */
    public List<ColumnVO> getColumnListByIndexPage() {
        return columnService.getColumnListByIndexPage();
    }
}
