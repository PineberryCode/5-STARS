package my.project.minihostel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import my.project.minihostel.controller.util.global;
import my.project.minihostel.routes.router;

@Controller
public class contactUsController {
    
    @GetMapping("/contactUs")
    private String contactUs (Model model) {
        model.addAttribute("ItemActived03", "contactUs");
        return router.CONTACT_US;
    }

}
