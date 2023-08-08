package my.project.minihostel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import my.project.minihostel.routes.router;

@Controller
public class servicesController {
    
    @GetMapping("/services")
    private String services (Model model) {
        model.addAttribute("ItemActived02", "services");
        return router.SERVICES;
    }
}
