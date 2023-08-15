package my.project.mininetservice.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import my.project.mininetservice.model.service.emailService;
import my.project.mininetservice.routes.router;

@Controller
public class contactUsController {

    private emailService mssger;

    @GetMapping("/contactUs")
    private String contactUs (Model model) {
        model.addAttribute("ItemActived03", "contactUs");
        model.addAttribute("resultMessage");
        return router.CONTACT_US;
    }

    public contactUsController (emailService mssger) {
        this.mssger = mssger;
    }

    @PostMapping("/sendRecommendation")
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

    @PostMapping("/sendComplaint")
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

    @PostMapping("/sendConsultation")
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
