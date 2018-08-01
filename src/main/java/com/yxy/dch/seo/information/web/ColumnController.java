package com.yxy.dch.seo.information.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.config.filter.UserReqContextUtil;
import com.yxy.dch.seo.information.config.pros.MinioProperties;
import com.yxy.dch.seo.information.entity.User;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.service.IColumnService;
import com.yxy.dch.seo.information.util.JacksonUtil;
import com.yxy.dch.seo.information.util.MinioUtil;
import com.yxy.dch.seo.information.vo.ColumnVO;
import com.yxy.dch.seo.information.vo.ImgVO;
import com.yxy.dch.seo.information.vo.Page;
import com.yxy.dch.seo.information.vo.ResponseT;
import io.swagger.annotations.Api;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.List;

/**
 * 栏目controller
 *
 * @author yangzhen
 */
@RestController
@RequestMapping("/api/column")
@Api
public class ColumnController extends BaseController {
    @Autowired
    private IColumnService columnService;
    @Autowired
    private MinioProperties minioProperties;

    /**
     * 新增栏目
     *
     * @param param 栏目
     * @return 新增的栏目
     */
    @PostMapping("/create")
    public ColumnVO create(@Valid ColumnVO param) {
        if (StringUtils.isBlank(param.getName()) || param.getOrderNum() == null || param.getVisible() == null || StringUtils.isBlank(param.getPictureUrl())) {
            logger.error("新增栏目参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("新增栏目:param={}", JacksonUtil.toJson(param));
        // 操作用户
        User user = UserReqContextUtil.getRequestUser();
        param.setCreateUid(user.getId());
        param.setCreateUaccount(user.getAccount());
        param.setUpdateUid(user.getId());
        param.setUpdateUaccount(user.getAccount());
        ColumnVO columnVO = columnService.create(param);
        logger.info("新增栏目成功,result={}", JacksonUtil.toJson(columnVO));
        return columnVO;
    }

    /**
     * 删除栏目
     *
     * @param param 栏目
     * @return 成功true/失败false
     */
    @PostMapping("/remove")
    public Boolean remove(ColumnVO param) {
        if (param.getId() == null) {
            logger.error("删除栏目参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("删除栏目:param={}", JacksonUtil.toJson(param));
        Boolean ret = columnService.remove(param);
        logger.info("修改b栏目成功,result={}", ret);
        return ret;
    }

    /**
     * 修改栏目
     *
     * @param param 栏目
     * @return 修改后的栏目
     */
    @PostMapping("/modify")
    public ColumnVO modify(ColumnVO param) {
        if (param.getId() == null) {
            logger.error("修改栏目参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("修改栏目:param={}", JacksonUtil.toJson(param));
        // 操作用户
        User user = UserReqContextUtil.getRequestUser();
        param.setUpdateUid(user.getId());
        param.setUpdateUaccount(user.getAccount());
        ColumnVO columnVO = columnService.modify(param);
        logger.info("修改栏目成功,result={}", JacksonUtil.toJson(columnVO));
        return columnVO;
    }

    /**
     * 查看栏目
     *
     * @param param 栏目
     * @return 栏目
     */
    @PostMapping("/view")
    public ColumnVO view(ColumnVO param) {
        if (param.getId() == null) {
            logger.error("删除栏目参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("删除栏目:param={}", JacksonUtil.toJson(param));
        ColumnVO columnVO = columnService.view(param);
        logger.info("删除栏目成功,result={}", JacksonUtil.toJson(columnVO));
        return columnVO;
    }

    /**
     * 分页查询栏目列表
     *
     * @param param 栏目
     * @param page  分页参数
     * @return 分页的栏目列表
     */
    @RequestMapping("/listByPage")
    public ResponseT<List<ColumnVO>> listByPage(ColumnVO param, Page page) {
        if (page == null || page.getPageSize() == null || page.getPageNum() == null) {
            logger.error("分页查询栏目参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("分页查询栏目:param={}", JacksonUtil.toJson(param));
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<ColumnVO> list = columnService.listBy(param);
        // 增加序号
        int index;
        if (page.getPageNum() == 1 || page.getPageNum() == 0) {
            index = 1;
        } else {
            index = 1 + (page.getPageNum() - 1) * page.getPageSize();
        }
        for (ColumnVO vo : list) {
            vo.setIndex(String.valueOf(index));
            ++index;
        }
        PageInfo<ColumnVO> pageInfo = new PageInfo<>(list);
        ResponseT<List<ColumnVO>> responseT = new ResponseT<>();
        responseT.setCode(CodeMsg.success.getCode());
        responseT.setCount(pageInfo.getTotal());
        responseT.setData(list);
        logger.info("分页查询栏目成功,result={}", JacksonUtil.toJson(responseT));
        return responseT;
    }

    /**
     * 查询栏目列表
     *
     * @param param 栏目
     * @return 栏目列表
     */
    @RequestMapping("/list")
    public List<ColumnVO> list(ColumnVO param) {
        logger.info("查询栏目列表:param={}", JacksonUtil.toJson(param));
        List<ColumnVO> list = columnService.listBy(param);
        logger.info("分页查询栏目成功,result={}", JacksonUtil.toJson(list));
        return list;
    }

    /**
     * 上传栏目图片
     *
     * @param file 栏目图片
     * @return 栏目图片
     */
    @PostMapping("/uploadImg")
    public ImgVO uploadImg(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            logger.error("上传栏目图片参数错误,文件为空");
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("上传栏目图片(contentType={},filename={},size={}", file.getContentType(), file.getOriginalFilename(), file.getSize());
        String originalFilename = file.getOriginalFilename();
        String columnPictureBaseDir = minioProperties.getColumnPictureBaseDir();
        String objectName = MinioUtil.genObjectName(columnPictureBaseDir, null);
        String pictureUrl = MinioUtil.upload(minioProperties, file, objectName);
        ImgVO imgVO = new ImgVO();
        imgVO.setSrc(pictureUrl);
        imgVO.setTitle(originalFilename);
        logger.info("上传栏目图片成功({})", JacksonUtil.toJson(imgVO));
        return imgVO;
    }
}
