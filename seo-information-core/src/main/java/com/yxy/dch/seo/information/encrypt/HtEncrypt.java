package com.yxy.dch.seo.information.encrypt;

import com.yxy.dch.seo.information.encrypt.util.HtEncryptUtil;
import com.yxy.dch.seo.information.util.Md5Util;
import org.springframework.util.StringUtils;

/**
 * 华体的加密算法
 *
 * @author yangzhen
 */
public class HtEncrypt implements IEncrypt {
    @Override
    public String getBackPassword(String password, String salt) {
        if (StringUtils.isEmpty(password)) {
            return "";
        }
        return HtEncryptUtil.sha512(password.toLowerCase(), salt);
    }

    @Override
    public String getFrontPassword(String password, String salt) {
        if (StringUtils.isEmpty(password)) {
            return "";
        }
        return Md5Util.md5Hex(password).toLowerCase();
    }
}
