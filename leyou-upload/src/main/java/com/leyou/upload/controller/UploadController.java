package com.leyou.upload.controller;

import com.leyou.upload.service.UploadService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传controller
 * @author
 * @version 1.00
 * @time 2019/12/30 0030  上午 10:50
 */
@Controller
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    private UploadService uploadService;

    /**
     * 图片上传  单纯图片上传 不考虑其他
     * @param file
     * @return
     */
    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file){

        //返回上传后的url
        String url = uploadService.uploadImage(file);
        if(StringUtils.isBlank(url)){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(url);

    }
}
