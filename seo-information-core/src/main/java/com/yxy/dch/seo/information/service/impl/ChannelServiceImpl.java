package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Channel;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.ChannelMapper;
import com.yxy.dch.seo.information.service.IChannelService;
import com.yxy.dch.seo.information.vo.ChannelVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 频道service实现类
 *
 * @author yangzhen
 */
@Service
public class ChannelServiceImpl extends ServiceImpl<ChannelMapper, Channel> implements IChannelService {
    @Autowired
    private ChannelMapper channelMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ChannelVO create(ChannelVO param) {
        Channel channel = new Channel();
        BeanUtils.copyProperties(param, channel);
        channelMapper.insert(channel);
        Channel createdChannel = channelMapper.selectById(channel.getId());
        ChannelVO createdChannelVO = new ChannelVO();
        BeanUtils.copyProperties(createdChannel, createdChannelVO);
        return createdChannelVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ChannelVO modify(ChannelVO param) {
        Channel channel = new Channel();
        BeanUtils.copyProperties(param, channel);
        channelMapper.updateById(channel);
        Channel updatedChannel = channelMapper.selectById(channel.getId());
        ChannelVO updatedChannelVO = new ChannelVO();
        BeanUtils.copyProperties(updatedChannel, updatedChannelVO);
        return updatedChannelVO;
    }

    @Override
    public List<ChannelVO> listBy(ChannelVO param) {
        return channelMapper.selectChannelList();
    }

    @Override
    public Channel getDefaultChannel(String channelId) {
        Channel channel;
        if (channelId == null){
            channel = channelMapper.getDefaultChannel();
            if (channel == null){
                throw new BizException(CodeMsg.system_error);
            }
        }else {
            channel = channelMapper.selectById(channelId);
            if (channel == null){
                throw new BizException(CodeMsg.system_error);
            }
        }
        return channel;
    }
}
