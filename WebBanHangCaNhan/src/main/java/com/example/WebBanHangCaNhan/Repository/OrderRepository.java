/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebBanHangCaNhan.Repository;

import com.example.WebBanHangCaNhan.Model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author truon
 */
@Repository
public interface OrderRepository extends JpaRepository<Orders, Long> {
    @Query("select o FROM Orders o WHERE o.accounts.username =?1")
    List<Orders> findByUserName(String username);
}
