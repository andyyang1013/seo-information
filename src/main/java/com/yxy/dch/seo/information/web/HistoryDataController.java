package com.yxy.dch.seo.information.web;

import com.yxy.dch.seo.information.service.IUserTempService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 导入历史数据接口，方便通过接口调用
 *
 * @author yangzhen
 **/
@RestController
@RequestMapping("/data")
public class HistoryDataController extends BaseController {

    @Autowired
    private IUserTempService userTempService;

    /**
     * 导入历史数据
     *
     * @return
     */
    @RequestMapping("/import")
    public String importHistoryData() {
        userTempService.importHistoryData();
        return SUCCESS;
    }
}
