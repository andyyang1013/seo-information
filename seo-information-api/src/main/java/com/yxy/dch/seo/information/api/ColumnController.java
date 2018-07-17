package com.yxy.dch.seo.information.api;

import com.yxy.dch.seo.information.service.IColumnService;
import com.yxy.dch.seo.information.vo.ColumnVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 栏目controller
 *
 * @author yangzhen
 */
@RestController
@RequestMapping("/column")
@Api
public class ColumnController extends BaseController {
    @Autowired
    private IColumnService columnService;

    /**
     * 查询所有栏目
     *
     * @param param 栏目
     * @return 栏目列表
     */
    @PostMapping("/list")
    public List<ColumnVO> list(ColumnVO param) {
        // 按序号升序排序
        return columnService.listOrderBy(param);
    }

}
