package com.example.WebBanHangCaNhan.RestController;

import com.example.WebBanHangCaNhan.Model.Categories;
import com.example.WebBanHangCaNhan.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rest/cates")
public class CategoryRestController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping()
    public List<Categories> getall () {
        return categoryService.finAll();
    }
}
