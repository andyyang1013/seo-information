package com.yxy.dch.seo.information.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yxy.dch.seo.information.entity.Banner;
import com.yxy.dch.seo.information.vo.BannerVO;

import java.util.List;

/**
 * banner mapper接口
 *
 * @author yangzhen
 */
public interface BannerMapper extends BaseMapper<Banner> {
    List<BannerVO> selectBannerList(BannerVO param);

    List<BannerVO> selectDisplayableBannerList(String channelId);
}
