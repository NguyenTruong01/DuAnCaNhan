package com.example.WebBanHangCaNhan.Service;

import com.example.WebBanHangCaNhan.Model.OrderDetails;
import com.example.WebBanHangCaNhan.Model.Orders;
import com.example.WebBanHangCaNhan.Repository.OrderDetailRepository;
import com.example.WebBanHangCaNhan.Repository.OrderRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.query.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailRepository orderDetailRepository;
    public Orders createOrder(JsonNode orderData) {
//        ObjectMapper mapper = new ObjectMapper();
//        Orders orders = mapper.convertValue(orderData, Orders.class);
//        orderRepository.save(orders);
//        TypeReference<List<OrderDetails>> typeRef = new TypeReference<List<OrderDetails>>() {};
//        List<OrderDetails> orderDetails = mapper.convertValue(orderData.get("OrderDetails"),typeRef)
//                .stream().peek(d -> d.setOrders(orders)).collect(Collectors.toList());
//        orderDetailRepository.saveAll(orderDetails);
//        return orders;
        ObjectMapper mapper = new ObjectMapper();
        try {
            Orders orderObj = mapper.convertValue(orderData, Orders.class);
            orderRepository.save(orderObj);

            TypeReference<List<OrderDetails>> type = new TypeReference<List<OrderDetails>>() {};
            List<OrderDetails> details = mapper.convertValue(orderData.get("orderDetails"), type)
                    .stream().peek(d -> d.setOrder(orderObj)).collect(Collectors.toList());
            orderDetailRepository.saveAll(details);
            return orderObj;
        } catch (Exception e) {
            throw new RuntimeException("Order creation failed", e);
        }
    }
    public Orders findOrderById(Long id) {
        return orderRepository.findById(id).get();

    }
    public List<Orders> findOrder(String username ) {
        return orderRepository.findByUserName(username);
    }
}
