package com.yxy.dch.seo.information.service.front.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Channel;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.ChannelMapper;
import com.yxy.dch.seo.information.service.front.IFrontChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FrontChannelServiceImpl extends ServiceImpl<ChannelMapper,Channel> implements IFrontChannelService {
    @Autowired
    private ChannelMapper channelMapper;

    @Override
    public Channel getDefaultChannel(String channelId) {
        Channel channel;
        if (channelId == null) {
            channel = channelMapper.getDefaultChannel();
            if (channel == null) {
                throw new BizException(CodeMsg.system_error);
            }
        } else {
            channel = channelMapper.selectById(channelId);
            if (channel == null) {
                throw new BizException(CodeMsg.system_error);
            }
        }
        return channel;
    }
}
