package com.zdk.starter.config;

import com.UpYun;
import com.upyun.*;
import com.zdk.starter.properties.UpYunProperties;
import com.zdk.starter.service.UpYunOssService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置类 主要是配置一些UpYun-SDK中的Bean
 * @author zdk
 * @date 2022/5/8 15:54
 */
@Configuration
@ConditionalOnClass(UpYunOssService.class)
@EnableConfigurationProperties(UpYunProperties.class)
public class UpYunAutoConfigure {

    @Autowired
    private UpYunProperties upYunProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public UpYunOssService upYunOssService(){
        return new UpYunOssService();
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public FormUploader formUploader(){
        return new FormUploader(upYunProperties.getBucketName(), upYunProperties.getUserName(), upYunProperties.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public UpYun upYun(){
        return new UpYun(upYunProperties.getBucketName(), upYunProperties.getUserName(), upYunProperties.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public SerialUploader serialUploader() {
        return new SerialUploader(upYunProperties.getBucketName(), upYunProperties.getUserName(), upYunProperties.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public ParallelUploader parallelUploader() {
        return new ParallelUploader(upYunProperties.getBucketName(), upYunProperties.getUserName(), upYunProperties.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public MediaHandler mediaHandler() {
        return new MediaHandler(upYunProperties.getBucketName(), upYunProperties.getUserName(), upYunProperties.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public ConvertHandler convertHandler() {
        return new ConvertHandler(upYunProperties.getBucketName(), upYunProperties.getUserName(), upYunProperties.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public JigsawHandler jigsawHandler() {
        return new JigsawHandler(upYunProperties.getBucketName(), upYunProperties.getUserName(), upYunProperties.getPassword());
    }
}
