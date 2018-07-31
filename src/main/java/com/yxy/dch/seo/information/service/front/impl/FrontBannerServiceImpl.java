package com.yxy.dch.seo.information.service.front.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Banner;
import com.yxy.dch.seo.information.mapper.BannerMapper;
import com.yxy.dch.seo.information.service.front.IFrontBannerService;
import com.yxy.dch.seo.information.vo.BannerVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontBannerServiceImpl extends ServiceImpl<BannerMapper,Banner> implements IFrontBannerService {
    @Autowired
    private BannerMapper bannerMapper;

    @Override
    public List<BannerVO> selectDisplayableBannerList(String channelId) {
        return bannerMapper.selectDisplayableBannerList(channelId);
    }
}
