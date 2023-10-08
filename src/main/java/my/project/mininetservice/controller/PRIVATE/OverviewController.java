package my.project.mininetservice.controller.PRIVATE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import my.project.mininetservice.routes.Render;

@Controller
@RequestMapping("/restricted/admin")
public class OverviewController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @GetMapping("/overview")
    @PreAuthorize("hasAuthority('READ_OVERVIEW')")
    public String overview () {
        return Render.OVERVIEW;
    }

    @PostMapping("/overview/logout")
    public String logout () {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("token".equals(cookie.getName())) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/restricted/admin");
                    response.addCookie(cookie);
                    break;
                }
            }
        }
        return "redirect:/restricted/admin";
    }
}
