package com.example.WebBanHangCaNhan.RestController;

import com.example.WebBanHangCaNhan.Model.Orders;
import com.example.WebBanHangCaNhan.Service.OrderService;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@CrossOrigin
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
    @Autowired
    OrderService orderService;

    @PostMapping()
    public Orders addOrder(@RequestBody JsonNode order) {

        return orderService.createOrder(order);
    }
}
