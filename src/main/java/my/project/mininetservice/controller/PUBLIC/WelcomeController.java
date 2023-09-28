package my.project.mininetservice.controller.PUBLIC;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.project.mininetservice.routes.Router;

@Controller
@RequestMapping("/global")
public class WelcomeController {

    @GetMapping("/welcome")
    private String welcome (Model model) {
        model.addAttribute("ItemActived", "home");
        return Router.WELCOME;
    }
}
