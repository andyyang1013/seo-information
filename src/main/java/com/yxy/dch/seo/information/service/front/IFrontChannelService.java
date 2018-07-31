package com.yxy.dch.seo.information.service.front;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.Channel;

public interface IFrontChannelService extends IService<Channel> {
    Channel getDefaultChannel(String channelId);
}
