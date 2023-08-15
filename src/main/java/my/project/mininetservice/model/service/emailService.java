package my.project.mininetservice.model.service;

import org.springframework.web.multipart.MultipartFile;

public interface emailService {
    
    static String msgRecommendation = "Your Recommendation had been sent.";
    static String msgComplaints = "Your Complaints had been sent.";
    static String msgServices = "Your consultation had been sent!";

    String sendMail (MultipartFile[] file, String to, String[] cc, String subject, String body);
    String sendRecommendation (String email, String lastname, String names, String comment);
    String sendComplaint (String email, String phone, String lastname, String names, MultipartFile[] file, String comment);
    String sendConsultation (String email, String phone, String lastname, String names, String Services);
}
