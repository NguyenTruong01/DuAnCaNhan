package com.example.WebBanHangCaNhan.Controller;

import com.example.WebBanHangCaNhan.Model.Products;
import com.example.WebBanHangCaNhan.Service.ProductService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @RequestMapping("/product/lst")
    public String listProduct(Model model, @RequestParam("cid") Optional<Long> cid) {  // Sửa Optional<String> thành Optional<Long>
        List<Products> lst;
        if (cid.isPresent()) {
            lst = productService.findByCateId(cid.get());  // Thêm get() để lấy giá trị của Optional
        } else {
            lst = productService.findAll();  // Sửa tên phương thức
        }
        model.addAttribute("Products", lst);
        return "Product/ListProduct";
    }

    @RequestMapping("/product/detail/{id}")
    public String detailProduct(Model model, @PathVariable("id") Long id) {
        Products product = productService.findById(id);  // Sửa tên phương thức
        model.addAttribute("Products", product);
        return "Product/DetailProduct";
    }
}
