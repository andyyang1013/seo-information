package com.yxy.dch.seo.information.service;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.Banner;
import com.yxy.dch.seo.information.vo.BannerVO;

import java.util.List;

/**
 * banner service接口
 *
 * @author yangzhen
 */
public interface IBannerService extends IService<Banner> {
    BannerVO create(BannerVO param);

    BannerVO modify(BannerVO param);

    Boolean remove(BannerVO param);

    BannerVO view(BannerVO param);

    List<BannerVO> listBy(BannerVO param);

}
