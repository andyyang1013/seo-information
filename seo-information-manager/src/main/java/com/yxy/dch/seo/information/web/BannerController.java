package com.yxy.dch.seo.information.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.service.IBannerService;
import com.yxy.dch.seo.information.vo.ArticleVO;
import com.yxy.dch.seo.information.vo.BannerVO;
import com.yxy.dch.seo.information.vo.Page;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * banner controller
 *
 * @author yangzhen
 */
@RestController
@RequestMapping("/banner")
@Api
public class BannerController extends BaseController {
    @Autowired
    private IBannerService bannerService;

    /**
     * 新增banner
     * @param param banner
     * @return 新增的banner
     */
    @PostMapping("/create")
    public BannerVO create(BannerVO param) {
        return bannerService.create(param);
    }

    @PostMapping("/modify")
    public BannerVO modify(BannerVO param) {
        return bannerService.modify(param);
    }

    @PostMapping("/remove")
    public Boolean remove(BannerVO param) {
        return bannerService.remove(param);
    }

    @PostMapping("/view")
    public BannerVO view(BannerVO param) {
        return bannerService.view(param);
    }

    @PostMapping("/listByPage")
    public PageInfo<BannerVO> listByPage(BannerVO param, Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<BannerVO> list = bannerService.listBy(param);
        return new PageInfo<>(list);
    }
}
