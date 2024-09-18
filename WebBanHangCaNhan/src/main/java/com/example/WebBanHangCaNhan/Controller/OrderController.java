/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebBanHangCaNhan.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author truon
 */
@Controller
public class OrderController {
    @RequestMapping("/order/checkout")
    public String checkout(){
        return "Order/Checkout";
    }
    @RequestMapping("/order/lst")
    public String lst(){
        return "Order/List";
    }
    @RequestMapping("/order/detail/{id}")
    public String detail(){
        return "Order/Detail";
    }
}
