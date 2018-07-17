package com.yxy.dch.seo.information.service;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.Channel;
import com.yxy.dch.seo.information.vo.ChannelVO;

import java.util.List;

/**
 * 频道service接口
 *
 * @author yangzhen
 */
public interface IChannelService extends IService<Channel> {
    ChannelVO create(ChannelVO param);

    ChannelVO modify(ChannelVO param);

    List<ChannelVO> listBy(ChannelVO param);
}
