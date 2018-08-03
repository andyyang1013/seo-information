package com.yxy.dch.seo.information.service.front.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.mapper.TagMapper;
import com.yxy.dch.seo.information.service.front.IFrontTagService;
import com.yxy.dch.seo.information.vo.TagVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FrontTagServiceImpl extends ServiceImpl<TagMapper,Tag> implements IFrontTagService {
    @Autowired
    private TagMapper tagMapper;
    @Override
    public List<TagVO> selectTagList(Integer limit) {
        return tagMapper.selectDisplayTagList(limit);
    }
}
