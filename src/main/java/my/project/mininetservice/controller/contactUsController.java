package my.project.mininetservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import my.project.mininetservice.routes.router;

@Controller
public class contactUsController {
    
    @GetMapping("/contactUs")
    private String contactUs (Model model) {
        model.addAttribute("ItemActived03", "contactUs");
        return router.CONTACT_US;
    }

}
