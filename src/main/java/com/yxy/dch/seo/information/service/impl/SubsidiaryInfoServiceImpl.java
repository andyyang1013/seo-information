package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.CommonConstant;
import com.yxy.dch.seo.information.entity.SubsidiaryInfo;
import com.yxy.dch.seo.information.mapper.SubsidiaryInfoMapper;
import com.yxy.dch.seo.information.service.ISubsidiaryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * 子公司信息管理 服务实现类
 *
 * @author yangzhen
 */
@Service
public class SubsidiaryInfoServiceImpl extends ServiceImpl<SubsidiaryInfoMapper, SubsidiaryInfo> implements ISubsidiaryInfoService {

    @Autowired
    private SubsidiaryInfoMapper subsidiaryInfoMapper;

    @Cacheable(value = CommonConstant.CACHE_NAME_FOLDER, key = "#apiKey")
    @Override
    public SubsidiaryInfo selectByApiKey(String apiKey) {
        return subsidiaryInfoMapper.selectByApiKey(apiKey);
    }
}
