package com.yxy.dch.seo.information.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.config.filter.UserReqContextUtil;
import com.yxy.dch.seo.information.config.pros.MinioProperties;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.service.IColumnService;
import com.yxy.dch.seo.information.util.JacksonUtil;
import com.yxy.dch.seo.information.util.MinioUtil;
import com.yxy.dch.seo.information.vo.ColumnVO;
import com.yxy.dch.seo.information.vo.ImgVO;
import com.yxy.dch.seo.information.vo.Page;
import io.swagger.annotations.Api;
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
@RequestMapping("/column")
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
        // 操作用户ID
        Long opeUid = UserReqContextUtil.getRequestUserId();
        param.setCreateUid(opeUid);
        param.setUpdateUid(opeUid);
        return columnService.create(param);
    }

    /**
     * 删除栏目
     *
     * @param param 栏目
     * @return 成功true/失败false
     */
    @PostMapping("/remove")
    public Boolean remove(ColumnVO param) {
        return columnService.remove(param);
    }

    /**
     * 修改栏目
     *
     * @param param 栏目
     * @return 修改后的栏目
     */
    @PostMapping("/modify")
    public ColumnVO modify(ColumnVO param) {
        // 操作用户ID
        Long opeUid = UserReqContextUtil.getRequestUserId();
        param.setUpdateUid(opeUid);
        return columnService.modify(param);
    }

    /**
     * 查看栏目
     *
     * @param param 栏目
     * @return 栏目
     */
    @PostMapping("/view")
    public ColumnVO view(ColumnVO param) {
        return columnService.view(param);
    }

    /**
     * 分页查询栏目列表
     *
     * @param param 栏目
     * @param page  分页参数
     * @return 分页的栏目列表
     */
    @RequestMapping("/listByPage")
    public PageInfo<ColumnVO> listByPage(ColumnVO param, Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<ColumnVO> list = columnService.listBy(param);
        return new PageInfo<>(list);
    }

    /**
     * 查询栏目列表
     *
     * @param param 栏目
     * @return 栏目列表
     */
    @RequestMapping("/list")
    public List<ColumnVO> list(ColumnVO param) {
        return columnService.listBy(param);
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
