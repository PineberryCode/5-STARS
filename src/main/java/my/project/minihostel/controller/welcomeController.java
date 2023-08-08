package my.project.minihostel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import my.project.minihostel.routes.router;

@Controller
public class welcomeController {

    @GetMapping("/")
    private String welcome (Model model) {
        model.addAttribute("ItemActived", "home");
        return router.WELCOME;
    }
}
