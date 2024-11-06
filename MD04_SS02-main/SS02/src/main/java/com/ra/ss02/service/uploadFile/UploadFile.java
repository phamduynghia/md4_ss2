package com.ra.ss02.service.uploadFile;

import org.springframework.web.multipart.MultipartFile;

public interface UploadFile {
    String uploadFile(MultipartFile file);
}
