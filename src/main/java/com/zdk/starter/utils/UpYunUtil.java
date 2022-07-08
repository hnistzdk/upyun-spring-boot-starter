package com.zdk.starter.utils;

import com.zdk.starter.properties.UpYunAuthProperties;
import com.zdk.starter.properties.UpYunProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.io.File;

/**
 * @author zdk
 * @date 2022/5/9 14:57
 * 工具类
 */
@Component
public class UpYunUtil {

    public static final String SEPARATOR = "/";

    @Autowired
    private UpYunAuthProperties upYunAuthProperties;

    public String buildFilePath(String fileName,String directory){
        if (StringUtils.hasLength(directory)) {
            directory = SEPARATOR;
        }
        StringBuilder path = new StringBuilder();
        path.append(File.separator)
                .append(upYunAuthProperties.getBucketName())
                .append(directory)
                .append(fileName);
        return path.toString();
    }
}
