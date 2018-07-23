package com.yxy.dch.seo.information.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.service.ITagService;
import com.yxy.dch.seo.information.vo.Page;
import com.yxy.dch.seo.information.vo.TagVO;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 标签controller
 *
 * @author yangzhen
 */
@RestController
@RequestMapping("/tag")
@Api
public class TagController extends BaseController {
    @Autowired
    private ITagService tagService;

    /**
     * 新增标签
     *
     * @param param 标签
     * @return 新增的标签
     */
    @PostMapping("/create")
    public TagVO create(TagVO param) {
        return tagService.create(param);
    }

    @PostMapping("/modify")
    public TagVO modify(TagVO param) {
        return tagService.modify(param);
    }

    @PostMapping("/remove")
    public Boolean remove(TagVO param) {
        return tagService.remove(param);
    }

    @PostMapping("/view")
    public TagVO view(TagVO param) {
        return tagService.view(param);
    }

    @GetMapping("/listByPage")
    public PageInfo<TagVO> listByPage(TagVO param, Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<TagVO> list = tagService.listBy(param);
        return new PageInfo<>(list);
    }
}
