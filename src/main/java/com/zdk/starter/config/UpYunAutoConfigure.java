package com.zdk.starter.config;

import com.UpYun;
import com.upyun.*;
import com.zdk.starter.properties.UpYunAuthProperties;
import com.zdk.starter.properties.UpYunProperties;
import com.zdk.starter.properties.UpYunUploadParamProperties;
import com.zdk.starter.service.UpYunOssService;
import org.springframework.beans.factory.annotation.Autowired;
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
@ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
@EnableConfigurationProperties(value = {UpYunProperties.class,UpYunAuthProperties.class, UpYunUploadParamProperties.class})
public class UpYunAutoConfigure {

    @Autowired
    private UpYunAuthProperties upYunAuthProperties;

    /**
     * 一些OSS操作的封装
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public UpYunOssService upYunOssService(){
        return new UpYunOssService();
    }

    /**
     * 表单上传Bean
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public FormUploader formUploader(){
        return new FormUploader(upYunAuthProperties.getBucketName(), upYunAuthProperties.getUserName(), upYunAuthProperties.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public UpYun upYun(){
        return new UpYun(upYunAuthProperties.getBucketName(), upYunAuthProperties.getUserName(), upYunAuthProperties.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public SerialUploader serialUploader() {
        return new SerialUploader(upYunAuthProperties.getBucketName(), upYunAuthProperties.getUserName(), upYunAuthProperties.getPassword());
    }

    /**
     * 并行上传Bean
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public ParallelUploader parallelUploader() {
        return new ParallelUploader(upYunAuthProperties.getBucketName(), upYunAuthProperties.getUserName(), upYunAuthProperties.getPassword());
    }

    /**
     * 媒体处理Bean
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public MediaHandler mediaHandler() {
        return new MediaHandler(upYunAuthProperties.getBucketName(), upYunAuthProperties.getUserName(), upYunAuthProperties.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public ConvertHandler convertHandler() {
        return new ConvertHandler(upYunAuthProperties.getBucketName(), upYunAuthProperties.getUserName(), upYunAuthProperties.getPassword());
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "up-yun",value = "enable",havingValue = "true")
    public JigsawHandler jigsawHandler() {
        return new JigsawHandler(upYunAuthProperties.getBucketName(), upYunAuthProperties.getUserName(), upYunAuthProperties.getPassword());
    }
}
