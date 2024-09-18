package com.example.WebBanHangCaNhan.RestController;

import com.example.WebBanHangCaNhan.Model.Products;
import com.example.WebBanHangCaNhan.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@CrossOrigin
@RestController
@RequestMapping("/rest/product")
public class ProductRestController {
    @Autowired
    ProductService productService;
    @GetMapping("/{id}")
    public Products getProduct(@PathVariable("id") Long id) {
        return productService.findById(id);
    }
}
