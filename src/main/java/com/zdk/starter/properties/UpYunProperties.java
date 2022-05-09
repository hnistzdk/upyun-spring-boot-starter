package com.zdk.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zdk
 * @date 2022/5/8 15:56
 * 属性类
 */
@ConfigurationProperties(prefix = "up-yun")
public class UpYunProperties {
    /**
     * 此属性必写 否则自动配置生效
     */
    private Boolean enable;
    /**
     * 服务名称
     */
    private String bucketName;
    /**
     * 操作员
     */
    private String userName;
    /**
     * 操作员密码
     */
    private String password;
    /**
     * 上传图片时的一些参数的字符串
     * 如:/fw/1100/unsharp/true/quality/100/format/png
     * 表示限定图片宽度为 1100px、锐化、压缩质量 100、存储为 png 格式（参数不区分先后顺序）
     */
    private String imageParam;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImageParam() {
        return imageParam;
    }

    public void setImageParam(String imageParam) {
        this.imageParam = imageParam;
    }
}
