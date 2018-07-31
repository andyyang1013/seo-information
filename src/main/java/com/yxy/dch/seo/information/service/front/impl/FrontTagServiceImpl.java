package com.yxy.dch.seo.information.service.front.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.mapper.TagMapper;
import com.yxy.dch.seo.information.service.front.IFrontTagService;
import org.springframework.stereotype.Service;

@Service
public class FrontTagServiceImpl extends ServiceImpl<TagMapper,Tag> implements IFrontTagService {
}
