package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Article;
import com.yxy.dch.seo.information.entity.Channel;
import com.yxy.dch.seo.information.entity.Column;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.ArticleMapper;
import com.yxy.dch.seo.information.mapper.ChannelMapper;
import com.yxy.dch.seo.information.mapper.ColumnMapper;
import com.yxy.dch.seo.information.service.IChannelService;
import com.yxy.dch.seo.information.service.IColumnService;
import com.yxy.dch.seo.information.util.PinyinUtil;
import com.yxy.dch.seo.information.vo.ColumnVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 栏目service实现类
 *
 * @author yangzhen
 */
@Service
public class ColumnServiceImpl extends ServiceImpl<ColumnMapper, Column> implements IColumnService {
    @Autowired
    private ColumnMapper columnMapper;
    @Autowired
    private ChannelMapper channelMapper;
    @Autowired
    private IChannelService channelService;
    @Autowired
    private ArticleMapper articleMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ColumnVO create(ColumnVO param) {


        // 获取频道
        String channelId = param.getChannelId();
        Channel channel = channelService.getDefaultChannel(channelId);

        // 排序检查
        Integer maxOrderNum = columnMapper.getMaxOrderNum(channel.getId());
        if (maxOrderNum == null) {
            maxOrderNum = 0;
        }
        if (param.getOrderNum() > maxOrderNum + 1) {
            throw new BizException(CodeMsg.seo_orderNum_error);
        }

        // 新增栏目
        Column column = new Column();
        BeanUtils.copyProperties(param, column);
        column.setChannelId(channel.getId());
        column.setNamePinyin(PinyinUtil.getPinYin(column.getName()));
        column.setHref("/" + PinyinUtil.getPinYin(column.getName()) + "/");
        columnMapper.insert(column);

        // 查询新增的栏目
        Column createdColumn = columnMapper.selectById(column.getId());
        ColumnVO createdColumnVO = new ColumnVO();
        BeanUtils.copyProperties(createdColumn, createdColumnVO);

        return createdColumnVO;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean remove(ColumnVO param) {
        Column column = columnMapper.selectById(param.getId());
        if (column == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        Article article = new Article();
        article.setColumnId(column.getId());
        articleMapper.delete(new EntityWrapper<>(article));
        columnMapper.deleteById(column.getId());
        return true;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ColumnVO modify(ColumnVO param) {
        Column column = columnMapper.selectById(param.getId());
        if (column == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }

        // 排序检查
        Integer maxOrderNum = columnMapper.getMaxOrderNum(column.getChannelId());
        if (maxOrderNum == null) {
            maxOrderNum = 0;
        }
        if (param.getOrderNum() > maxOrderNum + 1) {
            throw new BizException(CodeMsg.seo_orderNum_error);
        }

        BeanUtils.copyProperties(param, column);
        column.setNamePinyin(PinyinUtil.getPinYin(column.getName()));
        columnMapper.updateById(column);

        Column modifiedColumn = columnMapper.selectById(column.getId());
        ColumnVO modifiedColumnVO = new ColumnVO();
        BeanUtils.copyProperties(modifiedColumn, modifiedColumnVO);

        return modifiedColumnVO;
    }

    @Override
    public ColumnVO view(ColumnVO param) {
        Column column = columnMapper.selectById(param.getId());
        if (column == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        ColumnVO columnVO = new ColumnVO();
        BeanUtils.copyProperties(column, columnVO);
        return columnVO;
    }

    @Override
    public List<ColumnVO> listBy(ColumnVO param) {
        return columnMapper.selectColumnList(param);
    }

    @Override
    public List<ColumnVO> getColumnListByIndexPage() {
        List<ColumnVO> columnList = columnMapper.getColumnListByIndexPage();
        for (ColumnVO column : columnList) {
            List<Article> articleList = articleMapper.selectArticlesByColumnId(column.getId());
            column.setArticleList(articleList);
        }
        return columnList;
    }

    @Override
    public ColumnVO selectColumnByNamePinyin(String namePinyin) {
        return columnMapper.selectColumnByNamePinyin(namePinyin);
    }
}
