package com.yxy.dch.seo.information.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.yxy.dch.seo.information.entity.Column;
import com.yxy.dch.seo.information.vo.ColumnVO;

import java.util.List;

/**
 * 栏目mapper接口
 *
 * @author yangzhen
 */
public interface ColumnMapper extends BaseMapper<Column> {
    List<ColumnVO> getColumnListByIndexPage();

    List<ColumnVO> selectColumnList(ColumnVO param);

    ColumnVO selectColumnByNamePinyin(String namePinyin);
}
