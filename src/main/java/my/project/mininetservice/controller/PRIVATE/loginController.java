package my.project.mininetservice.controller.PRIVATE;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.project.mininetservice.routes.router;

@Controller
@RequestMapping("/restricted")
public class loginController {
    @GetMapping("/login")
    private String login () {
        return router.LOG_IN;
    }
}
