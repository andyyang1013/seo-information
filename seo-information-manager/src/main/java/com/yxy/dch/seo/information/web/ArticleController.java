package com.yxy.dch.seo.information.web;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yxy.dch.seo.information.config.filter.UserReqContextUtil;
import com.yxy.dch.seo.information.config.pros.MinioProperties;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import com.yxy.dch.seo.information.service.IArticleService;
import com.yxy.dch.seo.information.vo.ArticleVO;
import com.yxy.dch.seo.information.vo.ColumnVO;
import com.yxy.dch.seo.information.vo.Page;
import io.minio.MinioClient;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
    public ArticleVO create(ArticleVO param) {
        // 操作用户ID
        Long opeUid = UserReqContextUtil.getRequestUserId();
        param.setCreateUid(opeUid);
        param.setUpdateUid(opeUid);
        return articleService.create(param);
    }

    /**
     * 删除文章
     *
     * @param param 文章
     * @return 成功true/失败false
     */
    @PostMapping("/remove")
    public Boolean remove(ArticleVO param) {
        return articleService.remove(param);
    }

    /**
     * 修改文章
     *
     * @param param 文章
     * @return 修改后的文章
     */
    @PostMapping("/modify")
    public ArticleVO modify(ArticleVO param) {
        return articleService.modify(param);
    }

    /**
     * 查看文章
     *
     * @param param 文章
     * @return 文章
     */
    @PostMapping("/view")
    public ArticleVO view(ArticleVO param) {
        return articleService.view(param);
    }

    /**
     * 分页查询文章列表
     *
     * @param param 文章
     * @param page  分页参数
     * @return 分页的文章列表
     */
    @PostMapping("/listByPage")
    public PageInfo<ArticleVO> listByPage(ArticleVO param, Page page) {
        PageHelper.startPage(page.getPageNum(), page.getPageSize(), true);
        List<ArticleVO> list = articleService.listBy(param);
        return new PageInfo<>(list);
    }

    /**
     * 上架
     *
     * @param param 文章
     * @return 上架的文章
     */
    @PostMapping("/up")
    public ArticleVO up(ArticleVO param) {
        return articleService.up(param);
    }

    /**
     * 下架
     *
     * @param param 文章
     * @return 下架的文章
     */
    @PostMapping("/down")
    public ArticleVO down(ArticleVO param) {
        return articleService.down(param);
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
        String pictureUrl;
        try {
            MinioClient minioClient = new MinioClient(minioProperties.getEndpoint(), minioProperties.getAccessKey(), minioProperties.getSecretKey());
            String contentType = file.getContentType();
            String originalFilename = file.getOriginalFilename();
            String bucketName = minioProperties.getBucketName();
            String articleContentDir = minioProperties.getArticleContentDir();
            String objectName = articleContentDir + "/" + param.getId() + "/" + originalFilename;
            boolean isExist = minioClient.bucketExists(bucketName);
            if (!isExist) {
                minioClient.makeBucket(bucketName);
            }
            minioClient.putObject(bucketName, objectName, file.getInputStream(), contentType);
            pictureUrl = minioClient.getObjectUrl(bucketName, objectName);
        } catch (Exception e) {
            throw new BizException(CodeMsg.system_error);
        }
        return pictureUrl;
    }
}
