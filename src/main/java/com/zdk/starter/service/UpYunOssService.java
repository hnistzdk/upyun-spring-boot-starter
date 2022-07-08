package com.zdk.starter.service;

import com.UpYun;
import com.upyun.FormUploader;
import com.upyun.Params;
import com.upyun.Result;
import com.upyun.UpException;
import com.zdk.starter.properties.UpYunProperties;
import com.zdk.starter.properties.UpYunUploadParamProperties;
import com.zdk.starter.utils.UpYunUtil;
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
 * 又拍云对象存储的一些操作的封装
 */
public class UpYunOssService {

    @Autowired
    private UpYunProperties upYunProperties;

    @Autowired
    private UpYunUploadParamProperties upYunUploadParamProperties;

    @Autowired
    private FormUploader uploader;

    @Autowired
    private UpYun upYun;

    @Autowired
    private UpYunUtil upYunUtil;

    /**
     * 上传单个图片或文件
     * @param filename 文件名
     * @param directory 存放的文件夹名
     * @param file 文件二进制数据
     * @return 上传结果
     * @throws NoSuchAlgorithmException
     * @throws SignatureException
     * @throws InvalidKeyException
     */
    public Result uploadFile(String filename, String directory, byte[] file) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        //初始化参数组 Map
        final Map<String, Object> paramsMap = new HashMap<>(4);
        String path = upYunUtil.buildFilePath(filename, directory);
        //添加 SAVE_KEY 参数
        //filename为文件名(例如：12345.jpg)
        paramsMap.put(Params.SAVE_KEY, path);
        //添加同步上传作图参数 X_GMKERL_THUMB
        //限定图片宽度为 300px、锐化、压缩质量 80、存储为 png 格式（参数不区分先后顺序）
        paramsMap.put(Params.X_GMKERL_THUMB, upYunUploadParamProperties.getImageParam());
        return uploader.upload(paramsMap, file);
    }

    /**
     *
     * @param filename 文件名
     * @param directory 存放的文件夹名
     * @param file 文件二进制数据
     * @param paramsMap 除开save_key的其它上传参数
     * @return 上传结果
     * @throws NoSuchAlgorithmException
     * @throws SignatureException
     * @throws InvalidKeyException
     */
    public Result uploadFile(String filename, String directory, byte[] file,Map<String,Object> paramsMap) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        String path = upYunUtil.buildFilePath(filename, directory);
        paramsMap.put(Params.SAVE_KEY, path);
        return uploader.upload(paramsMap, file);
    }

    /**
     * 上传多个文件或图片
     * @param fileName 文件名列表(包含文件夹路径)
     * @param fileList 文件列表
     * @return 上传结果
     * @throws NoSuchAlgorithmException
     * @throws SignatureException
     * @throws InvalidKeyException
     */
    public List<Result> uploadFiles(List<String> fileName,List<byte[]> fileList) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        List<Result> results = new ArrayList<>();
        for (int i = 0; i < fileList.size(); i++) {
            Map<String, Object> paramsMap = new HashMap<>(4);
            paramsMap.put(Params.SAVE_KEY, upYunUtil.buildFilePath(fileName.get(i), null));
            Result result = uploader.upload(paramsMap, fileList.get(i));
            results.add(result);
        }
        return results;
    }

    /**
     *
     * @param fileMap 文件名(包含文件夹路径)与二进制的map
     * @return 上传结果的List
     * @throws NoSuchAlgorithmException
     * @throws SignatureException
     * @throws InvalidKeyException
     */
    public List<Result> uploadFiles(Map<String,byte[]> fileMap) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        List<Result> results = new ArrayList<>();
        for (Map.Entry<String, byte[]> entry : fileMap.entrySet()) {
            String fileName = entry.getKey();
            byte[] file = entry.getValue();
            Map<String, Object> paramsMap = new HashMap<>(4);
            paramsMap.put(Params.SAVE_KEY, upYunUtil.buildFilePath(fileName, null));
            Result result = uploader.upload(paramsMap, file);
            results.add(result);
        }
        return results;
    }

    /**
     * 删除单个文件
     * @param filePath 文件所在文件夹及文件名
     * @return 是否成功
     * @throws UpException
     * @throws IOException
     */
    public Boolean deleteFile(String filePath) throws UpException, IOException {
        //正确文件路径应该是 (文件夹名 如果有的话)/文件名
        return upYun.deleteFile(filePath,null );
    }
}
