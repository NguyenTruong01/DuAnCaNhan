package com.example.WebBanHangCaNhan.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping({"/home/index","/"})
    public String home(Model model) {

        return "redirect:/product/lst";
    }
    @RequestMapping({"/admin/index","/admin","/admin/home"})
    public String admin(Model model) {

        return "redirect:/assets/admin/index.html";
    }
}
