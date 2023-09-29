package my.project.mininetservice.controller.PUBLIC;

import org.springframework.boot.web.servlet.view.MustacheViewResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ViewResolver;

import my.project.mininetservice.routes.Render;

@Controller
@RequestMapping("/global")
public class WelcomeController {

    @GetMapping("/welcome")
    private String welcome (Model model) {
        model.addAttribute("ItemActived", "home");
        return Render.WELCOME;
    }
    
}
