package com.yxy.dch.seo.information.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.config.filter.UserReqContextUtil;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.service.ITagService;
import com.yxy.dch.seo.information.util.JacksonUtil;
import com.yxy.dch.seo.information.vo.Page;
import com.yxy.dch.seo.information.vo.TagVO;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
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
        if (StringUtils.isBlank(param.getName())){
            logger.error("新增标签参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("新增标签:param={}", JacksonUtil.toJson(param));
        // 操作用户ID
        Long opeUid = UserReqContextUtil.getRequestUserId();
        param.setCreateUid(opeUid);
        param.setUpdateUid(opeUid);
        TagVO tagVO = tagService.create(param);
        logger.info("新增标签成功,result={}", JacksonUtil.toJson(tagVO));
        return tagVO;
    }

    @PostMapping("/modify")
    public TagVO modify(TagVO param) {
        if (param.getId() == null){
            logger.error("修改标签参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("修改标签:param={}", JacksonUtil.toJson(param));
        // 操作用户ID
        Long opeUid = UserReqContextUtil.getRequestUserId();
        param.setUpdateUid(opeUid);
        TagVO tagVO = tagService.modify(param);
        logger.info("修改标签成功,result={}", JacksonUtil.toJson(tagVO));
        return tagVO;
    }

    @PostMapping("/remove")
    public Boolean remove(TagVO param) {
        if (param.getId() == null){
            logger.error("删除标签参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("删除标签:param={}", JacksonUtil.toJson(param));
        Boolean ret = tagService.remove(param);
        logger.info("删除标签成功,result={}", ret);
        return ret;
    }

    @PostMapping("/view")
    public TagVO view(TagVO param) {
        if (param.getId() == null){
            logger.error("查看标签参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("查看标签:param={}", JacksonUtil.toJson(param));
        TagVO tagVO = tagService.view(param);
        logger.info("查看标签成功,result={}", JacksonUtil.toJson(tagVO));
        return tagVO;
    }

    @GetMapping("/listByPage")
    public PageInfo<TagVO> listByPage(TagVO param, Page page) {
        if (page == null||page.getPageSize()==null||page.getPageNum()==null){
            logger.error("分页查询标签参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("分页查询标签:param={}", JacksonUtil.toJson(param));
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<TagVO> list = tagService.listBy(param);
        logger.info("分页查询标签成功,result={}", JacksonUtil.toJson(list));
        return new PageInfo<>(list);
    }
}
