package com.zdk.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 总的属性类
 * @author zdk
 * @date 2022/5/8 15:56
 */
@ConfigurationProperties(prefix = "up-yun")
public class UpYunProperties {
    /**
     * 此属性必须配置且为true 否则自动配置失效
     */
    private Boolean enable;

    public Boolean getEnable() {
        return enable;
    }

    public void setEnable(Boolean enable) {
        this.enable = enable;
    }


}
