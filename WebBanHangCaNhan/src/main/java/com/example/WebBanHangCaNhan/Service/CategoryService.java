/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebBanHangCaNhan.Service;

import com.example.WebBanHangCaNhan.Model.Categories;
import com.example.WebBanHangCaNhan.Repository.CategoryRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author truon
 */
@Service
public class CategoryService {
    @Autowired 
    CategoryRepository categoryRepository;
     public List<Categories> finAll(){
        return  categoryRepository.findAll();
    }
}
