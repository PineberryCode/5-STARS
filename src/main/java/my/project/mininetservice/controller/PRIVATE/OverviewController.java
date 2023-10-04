package my.project.mininetservice.controller.PRIVATE;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpServletRequest;
import my.project.mininetservice.routes.Render;

@Controller
@RequestMapping("/restricted/admin")
public class OverviewController {
    
    @GetMapping("/overview")
    public String overview (/*HttpServletRequest request*/) {
        //System.out.println("Auth overview: "+request.getHeader("Authorization"));
        return Render.OVERVIEW;
    }
}
