# upyun-spring-boot-starter

> 基于又拍云SDK封装的Spring Boot starter


## 使用步骤


1. 引入pom
```xml
<dependency>
    <groupId>io.github.hnistzdk</groupId>
    <artifactId>upyun-spring-boot-starter</artifactId>
    <version>1.0.3.2</version>
</dependency>
```

2. yaml配置
```yaml
up-yun:
    #必须开启enable才会正常装配
    enable: true
    auth:
        bucketName: 你的bucket
        userName: 你的操作员名
        password: 你的密码
    upload:
        param:
            # 图片参数 参考又拍云文档
            imageParam: /fw/1100/unsharp/true/quality/100/format/png
```

3. 代码示例
```java
// 注入Bean
@Resource
private UpYunOssService upYunOssService;

/**
 * 调用上传方法即可 base即文件存储的文件夹路径
 */
public Result upload(byte[] fileBytes, String filename, String base) {
        return upYunOssService.uploadFile(filename, base, fileBytes);
}

```
