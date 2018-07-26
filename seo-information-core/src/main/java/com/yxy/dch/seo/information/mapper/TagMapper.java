package com.yxy.dch.seo.information.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.vo.TagVO;

import java.util.List;

/**
 * 标签mapper接口
 *
 * @author yangzhen
 */
public interface TagMapper extends BaseMapper<Tag> {
    List<TagVO> selectTagList(TagVO param);
}
