package my.project.mininetservice.model.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import jakarta.mail.internet.MimeMessage;
import my.project.mininetservice.model.service.emailService;

@Service
public class emailServiceImplements implements emailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String fromEmail;

    MimeMessage mimeMessage;
    MimeMessageHelper mimeMessageHelper;

    @Override
    public String sendMail(MultipartFile[] file, String to, String[] cc, 
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
    public String sendRecommendation(String email, String lastname, 
                                    String names, String comment) {
        try {
            mimeMessage = javaMailSender.createMimeMessage();
            mimeMessageHelper = new MimeMessageHelper(mimeMessage, false);
            
            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo("mindlunnyfalse@gmail.com");
            mimeMessageHelper.setCc(email);
            mimeMessageHelper.setSubject("Recommendation");

            String body =   "Email: "+email+"\n"+
                            "Lastname: "+lastname+"\n"+
                            "Names: "+names+"\n"+
                            "Comment: "+comment;

            mimeMessageHelper.setText(body);

            javaMailSender.send(mimeMessage);

            return emailService.msgRecommendation;

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    
}
