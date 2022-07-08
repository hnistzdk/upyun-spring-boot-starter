package com.zdk.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 认证相关属性
 * @author zhangdikai
 * @date 2022-07-08 9:45
 */
@ConfigurationProperties(prefix = "up-yun.auth")
public class UpYunAuthProperties {
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
}
