package com.zdk.starter.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author zdk
 * @date 2022/5/8 15:56
 */
@ConfigurationProperties(prefix = "up-yun")
public class UpYunProperties {
    private String bucketName;
    private String userName;
    private String password;
    private String saveKey;
    private String imageParam;

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

    public String getSaveKey() {
        return saveKey;
    }

    public void setSaveKey(String saveKey) {
        this.saveKey = saveKey;
    }

    public String getImageParam() {
        return imageParam;
    }

    public void setImageParam(String imageParam) {
        this.imageParam = imageParam;
    }
}
