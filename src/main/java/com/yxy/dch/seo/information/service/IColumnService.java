package com.yxy.dch.seo.information.service;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.Column;
import com.yxy.dch.seo.information.vo.ColumnVO;

import java.util.List;

/**
 * 栏目service接口
 *
 * @author yangzhen
 */
public interface IColumnService extends IService<Column> {
    ColumnVO create(ColumnVO param);

    Boolean remove(ColumnVO param);

    ColumnVO modify(ColumnVO param);

    ColumnVO view(ColumnVO param);

    List<ColumnVO> listBy(ColumnVO param);
}
