package com.yxy.dch.seo.information.api;

import com.yxy.dch.seo.information.service.IChannelService;
import com.yxy.dch.seo.information.vo.ChannelVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 频道controller
 *
 * @author yangzhen
 */
@RestController
@RequestMapping("/channel")
@Api
public class ChannelController extends BaseController {
    @Autowired
    private IChannelService channelService;

    /**
     * 查询所有频道
     *
     * @param param 频道
     * @return 所有频道
     */
    @PostMapping("/list")
    public List<ChannelVO> list(ChannelVO param) {
        return channelService.listBy(param);
    }
}
