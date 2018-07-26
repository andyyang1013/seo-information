package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Channel;
import com.yxy.dch.seo.information.entity.Column;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.ChannelMapper;
import com.yxy.dch.seo.information.mapper.ColumnMapper;
import com.yxy.dch.seo.information.service.IChannelService;
import com.yxy.dch.seo.information.service.IColumnService;
import com.yxy.dch.seo.information.util.PinyinUtil;
import com.yxy.dch.seo.information.vo.ColumnVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ColumnVO create(ColumnVO param) {

        // 获取频道
        String channelId = param.getChannelId();
        Channel channel = channelService.getDefaultChannel(channelId);

        // 新增栏目
        Column column = new Column();
        BeanUtils.copyProperties(param, column);
        column.setChannelId(channel.getId());
//        column.setUrl();
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
        BeanUtils.copyProperties(param, column);
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
//        Column column = new Column();
//        BeanUtils.copyProperties(param, column);
//        List<Column> columnList = columnMapper.selectList(new EntityWrapper<>(column));
//        List<ColumnVO> columnVOList = new ArrayList<>();
//        for (Column entity : columnList) {
//            ColumnVO vo = new ColumnVO();
//            BeanUtils.copyProperties(entity, vo);
//            columnVOList.add(vo);
//        }
        return columnMapper.selectColumnList(param);
    }

    @Override
    public List<ColumnVO> listOrderBy(ColumnVO param) {
        Column column = new Column();
        BeanUtils.copyProperties(param, column);
        List<Column> columnList = columnMapper.selectList(new EntityWrapper<>(column).where("visible={0}", 1).orderBy("orderNum", true));
        List<ColumnVO> columnVOList = new ArrayList<>();
        for (Column entity : columnList) {
            ColumnVO vo = new ColumnVO();
            BeanUtils.copyProperties(entity, vo);
            columnVOList.add(vo);
        }
        return columnVOList;
    }

    @Override
    public List<ColumnVO> getColumnListByIndexPage() {
        List<ColumnVO> columnList = columnMapper.getColumnListByIndexPage();
        for (ColumnVO column : columnList) {
            String name = column.getName();
            String pinYin = PinyinUtil.getPinYin(name);
            column.setNamePinyin(pinYin);
            column.setHref(pinYin + "/");
        }
        return columnList;
    }
}
