package my.project.minihostel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class welcomeController {

    @GetMapping("/")
    private String welcome () {
        return "welcome";
    }
}
