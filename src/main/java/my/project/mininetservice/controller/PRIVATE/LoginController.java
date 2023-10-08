package my.project.mininetservice.controller.PRIVATE;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import my.project.mininetservice.dto.AuthenticationRequest;
import my.project.mininetservice.dto.AuthenticationResponse;
import my.project.mininetservice.routes.Render;
import my.project.mininetservice.service.AuthenticationService;

@Controller
@RequestMapping("/restricted")
public class LoginController {

    @Value("${security.jwt.expiration-minutes}")
    private int EXPIRATION_MINUTES;

    @Autowired
    private AuthenticationService authenticationService;

    private AuthenticationResponse jwt;

    @GetMapping("/admin")
    public String login () {
        return Render.LOG_IN;
    }

    @PostMapping("/admin/login")
    public String login (
        @RequestParam("username") String username, 
        @RequestParam("password") String password,
        HttpServletResponse response) throws IOException, InterruptedException {
        jwt = authenticationService.login(new AuthenticationRequest(username, password));

        Cookie jwtCookie = new Cookie("token", jwt.getJWT());

        jwtCookie.setMaxAge(EXPIRATION_MINUTES*60);

        response.addCookie(jwtCookie);

        return "redirect:/restricted/admin/"+Render.OVERVIEW;
    }
}
