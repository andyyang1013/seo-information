package com.yxy.dch.seo.information.service.impl;

import com.yxy.dch.seo.information.entity.enums.GenHtmlEventEnum;
import com.yxy.dch.seo.information.service.IHtmlService;
import org.springframework.stereotype.Service;

/**
 * html service impl
 *
 * @author yangzhen
 */
@Service
public class HtmlServiceImpl implements IHtmlService {
    @Override
    public String generateHtml(GenHtmlEventEnum genHtmlEvent) {
        switch (genHtmlEvent) {
            case ARTICLE_UP:
                break;
            case ARTICLE_DOWN:
                break;
            case ARTICLE_DEL:
                break;
            default:
                break;
        }
        return null;
    }
}
