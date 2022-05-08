package com.zdk.starter.config;

import com.UpYun;
import com.upyun.FormUploader;
import com.zdk.starter.service.UpYunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zdk
 * @date 2022/5/8 15:54
 */
@Configuration
@ConditionalOnClass(UpYunService.class)
@EnableConfigurationProperties(UpYunProperties.class)
public class UpYunAutoConfigure {

    @Autowired
    private UpYunProperties upYunProperties;


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public UpYunService upYunService(){
        return new UpYunService();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public FormUploader getFormUploader(){
        return new FormUploader(upYunProperties.getBucketName(), upYunProperties.getUserName(), upYunProperties.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public UpYun getUpYun(){
        return new UpYun(upYunProperties.getBucketName(), upYunProperties.getUserName(), upYunProperties.getPassword());
    }
}
