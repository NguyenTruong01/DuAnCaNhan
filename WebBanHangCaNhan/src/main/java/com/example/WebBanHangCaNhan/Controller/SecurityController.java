package com.example.WebBanHangCaNhan.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {
    @GetMapping("/login/form")
    public String Login(Model model) {
        model.addAttribute("message", "Vui long đăng nhập");
        return "Security/loginForm";
    }
    @GetMapping("/login/success")
    public String loginSuccess(Model model) {
        model.addAttribute("message","Đang nhập thành công");
        return "redirect:/product/lst";
    }
    @GetMapping("/login/failure")
    public String loginfailure(Model model) {
        model.addAttribute("message","Đang nhập không thành công");
        return "security/loginForm";
    }
    @GetMapping("/login/error")
    public String loginError(Model model) {
        model.addAttribute("message","Sai thông tin đang nhập!");
        return "Security/loginForm";

    }
    @GetMapping("/unauthoried")
    public String unauthoried(Model model){
        model.addAttribute("message","Không có quyền truy cập!");
        return "Security/loginForm";
    }
    @GetMapping("/logoff/succes")
    public String logout(Model model){
        model.addAttribute("message","Bạn đã đang xuất!");
        return "Security/loginForm";
    }
}
