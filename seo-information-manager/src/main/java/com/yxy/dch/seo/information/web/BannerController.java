package com.yxy.dch.seo.information.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.config.pros.MinioProperties;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.service.IBannerService;
import com.yxy.dch.seo.information.util.JacksonUtil;
import com.yxy.dch.seo.information.util.MinioUtil;
import com.yxy.dch.seo.information.vo.BannerVO;
import com.yxy.dch.seo.information.vo.ImgVO;
import com.yxy.dch.seo.information.vo.Page;
import io.swagger.annotations.Api;
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
@RequestMapping("/banner")
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
        return bannerService.create(param);
    }

    @PostMapping("/modify")
    public BannerVO modify(BannerVO param) {
        return bannerService.modify(param);
    }

    @PostMapping("/remove")
    public Boolean remove(BannerVO param) {
        return bannerService.remove(param);
    }

    @PostMapping("/view")
    public BannerVO view(BannerVO param) {
        return bannerService.view(param);
    }

    @PostMapping("/listByPage")
    public PageInfo<BannerVO> listByPage(BannerVO param, Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<BannerVO> list = bannerService.listBy(param);
        return new PageInfo<>(list);
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
