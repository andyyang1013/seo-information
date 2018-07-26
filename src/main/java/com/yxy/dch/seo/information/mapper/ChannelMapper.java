package com.yxy.dch.seo.information.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yxy.dch.seo.information.entity.Channel;
import com.yxy.dch.seo.information.vo.ChannelVO;

import java.util.List;

/**
 * 频道mapper接口
 *
 * @author yangzhen
 */
public interface ChannelMapper extends BaseMapper<Channel> {
    Channel getDefaultChannel();

    List<ChannelVO> selectChannelList();
}
