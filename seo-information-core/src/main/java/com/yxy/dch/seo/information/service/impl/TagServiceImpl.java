package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.ArticleTagMapping;
import com.yxy.dch.seo.information.entity.Tag;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.ArticleTagMapper;
import com.yxy.dch.seo.information.mapper.TagMapper;
import com.yxy.dch.seo.information.service.ITagService;
import com.yxy.dch.seo.information.vo.ArticleTagMappingVO;
import com.yxy.dch.seo.information.vo.TagVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Autowired
    private ArticleTagMapper articleTagMapper;

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
        return tagMapper.selectTagList(param);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void save(String articleId, String tags) {
        if (StringUtils.isBlank(articleId)) {
            throw new BizException(CodeMsg.param_note_blank);
        }
        if (StringUtils.isBlank(tags)) {
            // 删除文章所有标签
            ArticleTagMapping entity=new ArticleTagMapping();
            entity.setArticleId(articleId);
            articleTagMapper.delete(new EntityWrapper<>(entity));
        }
        String[] tagArray = tags.split(",");

        // 查询文章现有标签
        List<ArticleTagMappingVO> mappingList = articleTagMapper.selectMappingList(articleId);

        // 保存tag
        for (String tagName : tagArray) {

            // 查询tag是否存在
            Tag tag = new Tag();
            tag.setName(tagName);
            Tag tagEntity = tagMapper.selectOne(tag);
            if (tagEntity == null) {
                // 新增tag
                tagMapper.insert(tag);
            }else {
                tag = tagEntity;
            }

            if (mappingList != null) {
                boolean exist = false;
                for (ArticleTagMappingVO vo : mappingList) {
                    if (vo.getTag().getName().equals(tag.getName())){
                        exist = true;
                        break;
                    }
                }
                if (!exist){
                    // 新增文章标签
                    ArticleTagMapping articleTagMapping = new ArticleTagMapping();
                    articleTagMapping.setArticleId(articleId);
                    articleTagMapping.setTagId(tag.getId());
                    articleTagMapper.insert(articleTagMapping);
                }

                // 删除文章标签
                List<ArticleTagMappingVO> delMapping = new ArrayList<>();
                for (ArticleTagMappingVO vo : mappingList){
                    boolean has = false;
                    String name = vo.getTag().getName();
                    for (String tn:tagArray){
                        if (name.equals(tn)){
                            has = true;
                        }
                    }
                    if (!has){
                        articleTagMapper.deleteById(vo.getId());
                    }
                }
            }

        }
    }
}
