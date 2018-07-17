package com.yxy.dch.seo.information.service;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.UserTemp;

/**
 * 用户信息临时表，为了接收历史数据 服务类
 *
 * @author yangzhen
 */
public interface IUserTempService extends IService<UserTemp> {

    void importHistoryData();

}
