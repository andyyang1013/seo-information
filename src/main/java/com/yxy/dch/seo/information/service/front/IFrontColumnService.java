package com.yxy.dch.seo.information.service.front;

import com.baomidou.mybatisplus.service.IService;
import com.yxy.dch.seo.information.entity.Column;
import com.yxy.dch.seo.information.vo.ColumnVO;

import java.util.List;

public interface IFrontColumnService extends IService<Column> {
    List<ColumnVO> getColumnListByIndexPage(String channelId);

    ColumnVO selectColumnByNamePinyin(String namePinyin);

    List<ColumnVO> selectColumnList(String channelId);
}
