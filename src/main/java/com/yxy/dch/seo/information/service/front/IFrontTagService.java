package com.yxy.dch.seo.information.service.front;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.vo.TagVO;

import java.util.List;

public interface IFrontTagService extends IService<Tag> {
    List<TagVO> selectTagList(Integer limit);
}
