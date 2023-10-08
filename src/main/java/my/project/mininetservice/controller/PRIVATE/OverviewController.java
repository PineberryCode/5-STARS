package my.project.mininetservice.controller.PRIVATE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import my.project.mininetservice.dto.AuthenticationRequest;
import my.project.mininetservice.dto.AuthenticationResponse;
import my.project.mininetservice.routes.Render;
import my.project.mininetservice.service.AuthenticationService;

@Controller
@RequestMapping("/restricted/admin")
public class OverviewController {
    
    @Autowired
    HttpServletRequest request;

    @Autowired
    private AuthenticationService authenticationService;

    @GetMapping("/overview")
    //@PreAuthorize("hasAuthority('READ_OVERVIEW')")
    public String overview () {
        /*System.out.println("Auth overview: "+request.getHeader("Authorization"));
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer")) {
            String token = authHeader.substring(6);
            System.out.println("Token overview: "+token);
        } else {
            System.out.println("Encabezado incorrecto.");
        }*/
        /*AuthenticationResponse jwt = authenticationService.login(request);
        if (jwt == null) {
            System.out.println("JWT no generated");
        }*/
        /*Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Usuario autenticado: " + authentication.getName());
        System.out.println("Roles: " + authentication.getAuthorities());*/
        return Render.OVERVIEW;
    }
}
