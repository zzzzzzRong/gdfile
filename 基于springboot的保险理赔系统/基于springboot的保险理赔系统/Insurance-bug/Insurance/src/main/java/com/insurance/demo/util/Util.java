package com.insurance.demo.util;

import org.apache.commons.net.ftp.FTPClient;
import org.apache.commons.net.ftp.FTPReply;

import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * 这里是ftp上传的配置，记得改账号密码
 * @USER: Mr.Wang
 * @DATE: 2020/1/9
 **/
public class Util {

    //ftp服务器ip地址
    private static final String FTP_ADDRESS = "182.92.209.239";
    //端口号
    private static final int FTP_PORT = 21;
    //用户名
    private static final String FTP_USERNAME = "GZBD";
    //密码
    private static final String FTP_PASSWORD = "MyGDRPyJJp";
    //图片路径
    private static final String FTP_BASEPATH = "/";



    public  static boolean uploadFile(String originFileName, InputStream input){

        boolean success = false;
        FTPClient ftp = new FTPClient();
        ftp.setControlEncoding("UTF-8");
        ftp.enterLocalPassiveMode();
        try {
            int reply;
            ftp.connect(FTP_ADDRESS, FTP_PORT);// 连接FTP服务器
            ftp.login(FTP_USERNAME, FTP_PASSWORD);// 登录
            reply = ftp.getReplyCode();
            if (!FTPReply.isPositiveCompletion(reply)) {
                ftp.disconnect();
                System.out.println("****************");
                return success;
            }

            ftp.setFileType(FTPClient.BINARY_FILE_TYPE);
            ftp.makeDirectory(FTP_BASEPATH );
            ftp.changeWorkingDirectory(FTP_BASEPATH );
            ftp.enterLocalPassiveMode();
            ftp.storeFile(originFileName,input);
            input.close();
            ftp.logout();
            success = true;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (ftp.isConnected()) {
                try {
                    ftp.disconnect();
                } catch (IOException ioe) {
                }
            }
        }
        return success;
    }

    //生成17位订单号
    public static String getOrderIdByTime() {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        String newDate=sdf.format(new Date());
        String result="";
        Random random=new Random();
        for(int i=0;i<3;i++){
            result+=random.nextInt(10);
        }
        return newDate+result;
    }

}
