/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebBanHangCaNhan.Repository;

import com.example.WebBanHangCaNhan.Model.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author truon
 */
@Repository
public interface ProductRepository extends JpaRepository<Products, Long>{
    @Query("select p from Products p where p.categories.Id=?1")
    public List<Products> findByCateId(Long cid);
}
