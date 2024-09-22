/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebBanHangCaNhan.Controller;


import com.example.WebBanHangCaNhan.Service.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author truon
 */
@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;
    @RequestMapping("/order/checkout")
    public String checkout(){
        return "Order/Checkout";
    }
    @RequestMapping("/order/lst")
    public String lst(Model model, HttpServletRequest request){
        String username = request.getRemoteUser();
        model.addAttribute("orders", orderService.findOrder(username));

        return "Order/List";
    }
    @RequestMapping("/order/detail/{id}")
    public String detail(@PathVariable("id") Long id, Model model){
        model.addAttribute("order", orderService.findOrderById(id));
        return "Order/Detail";
    }
}
