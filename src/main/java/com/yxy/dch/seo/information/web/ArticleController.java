package com.yxy.dch.seo.information.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.config.filter.UserReqContextUtil;
import com.yxy.dch.seo.information.config.pros.MinioProperties;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.service.IArticleService;
import com.yxy.dch.seo.information.util.JacksonUtil;
import com.yxy.dch.seo.information.util.MinioUtil;
import com.yxy.dch.seo.information.vo.*;
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
 * 文章controller
 *
 * @author yangzhen
 */
@RestController
@RequestMapping("/article")
@Api
public class ArticleController extends BaseController {
    @Autowired
    private IArticleService articleService;
    @Autowired
    private MinioProperties minioProperties;

    /**
     * 新增文章
     *
     * @param param 文章
     * @return 新增的文章
     */
    @PostMapping("/create")
    public ArticleVO create(@Valid ArticleVO param) {
        if (StringUtils.isBlank(param.getName()) || param.getColumnId() == null || param.getRecommend() == null || StringUtils.isBlank(param.getContent())) {
            logger.error("新增文章参数错误({}):param={}", CodeMsg.param_note_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("新增文章:param={}", JacksonUtil.toJson(param));
        // 操作用户ID
        Long opeUid = UserReqContextUtil.getRequestUserId();
        param.setCreateUid(opeUid);
        param.setUpdateUid(opeUid);
        ArticleVO articleVO = articleService.create(param);
        logger.info("新增文章成功,result={}", JacksonUtil.toJson(articleVO));
        return articleVO;
    }

    /**
     * 删除文章
     *
     * @param param 文章
     * @return 成功true/失败false
     */
    @PostMapping("/remove")
    public Boolean remove(ArticleVO param) {
        if (param.getId() == null) {
            logger.error("删除文章参数错误({}):param={}", CodeMsg.id_param_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.id_param_blank);
        }
        logger.info("删除文章:param={}", JacksonUtil.toJson(param));
        Boolean ret = articleService.remove(param);
        logger.info("删除文章成功:result={}", ret);
        return ret;
    }

    /**
     * 修改文章
     *
     * @param param 文章
     * @return 修改后的文章
     */
    @PostMapping("/modify")
    public ArticleVO modify(ArticleVO param) {
        if (param.getId() == null) {
            logger.error("修改文章参数错误({}):param={}", CodeMsg.id_param_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.id_param_blank);
        }
        logger.info("修改文章:param={}", JacksonUtil.toJson(param));
        ArticleVO articleVO = articleService.modify(param);
        logger.info("修改文章成功:result={}", JacksonUtil.toJson(articleVO));
        return articleVO;
    }

    /**
     * 查看文章
     *
     * @param param 文章
     * @return 文章
     */
    @PostMapping("/view")
    public ArticleVO view(ArticleVO param) {
        if (param.getId() == null) {
            logger.error("查看文章参数错误({}):param={}", CodeMsg.id_param_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.id_param_blank);
        }
        logger.info("查看文章:param={}", JacksonUtil.toJson(param));
        ArticleVO articleVO = articleService.view(param);
        logger.info("查看文章成功:result={}", JacksonUtil.toJson(articleVO));
        return articleVO;
    }

    /**
     * 分页查询文章列表
     *
     * @param param 文章
     * @param page  分页参数
     * @return 分页的文章列表
     */
    @RequestMapping("/listByPage")
    public ResponseT<List<ArticleVO>> listByPage(ArticleVO param, Page page) {
        if (page == null || page.getPageSize() == null || page.getPageNum() == null) {
            logger.error("分页查询文章列表参数错误({}):param={}", CodeMsg.user_batch_query_num_out.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.user_batch_query_num_out);
        }
        logger.info("分页查询文章列表:param={}", JacksonUtil.toJson(param));
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<ArticleVO> list = articleService.listBy(param);
        // 增加序号
        int index;
        if (page.getPageNum() == 1 || page.getPageNum() == 0) {
            index = 1;
        } else {
            index = 1 + (page.getPageNum() - 1) * page.getPageSize();
        }
        for (ArticleVO vo : list) {
            vo.setIndex(String.valueOf(index));
            ++index;
        }
        PageInfo<ArticleVO> pageInfo = new PageInfo<>(list);
        ResponseT<List<ArticleVO>> responseT = new ResponseT<>();
        responseT.setCode(CodeMsg.success.getCode());
        responseT.setCount(pageInfo.getTotal());
        responseT.setData(list);
        logger.info("分页查询文章列表成功:result={}", JacksonUtil.toJson(responseT));
        return responseT;
    }

    /**
     * 上架
     *
     * @param param 文章
     * @return 上架的文章
     */
    @PostMapping("/up")
    public ArticleVO up(ArticleVO param) {
        if (param.getId() == null) {
            logger.error("上架文章参数错误({}):param={}", CodeMsg.id_param_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.id_param_blank);
        }
        logger.info("上架文章:param={}", JacksonUtil.toJson(param));
        ArticleVO articleVO = articleService.up(param);
        logger.info("上架文章成功,result={}", JacksonUtil.toJson(articleVO));
        return articleVO;
    }

    /**
     * 下架
     *
     * @param param 文章
     * @return 下架的文章
     */
    @PostMapping("/down")
    public ArticleVO down(ArticleVO param) {
        if (param.getId() == null) {
            logger.error("下架文章参数错误({}):param={}", CodeMsg.id_param_blank.getMsg(), JacksonUtil.toJson(param));
            throw new BizException(CodeMsg.id_param_blank);
        }
        logger.info("下架文章:param={}", JacksonUtil.toJson(param));
        ArticleVO articleVO = articleService.down(param);
        logger.info("下架文章成功,result={}", JacksonUtil.toJson(articleVO));
        return articleVO;
    }


    /**
     * 上传文章内容
     *
     * @param param 文章
     * @param file  文章内容
     * @return 文章内容URL
     */
    @PostMapping("/uploadContent")
    public String uploadContent(ColumnVO param, MultipartFile file) {
        if (param.getId() == null) {
            logger.error("上传文章内容参数错误({}):param={},file={}", CodeMsg.id_param_blank.getMsg(), JacksonUtil.toJson(param), JacksonUtil.toJson(file));
            throw new BizException(CodeMsg.id_param_blank);
        }
        logger.info("上传文章内容(articleId={},contentType={},filename={},size={})", param.getId(), file.getContentType(), file.getOriginalFilename(), file.getSize());
        String articleContentBaseDir = minioProperties.getArticleContentBaseDir();
        String objectName = MinioUtil.genObjectName(articleContentBaseDir, param.getId());
        String pictureUrl = MinioUtil.upload(minioProperties, file, objectName);
        logger.info("上传文章内容成功({})", pictureUrl);
        return pictureUrl;
    }

    /**
     * 上传文章内容图片
     *
     * @param file 文章内容图片
     * @return 内容图片
     */
    @PostMapping("/uploadImg")
    public ImgVO uploadImg(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            logger.error("上传文章内容图片参数错误,文件为空");
            throw new BizException(CodeMsg.param_note_blank);
        }
        logger.info("上传文章内容图片(contentType={},filename={},size={}", file.getContentType(), file.getOriginalFilename(), file.getSize());
        String originalFilename = file.getOriginalFilename();
        String articleContentImgBaseDir = minioProperties.getArticleContentImgBaseDir();
        String objectName = MinioUtil.genObjectName(articleContentImgBaseDir, null);
        String pictureUrl = MinioUtil.upload(minioProperties, file, objectName);
        ImgVO imgVO = new ImgVO();
        imgVO.setSrc(pictureUrl);
        imgVO.setTitle(originalFilename);
        logger.info("上传文章内容图片成功({})", JacksonUtil.toJson(imgVO));
        return imgVO;
    }
}
