package com.yxy.dch.seo.information.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.yxy.dch.seo.information.entity.Column;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.mapper.ColumnMapper;
import com.yxy.dch.seo.information.service.IColumnService;
import com.yxy.dch.seo.information.vo.ColumnVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public ColumnVO create(ColumnVO param) {
        Column column = new Column();
        BeanUtils.copyProperties(param, column);
        columnMapper.insert(column);
        Column createdColumn = columnMapper.selectById(column.getId());
        ColumnVO createdColumnVO = new ColumnVO();
        BeanUtils.copyProperties(createdColumn, createdColumnVO);
        return createdColumnVO;
    }

    @Override
    public Boolean remove(ColumnVO param) {
        Column column = columnMapper.selectById(param.getId());
        if (column == null) {
            throw new BizException(CodeMsg.record_not_exist);
        }
        columnMapper.deleteById(column.getId());
        return true;
    }

    @Override
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
        Column column = new Column();
        BeanUtils.copyProperties(param, column);
        List<Column> columnList = columnMapper.selectList(new EntityWrapper<>(column));
        List<ColumnVO> columnVOList = new ArrayList<>();
        for (Column entity : columnList) {
            ColumnVO vo = new ColumnVO();
            BeanUtils.copyProperties(entity, vo);
            columnVOList.add(vo);
        }
        return columnVOList;
    }

    @Override
    public List<ColumnVO> listOrderBy(ColumnVO param) {
        Column column = new Column();
        BeanUtils.copyProperties(param, column);
        List<Column> columnList = columnMapper.selectList(new EntityWrapper<>(column).where("visible={0}",1).orderBy("orderNum", true));
        List<ColumnVO> columnVOList = new ArrayList<>();
        for (Column entity : columnList) {
            ColumnVO vo = new ColumnVO();
            BeanUtils.copyProperties(entity, vo);
            columnVOList.add(vo);
        }
        return columnVOList;
    }
}
