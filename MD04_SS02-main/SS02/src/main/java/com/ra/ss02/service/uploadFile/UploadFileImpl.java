package com.ra.ss02.service.uploadFile;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
@Service
public class UploadFileImpl implements UploadFile {
    @Override
    public String uploadFile(MultipartFile file) {
       String fileName = file.getOriginalFilename();
       String path ="/Users/phamlinh/Desktop/SS02/src/main/resources/uploads/";
       try{
           FileCopyUtils.copy(file.getBytes(), new File(path + fileName));
       }catch (Exception e){
           e.printStackTrace();
           return null;
       }
       return "http:localHost:8080/"+fileName;
    }
}
