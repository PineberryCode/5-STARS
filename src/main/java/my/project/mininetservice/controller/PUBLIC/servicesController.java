package my.project.mininetservice.controller.PUBLIC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.project.mininetservice.routes.router;

@Controller
@RequestMapping("/global")
public class servicesController {
    
    @GetMapping("/services")
    private String services (Model model) {
        model.addAttribute("ItemActived02", "services");
        return router.SERVICES;
    }
}
