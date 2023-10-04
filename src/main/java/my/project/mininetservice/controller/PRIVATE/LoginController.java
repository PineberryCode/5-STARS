package my.project.mininetservice.controller.PRIVATE;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import my.project.mininetservice.dto.AuthenticationRequest;
import my.project.mininetservice.dto.AuthenticationResponse;
import my.project.mininetservice.model.User;
import my.project.mininetservice.routes.Render;
import my.project.mininetservice.service.AuthenticationService;
import my.project.mininetservice.util.Role;

@Controller
@RequestMapping("/restricted")
public class LoginController {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/admin")
    public String login () {
        System.out.println("Login: "+request.getHeader("Authorization"));
        return Render.LOG_IN;
    }

    @PostMapping("/admin/login")
    public /*String*/ModelAndView login (
        @RequestParam("username") String username, 
        @RequestParam("password") String password,
        HttpServletResponse response) throws IOException, InterruptedException {
        AuthenticationResponse jwt = authenticationService.login(new AuthenticationRequest(username,password));
        
        if (jwt != null) {
            response.setHeader("Authorization", "Bearer " + jwt.getJWT());
            /*Cookie cookie = new Cookie("Authorization", "Bearer " + jwt.getJWT());
            cookie.setMaxAge(3600); // Duración de la cookie en segundos (por ejemplo, 1 hora)
            cookie.setPath("http://localhost:5000/restricted/admin/overview"); // La cookie estará disponible para todo el sitio
            response.addCookie(cookie);*/
            System.out.println("Hola: "+response.getHeader("Authorization"));
            //System.out.println("JWTDTO -> "+jwt.getJWT());
            ModelAndView modelAndView = new ModelAndView("overview");
            return modelAndView;
            //return "redirect:/restricted/admin/"+Render.OVERVIEW;
        } else {
            //return "Incorrect credentials";
            return new ModelAndView("incorrectCredentialsPage");
        }
    }
}
