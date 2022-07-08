package com.zdk.starter.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 上传文件相关属性
 * @author zhangdikai
 * @date 2022-07-08 10:04
 */
@ConfigurationProperties(prefix = "up-yun.upload.param")
public class UpYunUploadParamProperties {
    /**
     * 上传图片时的一些参数的字符串
     * 如:/fw/1100/unsharp/true/quality/100/format/png
     * 表示限定图片宽度为 1100px、锐化、压缩质量 100、存储为 png 格式（参数不区分先后顺序）
     */
    private String imageParam;

    /**
     * 文件设置 Content-Secret 后，文件将不能被直接访问，若需访问，需要在 URL 后加上 「间隔标识符」 和 「文件密钥」。
     * 如： 间隔符为 !，Content-Secret 为 abc，图片访问方式为： <a href="https://p.upyun.com/docs/cloud/secret.jpg!abc">...</a>。
     * 间隔标识符 用于分隔文件 URL 和文件密钥，有 3 种可选，分别是：!（感叹号/默认值）、-（中划线）和 _（下划线），
     * 可登录又拍云控制台，在 「服务」 > 「功能配置」 > 「云处理」 中设置。
     */
    private String contentSecret;

    public String getImageParam() {
        return imageParam;
    }

    public void setImageParam(String imageParam) {
        this.imageParam = imageParam;
    }

    public String getContentSecret() {
        return contentSecret;
    }

    public void setContentSecret(String contentSecret) {
        this.contentSecret = contentSecret;
    }
}
