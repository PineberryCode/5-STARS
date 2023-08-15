package my.project.mininetservice.model.service;

import org.springframework.web.multipart.MultipartFile;

public interface emailService {
    
    String sendMail(MultipartFile[] file, String to, String[] cc, String subject, String body);
    String sendRecommendation(String email, String lastname, String names, String comment);

}
