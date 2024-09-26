package com.example.WebBanHangCaNhan.RestController;

import com.example.WebBanHangCaNhan.Model.Products;
import com.example.WebBanHangCaNhan.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping()
    public List<Products> getAllProducts() {
        return productService.findAll();
    }
    @PostMapping()
    public Products addProduct(@RequestBody Products products) {
        return productService.save(products);
    }
    @PutMapping ("/{id}")
    public Products updateProduct(@PathVariable("id") Long id,@RequestBody Products products) {
        return productService.update(products);
    }
    @DeleteMapping  ("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        productService.delete(id);
    }
}
