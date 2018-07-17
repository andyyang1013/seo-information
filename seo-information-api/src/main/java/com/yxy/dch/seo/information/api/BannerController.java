package com.yxy.dch.seo.information.api;

import com.yxy.dch.seo.information.service.IBannerService;
import com.yxy.dch.seo.information.vo.BannerVO;
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
     * 查询所有banner
     *
     * @param param banner
     * @return 所有banner
     */
    @PostMapping("/list")
    public List<BannerVO> list(BannerVO param) {
        return bannerService.listOrderBy(param);
    }
}
