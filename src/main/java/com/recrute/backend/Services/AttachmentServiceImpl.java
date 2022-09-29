package com.recrute.backend.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.recrute.backend.models.Attachment;
import com.recrute.backend.models.Profile;
import com.recrute.backend.repositories.AttachmentRepository;
import com.recrute.backend.repositories.ProfileRepository;



@Service
public class AttachmentServiceImpl implements AttachmentService {
    @Autowired
    private ProfileRepository profileRepository;
   
    @Autowired
    private AttachmentRepository attachmentRepository;
    public AttachmentServiceImpl(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }
    @Override
    public Attachment saveAttachment(MultipartFile file,Long id) throws Exception {
        // TODO Auto-generated method stub
        String fileName=StringUtils.cleanPath(file.getOriginalFilename());
        try{
            if(fileName.contains("..")){
                throw new Exception("fileName contains invalid path sequence"+ fileName);
            }
            Profile p=profileRepository.findById(id).get();
            
            Attachment attachment=new Attachment(fileName,file.getContentType(),file.getBytes(),p);
           
            if(p.getAttachment()!=null){
                throw new Exception("attachment exist");

            }else{
                p.setAttachment(attachment);
            }
           
        
        
             
            
            return attachmentRepository.save(attachment);
        } catch(Exception e){
            throw new Exception("Could not save File:" + fileName); 
        }
        }
        @Override
        public Attachment getAttachment(String fileId) throws Exception {
            // TODO Auto-generated method stub
            return attachmentRepository.findById(fileId).orElseThrow(()-> new Exception("File Not found with id: "+fileId));
        }
        
        
   
    }
    

