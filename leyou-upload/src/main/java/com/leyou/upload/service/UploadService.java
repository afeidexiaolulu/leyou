package com.leyou.upload.service;

import com.github.tobato.fastdfs.domain.StorePath;
import com.github.tobato.fastdfs.domain.ThumbImageConfig;
import com.github.tobato.fastdfs.service.FastFileStorageClient;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * 文件上传
 * @author
 * @version 1.00
 * @time 2019/12/30 0030  上午 10:55
 */
@Service
public class UploadService {

    //注入fastDfs存储的Client
    @Autowired
    private FastFileStorageClient storageClient;

    //缩略图Client
    @Autowired
    private ThumbImageConfig thumbImageConfig;


    private static final List<String> CONTENT_TYPES = Arrays.asList("image/jpeg", "image/gif");

    private static final Logger LOGGER = LoggerFactory.getLogger(UploadService.class);
    /**
     * 图片上传
     * @param file
     * @return
     */
    public String uploadImage(MultipartFile file) {

        //1，判断图片类型
        String originalFilename = file.getOriginalFilename();
        //获取图片类型
        String contentType = file.getContentType();
        if(!CONTENT_TYPES.contains(contentType)){
            // 文件类型不合法，直接返回null
            LOGGER.info("文件类型不合法：{}", originalFilename);
            return null;
        }
        //2，判断图片内容
        try {
            BufferedImage read = ImageIO.read(file.getInputStream());
            if(read == null){
                LOGGER.info("图片内容为空", originalFilename);
                return null;
            }
            //截取最后一个. 后面的字符串  即扩展名
            String ext = StringUtils.substringAfterLast(originalFilename, ".");
            // 上传并且生成缩略图   构造器第三个参数为图片格式
            StorePath storePath = this.storageClient.uploadImageAndCrtThumbImage(

                    file.getInputStream(), file.getSize(), ext, null);
            // 带分组的路径
            String fullPath = storePath.getFullPath();
            LOGGER.info("FastDfs返回带分组路径为{}", fullPath);
            // 不带分组的路径
            String path1 = storePath.getPath();
            LOGGER.info("FastDfs返回不带分组路径为{}", path1);
            // 获取缩略图路径
            String path = thumbImageConfig.getThumbImagePath(path1);
            LOGGER.info("FastDfs返回缩略图路径为{}", path);


            // 生成url地址，返回
            return "http://image.leyou.com/" + fullPath;

        } catch (IOException e) {
            LOGGER.error("读取图片异常，图片名{}", originalFilename);
            e.printStackTrace();
        }
        return null;
    }
}
