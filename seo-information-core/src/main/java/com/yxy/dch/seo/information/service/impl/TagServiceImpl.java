package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.TagMapper;
import com.yxy.dch.seo.information.service.ITagService;
import com.yxy.dch.seo.information.vo.TagVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 标签service实现类
 *
 * @author yangzhen
 */
@Service
public class TagServiceImpl extends ServiceImpl<TagMapper, Tag> implements ITagService {
    @Autowired
    private TagMapper tagMapper;

    @Override
    public TagVO create(TagVO param) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(param, tag);
        tagMapper.insert(tag);
        Tag createdTag = tagMapper.selectById(tag.getId());
        TagVO createdTagVO = new TagVO();
        BeanUtils.copyProperties(createdTag, createdTagVO);
        return createdTagVO;
    }

    @Override
    public TagVO modify(TagVO param) {
        Tag tag = tagMapper.selectById(param.getId());
        if (tag == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        BeanUtils.copyProperties(param, tag);
        tagMapper.updateById(tag);
        Tag modifiedTag = tagMapper.selectById(tag.getId());
        TagVO modifiedTagVO = new TagVO();
        BeanUtils.copyProperties(modifiedTag, modifiedTagVO);
        return modifiedTagVO;
    }

    @Override
    public Boolean remove(TagVO param) {
        Tag tag = tagMapper.selectById(param.getId());
        if (tag == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        tagMapper.deleteById(tag.getId());
        return true;
    }

    @Override
    public TagVO view(TagVO param) {
        Tag tag = tagMapper.selectById(param.getId());
        if (tag == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        TagVO tagVO = new TagVO();
        BeanUtils.copyProperties(tag, tagVO);
        return tagVO;
    }

    @Override
    public List<TagVO> listBy(TagVO param) {
        Tag tag = new Tag();
        BeanUtils.copyProperties(param, tag);
        List<Tag> tagList = tagMapper.selectList(new EntityWrapper<>(tag));
        List<TagVO> tagVOList = new ArrayList<>();
        for (Tag entity : tagList) {
            TagVO vo = new TagVO();
            BeanUtils.copyProperties(entity, vo);
            tagVOList.add(vo);
        }
        return tagVOList;
    }
}
