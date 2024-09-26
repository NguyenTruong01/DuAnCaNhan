package com.example.WebBanHangCaNhan.Service;

import com.example.WebBanHangCaNhan.Model.Products;
import com.example.WebBanHangCaNhan.Repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public List<Products> findAll() {  // Sửa tên phương thức
        return productRepository.findAll();
    }

    public Products findById(Long id) {  // Sửa tên phương thức
        return productRepository.findById(id).orElseThrow();
    }

    public List<Products> findByCateId(Long cid) {  // Sửa kiểu trả về thành List<Products> và kiểu tham số thành Long
        return productRepository.findByCateId(cid);
    }
    public Products save(Products products) {
        return productRepository.save(products);
    }
    public Products update(Products products) {
        return productRepository.save(products);
    }
    public void delete(Long Id) {
         productRepository.deleteById(Id);
    }
}
