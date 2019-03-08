package com.slionh.community.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * Create by s lion h on 2019/1/1
 */
public class ImageUtil {
    public static String saveImg(MultipartFile multipartFile, String path) throws IOException {
//        File file = new File(path);
        File file = new File(path);
        if (!file.exists()) {
            file.mkdirs();
        }
        FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
        String originalFilename = multipartFile.getOriginalFilename();
        String extension= originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String fileName = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + "."+extension;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(path + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }
}
