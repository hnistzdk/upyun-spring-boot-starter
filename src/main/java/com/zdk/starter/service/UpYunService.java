package com.zdk.starter.service;

import com.UpYun;
import com.upyun.FormUploader;
import com.upyun.Params;
import com.upyun.Result;
import com.upyun.UpException;
import com.zdk.starter.config.UpYunProperties;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zdk
 * @date 2022/5/8 15:59
 */
public class UpYunService {

    @Autowired
    private UpYunProperties upYunProperties;

    @Autowired
    private FormUploader uploader;

    @Autowired
    private UpYun upYun;

    public Result uploadImage(byte[] file, String filename) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, SignatureException, InvalidKeyException {

        //初始化参数组 Map
        final Map<String, Object> paramsMap = new HashMap<>(4);

        //添加 SAVE_KEY 参数
        //filename为文件名(例如：12345.jpg)
        paramsMap.put(Params.SAVE_KEY, upYunProperties.getSaveKey() + filename);
        //添加同步上传作图参数 X_GMKERL_THUMB
        //限定图片宽度为 300px、锐化、压缩质量 80、存储为 png 格式（参数不区分先后顺序）
        paramsMap.put(Params.X_GMKERL_THUMB, upYunProperties.getImageParam());
        return uploader.upload(paramsMap, file);
    }

    public List<Result> uploadFiles(List<byte[]> fileList, List<String> fileName) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < fileList.size(); i++) {
            Map<String, Object> paramsMap = new HashMap<>(4);
            paramsMap.put(Params.SAVE_KEY, upYunProperties.getSaveKey() + fileName.get(i));
            Result result = uploader.upload(paramsMap, fileList.get(i));
            results.add(result);
        }
        return results;
    }

    public Boolean deleteFile(String filePath) throws UpException, IOException {
        //正确文件路径应该是域名/(文件夹名)/文件名
        return upYun.deleteFile(filePath,null );
    }
}
