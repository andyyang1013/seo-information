package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Banner;
import com.yxy.dch.seo.information.entity.Channel;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.BannerMapper;
import com.yxy.dch.seo.information.service.IBannerService;
import com.yxy.dch.seo.information.service.IChannelService;
import com.yxy.dch.seo.information.vo.BannerVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * banner service实现类
 *
 * @author yangzhen
 */
@Service
public class BannerServiceImpl extends ServiceImpl<BannerMapper, Banner> implements IBannerService {
    @Autowired
    private BannerMapper bannerMapper;
    @Autowired
    private IChannelService channelService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BannerVO create(BannerVO param) {

        // 获取频道
        String channelId = param.getChannelId();
        Channel channel = channelService.getDefaultChannel(channelId);

        // 新增banner
        Banner banner = new Banner();
        BeanUtils.copyProperties(param, banner);
        banner.setChannelId(channel.getId());
        bannerMapper.insert(banner);

        // 查询新增的banner
        Banner createdBanner = bannerMapper.selectById(banner.getId());
        BannerVO createdBannerVO = new BannerVO();
        BeanUtils.copyProperties(createdBanner, createdBannerVO);

        return createdBannerVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BannerVO modify(BannerVO param) {
        Banner banner = bannerMapper.selectById(param.getId());
        if (banner == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        BeanUtils.copyProperties(param, banner);
        bannerMapper.updateById(banner);
        Banner modifiedBanner = bannerMapper.selectById(banner.getId());
        BannerVO modifiedBannerVO = new BannerVO();
        BeanUtils.copyProperties(modifiedBanner, modifiedBannerVO);
        return modifiedBannerVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean remove(BannerVO param) {
        Banner banner = bannerMapper.selectById(param.getId());
        if (banner == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        bannerMapper.deleteById(banner.getId());
        return true;
    }

    @Override
    public BannerVO view(BannerVO param) {
        Banner banner = bannerMapper.selectById(param.getId());
        if (banner == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        BannerVO bannerVO = new BannerVO();
        BeanUtils.copyProperties(banner, bannerVO);
        return bannerVO;
    }

    @Override
    public List<BannerVO> listBy(BannerVO param) {
        return bannerMapper.selectBannerList(param);
    }

}
