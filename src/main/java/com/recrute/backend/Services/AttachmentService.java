package com.recrute.backend.Services;

import org.springframework.web.multipart.MultipartFile;

import com.recrute.backend.models.Attachment;

public interface AttachmentService {
    Attachment saveAttachment(MultipartFile file,Long id) throws Exception;
    Attachment getAttachment(String fileId) throws Exception;
}
