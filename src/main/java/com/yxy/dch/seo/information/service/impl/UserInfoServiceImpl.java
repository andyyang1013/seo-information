package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.UserInfo;
import com.yxy.dch.seo.information.mapper.UserInfoMapper;
import com.yxy.dch.seo.information.service.IUserInfoService;
import org.springframework.stereotype.Service;

/**
 * 账户扩展信息表 服务实现类
 *
 * @author yangzhen
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
