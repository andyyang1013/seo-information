package com.yxy.dch.seo.information.service;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.vo.TagVO;

import java.util.List;

/**
 * 标签service接口
 *
 * @author yangzhen
 */
public interface ITagService extends IService<Tag> {
    TagVO create(TagVO param);

    TagVO modify(TagVO param);

    Boolean remove(TagVO param);

    TagVO view(TagVO param);

    List<TagVO> listBy(TagVO param);
}
