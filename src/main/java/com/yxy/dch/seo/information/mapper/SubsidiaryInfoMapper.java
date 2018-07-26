package com.yxy.dch.seo.information.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yxy.dch.seo.information.entity.SubsidiaryInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 子公司信息管理 Mapper 接口
 *
 * @author yangzhen
 */
public interface SubsidiaryInfoMapper extends BaseMapper<SubsidiaryInfo> {

    SubsidiaryInfo selectByApiKey(@Param("apiKey") String apiKey);

    List<SubsidiaryInfo> selectAllAccess();

}