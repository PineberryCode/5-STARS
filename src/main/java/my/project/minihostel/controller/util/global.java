package my.project.minihostel.controller.util;

import org.springframework.ui.Model;

public abstract class global {
    
    public String ItemActived (Model model, String item, String page) {
        model.addAttribute("ItemActived", item);
        return page;
    }
}
