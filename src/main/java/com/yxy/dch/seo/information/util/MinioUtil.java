package com.yxy.dch.seo.information.util;

import com.yxy.dch.seo.information.config.pros.MinioProperties;
import com.yxy.dch.seo.information.exception.BizException;
import com.yxy.dch.seo.information.exception.CodeMsg;
import io.minio.MinioClient;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * minio util
 *
 * @author yangzhen
 */
public class MinioUtil {

    /**
     * 生成object name
     *
     * @param baseDir    base dir
     * @param businessId business id,eg:articleId...
     * @return object name
     */
    public static String genObjectName(String baseDir, String businessId) {
        if (businessId != null) {
            return baseDir + "/" + businessId + Toolkit.randomUUID();
        }
        return baseDir + "/" + Toolkit.randomUUID();
    }

    /**
     * 上传
     *
     * @param minioProperties minio properties
     * @param file            file
     * @param objectName      object name,generated by genObjectName(...)
     * @return img url
     */
    public static String upload(MinioProperties minioProperties, MultipartFile file, String objectName) {
        try {
            String endpoint = minioProperties.getEndpoint();
            String accessKey = minioProperties.getAccessKey();
            String secretKey = minioProperties.getSecretKey();
            String bucketName = minioProperties.getBucketName();
            MinioClient minioClient = new MinioClient(endpoint, accessKey, secretKey);
            boolean isExist = minioClient.bucketExists(bucketName);
            if (!isExist) {
                minioClient.makeBucket(bucketName);
            }
            try (InputStream inputStream = file.getInputStream()) {
                String contentType = file.getContentType();
                minioClient.putObject(bucketName, objectName, inputStream, contentType);
                return minioClient.getObjectUrl(bucketName, objectName);
            } catch (Exception e) {
                throw new BizException(CodeMsg.system_error);
            }
        } catch (Exception e) {
            throw new BizException(CodeMsg.file_system_error);
        }
    }
}
