package com.recrute.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.recrute.backend.models.Attachment;
@Repository
public interface AttachmentRepository extends JpaRepository<Attachment,String> {
    
}
