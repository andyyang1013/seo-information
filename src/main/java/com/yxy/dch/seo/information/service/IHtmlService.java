package com.yxy.dch.seo.information.service;

import com.yxy.dch.seo.information.entity.enums.GenHtmlEventEnum;

/**
 * html service
 *
 * @author yangzhen
 */
public interface IHtmlService {
    String generateHtml(GenHtmlEventEnum genHtmlEvent);
}
