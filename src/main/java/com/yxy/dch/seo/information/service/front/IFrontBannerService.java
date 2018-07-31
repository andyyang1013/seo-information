package com.yxy.dch.seo.information.service.front;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.Banner;
import com.yxy.dch.seo.information.vo.BannerVO;

import java.util.List;

public interface IFrontBannerService extends IService<Banner> {
    List<BannerVO> selectDisplayableBannerList(String channelId);
}
