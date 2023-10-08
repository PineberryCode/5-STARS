package my.project.mininetservice.controller.PRIVATE;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import my.project.mininetservice.routes.Render;

@Controller
@RequestMapping("/restricted/admin")
public class OverviewController {

    @GetMapping("/overview")
    @PreAuthorize("hasAuthority('READ_OVERVIEW')")
    public String overview () {
        return Render.OVERVIEW;
    }
}
