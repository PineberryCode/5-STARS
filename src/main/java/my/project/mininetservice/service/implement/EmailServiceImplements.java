package my.project.mininetservice.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.MimeMessage;
import my.project.mininetservice.service.EmailService;

@Service
public class EmailServiceImplements implements EmailService {

    private String noReplyGMAIL = "mindlunnyfalse@gmail.com";

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    MimeMessage mimeMessage;
    MimeMessageHelper mimeMessageHelper;

    @Override
    public String sendMail (MultipartFile[] file, String to, String[] cc, 
                            String subject, String body) {
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            
            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(to);
            mimeMessageHelper.setCc(cc);
            mimeMessageHelper.setSubject(subject);
            mimeMessageHelper.setText(body);
            
            for (int i=0; i < file.length; i++) {
                mimeMessageHelper.addAttachment(
                    file[i].getOriginalFilename(),
                    new ByteArrayResource(file[i].getBytes())
                );
            }

            javaMailSender.send(mimeMessage);

            return "mail sent";

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
    @Override
    public String sendRecommendation (  String email, String lastname, 
                                        String names, String comment) {
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
            
            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(noReplyGMAIL);
            mimeMessageHelper.setCc(email);
            mimeMessageHelper.setSubject("Recommendation");

            String body =   "Email: "+email+"\n"+
                            "Lastname: "+lastname+"\n"+
                            "Names: "+names+"\n"+
                            "Comment: "+comment;

            mimeMessageHelper.setText(body);

            javaMailSender.send(mimeMessage);

            return EmailService.msgRecommendation;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendComplaint(String email, String phone, String lastname, 
                                String names, MultipartFile[] file, String comment) {
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(noReplyGMAIL);
            mimeMessageHelper.setCc(email);
            mimeMessageHelper.setSubject("Complaint!");

            String body =   "E-mail: "+email+"\n"+
                            "Phone: "+phone+"\n"+
                            "Lastname: "+lastname+"\n"+
                            "Names: "+names+"\n"+
                            "Comment: "+comment;
            mimeMessageHelper.setText(body);

            for (int k=0; k < file.length; k++){
                mimeMessageHelper.addAttachment(
                    file[k].getOriginalFilename(),
                    new ByteArrayResource(file[k].getBytes())
                );
            }

            javaMailSender.send(mimeMessage);

            return EmailService.msgComplaints;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String sendConsultation( String email, String phone, String lastname, 
                                    String names, String services) {
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);

            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(noReplyGMAIL);
            mimeMessageHelper.setCc(email);
            mimeMessageHelper.setSubject("Consultation");

            String body =   "E-mail: "+email+"\n"+
                            "Phone: "+phone+"\n"+
                            "Lastname: "+lastname+"\n"+
                            "Names: "+names+"\n"+
                            "Consultation about "+services.toString();

            mimeMessageHelper.setText(body);

            javaMailSender.send(mimeMessage);

            return EmailService.msgServices;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
