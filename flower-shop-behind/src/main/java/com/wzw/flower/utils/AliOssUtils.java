package com.wzw.flower.utils;

import cn.gjing.tools.aliyun.oss.MultipartOssUpload;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * @Description: 阿里云OSS工具类
 * @Author: wzw
 * @Date: 2021/4/29 14:07
 * @Version: 1.0
 */
public class AliOssUtils {
    @Resource
    private MultipartOssUpload multipartOssUpload;

    public String upload(MultipartFile file){
        return this.multipartOssUpload.upload(file).getFileName();
    }
}
