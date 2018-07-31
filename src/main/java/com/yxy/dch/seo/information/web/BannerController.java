package com.yxy.dch.seo.information.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.config.filter.UserReqContextUtil;
import com.yxy.dch.seo.information.config.pros.MinioProperties;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.service.IBannerService;
import com.yxy.dch.seo.information.util.JacksonUtil;
import com.yxy.dch.seo.information.util.MinioUtil;
import com.yxy.dch.seo.information.vo.BannerVO;
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

import java.util.List;

/**
 * banner controller
 *
 * @author yangzhen
 */
@RestController
@RequestMapping("/api/banner")
@Api
public class BannerController extends BaseController {
    @Autowired
    private IBannerService bannerService;
    @Autowired
    private MinioProperties minioProperties;

    /**
     * 新增banner
     *
     * @param param banner
     * @return 新增的banner
     */
    @PostMapping("/create")
    public BannerVO create(BannerVO param) {
        if (StringUtils.isBlank(param.getName()) || param.getVisible() == null || StringUtils.isBlank(param.getPictureUrl())) {
            logger.error("新增banner参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("新增banner:param={}", JacksonUtil.toJson(param));
        // 操作用户ID
        Long opeUid = UserReqContextUtil.getRequestUserId();
        param.setCreateUid(String.valueOf(opeUid));
        param.setUpdateUid(String.valueOf(opeUid));
        BannerVO bannerVO = bannerService.create(param);
        logger.info("新增banner成功,result={}", JacksonUtil.toJson(bannerVO));
        return bannerVO;
    }

    @PostMapping("/modify")
    public BannerVO modify(BannerVO param) {
        if (StringUtils.isBlank(param.getName()) || param.getVisible() == null) {
            logger.error("修改banner参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("修改banner:param={}", JacksonUtil.toJson(param));
        // 操作用户ID
        Long opeUid = UserReqContextUtil.getRequestUserId();
        param.setUpdateUid(String.valueOf(opeUid));
        BannerVO bannerVO = bannerService.modify(param);
        logger.info("修改banner成功,result={}", JacksonUtil.toJson(bannerVO));
        return bannerVO;
    }

    @PostMapping("/remove")
    public Boolean remove(BannerVO param) {
        if (param.getId() == null) {
            logger.error("删除banner参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("删除banner:param={}", JacksonUtil.toJson(param));
        Boolean ret = bannerService.remove(param);
        logger.info("修改banner成功,result={}", ret);
        return ret;
    }

    @PostMapping("/view")
    public BannerVO view(BannerVO param) {
        if (param.getId() == null) {
            logger.error("查询banner参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("查询banner:param={}", JacksonUtil.toJson(param));
        BannerVO bannerVO = bannerService.view(param);
        logger.info("查询banner成功,result={}", JacksonUtil.toJson(bannerVO));
        return bannerVO;
    }

    @RequestMapping("/listByPage")
    public ResponseT<List<BannerVO>> listByPage(BannerVO param, Page page) {
        if (page == null || page.getPageNum() == null || page.getPageSize() == null) {
            logger.error("分页查询banner参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("分页查询banner:param={}", JacksonUtil.toJson(param));
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<BannerVO> list = bannerService.listBy(param);
        // 增加序号
        int index;
        if (page.getPageNum() == 1 || page.getPageNum() == 0) {
            index = 1;
        } else {
            index = 1 + (page.getPageNum() - 1) * page.getPageSize();
        }
        for (BannerVO vo : list) {
            vo.setIndex(String.valueOf(index));
            ++index;
        }
        PageInfo<BannerVO> pageInfo = new PageInfo<>(list);
        ResponseT<List<BannerVO>> responseT = new ResponseT<>();
        responseT.setCode(CodeMsg.success.getCode());
        responseT.setCount(pageInfo.getTotal());
        responseT.setData(list);
        logger.info("分页查询banner成功,result={}", JacksonUtil.toJson(responseT));
        return responseT;
    }

    /**
     * 上传banner图片
     *
     * @param file banner图片
     * @return banner图片
     */
    @PostMapping("/uploadImg")
    public ImgVO uploadImg(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            logger.error("上传banner图片参数错误,文件为空");
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("上传banner图片(contentType={},filename={},size={}", file.getContentType(), file.getOriginalFilename(), file.getSize());
        String originalFilename = file.getOriginalFilename();
        String channelBannerPictureBaseDir = minioProperties.getChannelBannerPictureBaseDir();
        String objectName = MinioUtil.genObjectName(channelBannerPictureBaseDir, null);
        String pictureUrl = MinioUtil.upload(minioProperties, file, objectName);
        ImgVO imgVO = new ImgVO();
        imgVO.setSrc(pictureUrl);
        imgVO.setTitle(originalFilename);
        logger.info("上传banner图片成功({})", JacksonUtil.toJson(imgVO));
        return imgVO;
    }
}
