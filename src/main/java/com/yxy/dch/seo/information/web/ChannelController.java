package com.yxy.dch.seo.information.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.config.filter.UserReqContextUtil;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.service.IChannelService;
import com.yxy.dch.seo.information.util.JacksonUtil;
import com.yxy.dch.seo.information.vo.ChannelVO;
import com.yxy.dch.seo.information.vo.Page;
import com.yxy.dch.seo.information.vo.ResponseT;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
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
     * 新增频道
     *
     * @param param 频道
     * @return 新增的频道
     */
    @PostMapping("/create")
    public ChannelVO create(@Valid ChannelVO param) {
        // 操作用户ID
        Long opeUid = UserReqContextUtil.getRequestUserId();
        param.setCreateUid(String.valueOf(opeUid));
        param.setUpdateUid(String.valueOf(opeUid));
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
        param.setUpdateUid(String.valueOf(opeUid));
        return channelService.modify(param);
    }

    /**
     * 分页查询频道列表
     *
     * @param param 频道
     * @param page  分页参数
     * @return 分页的频道列表
     */
    @RequestMapping("/listByPage")
    public ResponseT<List<ChannelVO>> listByPage(ChannelVO param, Page page) {
        if (page == null || page.getPageSize() == null || page.getPageNum() == null) {
            logger.error("分页查询频道列表参数错误({}):param={}", CodeMsg.user_batch_query_num_out.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.user_batch_query_num_out);
        }
        logger.info("分页查询频道列表:param={}", JacksonUtil.toJson(param));
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<ChannelVO> list = channelService.listBy(param);
        // 增加序号
        int index;
        if (page.getPageNum() == 1 || page.getPageNum() == 0) {
            index = 1;
        } else {
            index = 1 + (page.getPageNum() - 1) * page.getPageSize();
        }
        for (ChannelVO vo : list) {
            vo.setIndex(String.valueOf(index));
            ++index;
        }
        PageInfo<ChannelVO> pageInfo = new PageInfo<>(list);
        ResponseT<List<ChannelVO>> responseT = new ResponseT<>();
        responseT.setCode(CodeMsg.success.getCode());
        responseT.setCount(pageInfo.getTotal());
        responseT.setData(list);
        logger.info("分页查询频道列表成功:result={}", JacksonUtil.toJson(responseT));
        return responseT;
    }

}
