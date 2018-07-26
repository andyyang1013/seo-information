package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Oauth;
import com.yxy.dch.seo.information.mapper.OauthMapper;
import com.yxy.dch.seo.information.service.IOauthService;
import org.springframework.stereotype.Service;

/**
 * OAuth2.0认证表，包括微信、qq，新浪微博等 服务实现类
 *
 * @author yangzhen
 */
@Service
public class OauthServiceImpl extends ServiceImpl<OauthMapper, Oauth> implements IOauthService {

}
