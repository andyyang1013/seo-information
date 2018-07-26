package com.yxy.dch.seo.information.entity.enums;

/**
 * HTML页面生成事件
 *
 * @author yangzhen
 */
public enum GenHtmlEventEnum {
    /**
     * 文章上架
     */
    ARTICLE_UP(1, "文章上架"),
    /**
     * 文章下架
     */
    ARTICLE_DOWN(2, "文章下架"),
    /**
     * 文章删除
     */
    ARTICLE_DEL(3, "文章删除");


    private int code;
    private String name;

    GenHtmlEventEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    /**
     * 获取名称
     *
     * @param code
     * @return
     */
    public String getNameByCode(int code) {
        for (GenHtmlEventEnum sexEnum : values()) {
            if (sexEnum.getCode() == code) {
                return sexEnum.getName();
            }
        }
        return null;
    }

    /**
     * 获取实例
     *
     * @param code 性别
     * @return 实例
     */
    public static GenHtmlEventEnum getInstance(int code) {
        for (GenHtmlEventEnum ins : GenHtmlEventEnum.values()) {
            if (ins.code == code) {
                return ins;
            }
        }
        return null;
    }
}
