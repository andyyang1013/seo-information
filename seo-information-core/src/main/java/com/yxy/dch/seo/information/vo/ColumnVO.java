package com.yxy.dch.seo.information.vo;

import com.yxy.dch.seo.information.entity.Column;
import lombok.Data;

@Data
public class ColumnVO extends Column {
    /**
     * 序号
     */
    private String index;
    /**
     * 栏目名称拼音
     */
    private String namePinyin;
}
