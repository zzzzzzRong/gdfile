package com.insurance.demo.controller;

import com.insurance.demo.Vo.DataVo;
import com.insurance.demo.Vo.ImgVo;
import com.insurance.demo.util.Util;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * @USER: Mr.Wang
 * @DATE: 2020/1/12
 **/
@RestController
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*")
public class FileController {

    //ftp处理文件上传
    @RequestMapping(value="/ftpuploadimg", method = RequestMethod.POST)
    @ResponseBody
    public DataVo uploadImg(@RequestParam("file") MultipartFile file,
                            HttpServletRequest request) throws IOException {
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String fname =fileName.substring(0,fileName.lastIndexOf("."));
        fileName = fname+System.currentTimeMillis() + suffixName; // 新文件名
        InputStream inputStream=file.getInputStream();
        String filePath=null;
        Boolean flag= Util.uploadFile(fileName,inputStream);
        DataVo dataVo =new DataVo();
        if(flag==true){
            System.out.println("ftp上传成功！");
            filePath="http://182.92.209.239:8080/img/"+fileName;
            ImgVo imgVo=new ImgVo(filePath,fileName);
            dataVo.setMsg("上传成功");
            dataVo.setCode(0);
            dataVo.setData(imgVo);
            return dataVo ;
        }
        dataVo.setMsg("上传失败");
        dataVo.setCode(500);
        return dataVo ;
    }





}