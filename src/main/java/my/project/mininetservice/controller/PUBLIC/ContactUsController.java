package my.project.mininetservice.controller.PUBLIC;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import my.project.mininetservice.routes.Render;
import my.project.mininetservice.service.EmailService;

@Controller
@RequestMapping("/global")
public class ContactUsController {

    private EmailService mssger;

    @GetMapping("/contactUs")
    private String contactUs (Model model) {
        model.addAttribute("ItemActived03", "contactUs");
        model.addAttribute("resultMessage", "Successfully email sent!"); //Improve this
        return Render.CONTACT_US;
    }

    public ContactUsController (EmailService mssger) {
        this.mssger = mssger;
    }

    @PostMapping("/contactUs/sendRecommendation")
    @ResponseBody
    public Map<String, String> sendRecomendation (  @RequestParam(name="email") String emailUser,
                                                    @RequestParam(name="lastname") String lastname,
                                                    @RequestParam(name="names") String names,
                                                    @RequestParam(name="comment") String comment) {
        
        String resultMessage = mssger.sendRecommendation(emailUser,lastname,names,comment);
        
        Map<String, String> response = new HashMap<>();
        response.put("resultMessage", resultMessage);

        return response;
    }

    @PostMapping("/contactUs/sendComplaint")
    @ResponseBody
    public Map<String, String> sendComplaint (  @RequestParam(name="email") String emailUser,
                                                @RequestParam(name="phone") String phone,
                                                @RequestParam(name="lastname") String lastname,
                                                @RequestParam(name="names") String names,
                                                @RequestParam(name="file") MultipartFile[] file,
                                                @RequestParam(name="comment") String comment) {
        String resultMessage = mssger.sendComplaint(emailUser, phone, lastname, names, file, comment);
        
        Map<String, String> response = new HashMap<>();
        response.put("resultMessage", resultMessage);
        
        return response;
    }

    @PostMapping("/contactUs/sendConsultation")
    @ResponseBody
    public Map<String, String> sendConsultation(@RequestParam(name="email") String email,
                                                @RequestParam(name="phone") String phone,
                                                @RequestParam(name="lastname") String lastname,
                                                @RequestParam(name="names") String names,
                                                @RequestParam(name="groupServices") String services) {
        String resultMessage = mssger.sendConsultation(email, phone, lastname, names, services);
        
        Map<String, String> response = new HashMap<>();
        response.put("resultMessage", resultMessage);

        return response;
    }

}
