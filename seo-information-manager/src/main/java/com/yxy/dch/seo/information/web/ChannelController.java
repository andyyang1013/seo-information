package com.yxy.dch.seo.information.web;

import com.yxy.dch.seo.information.config.filter.UserReqContextUtil;
import com.yxy.dch.seo.information.service.IChannelService;
import com.yxy.dch.seo.information.vo.ChannelVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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
     * 新增频道
     *
     * @param param 频道
     * @return 新增的频道
     */
    @PostMapping("/create")
    public ChannelVO create(@Valid ChannelVO param) {
        // 操作用户ID
        Long opeUid = UserReqContextUtil.getRequestUserId();
        param.setCreateUid(opeUid);
        param.setUpdateUid(opeUid);
        return channelService.create(param);
    }

    /**
     * 修改频道
     *
     * @param param 频道
     * @return 修改后的频道
     */
    @PostMapping("/modify")
    public ChannelVO modify(@Valid ChannelVO param) {
        // 操作用户ID
        Long opeUid = UserReqContextUtil.getRequestUserId();
        param.setUpdateUid(opeUid);
        return channelService.modify(param);
    }

}
