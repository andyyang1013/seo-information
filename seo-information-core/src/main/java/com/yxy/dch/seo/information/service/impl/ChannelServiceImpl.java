package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Channel;
import com.yxy.dch.seo.information.mapper.ChannelMapper;
import com.yxy.dch.seo.information.service.IChannelService;
import com.yxy.dch.seo.information.vo.ChannelVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        Channel channel = new Channel();
        BeanUtils.copyProperties(param, channel);
        List<Channel> channelList = channelMapper.selectList(new EntityWrapper<>(channel));
        List<ChannelVO> channelVOList = new ArrayList<>();
        for (Channel entity : channelList) {
            ChannelVO vo = new ChannelVO();
            BeanUtils.copyProperties(entity, vo);
            channelVOList.add(vo);
        }
        return channelVOList;
    }
}
