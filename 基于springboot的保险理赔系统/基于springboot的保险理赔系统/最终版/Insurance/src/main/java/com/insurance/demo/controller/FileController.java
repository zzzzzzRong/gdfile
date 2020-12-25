package com.insurance.demo.controller;

import com.insurance.demo.Vo.DataVo;
import com.insurance.demo.Vo.ImgVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @USER: Mr.Wu
 * @DATE: 2020/4/12
 **/
@Controller
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class FileController {

    /**
     * 富文本图片上传
     *
     * @param file
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/ftpuploadimg", method = RequestMethod.POST)
    @ResponseBody
    public DataVo upLoadImgByRichtext(MultipartFile file) throws IOException {
        try {
            String path = System.getProperty("user.dir") + "\\src\\main\\resources\\static";
            System.out.println(path);
            String fileName = file.getOriginalFilename();  // 文件名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
            fileName = System.currentTimeMillis() + suffixName; // 文件名
//        String fileName = file.getOriginalFilename();// 获取到上传文件的名字
            // file.getSize();获取到上传文件的大小
            File dir = new File(path, fileName);
            if (!dir.exists()) {
                dir.mkdirs();
            }
            // MultipartFile自带的解析方法
            file.transferTo(dir);
            String directory = dir.getCanonicalPath();
            System.out.println("directory:" + directory);
            String file_path = "http://127.0.0.1:8083/" + fileName;
            ImgVo imgVo = new ImgVo(file_path, fileName);
            DataVo dataVo = new DataVo(0, "图片上传成功", 0, imgVo);
            return dataVo;
        } catch (Exception e) {
            DataVo imgVo = new DataVo(200, "图片上传失败", 0, null);
            return imgVo;
        }
    }

}