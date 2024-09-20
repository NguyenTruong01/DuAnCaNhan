/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebBanHangCaNhan.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

/**
 *
 * @author truon
 */
@Entity
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String Username;
    private String Password;
    private String Fullname;
    private String Email;
    private String Photo;

    @JsonIgnore
    @OneToMany(mappedBy = "accounts")
    List<Orders> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "accounts", fetch = FetchType.EAGER)
    List<Authorities> authorities;

    public Accounts() {
    }

    public Accounts(List<Authorities> authorities, String email, String fullname, List<Orders> orders, String password, String photo, String username) {
        this.authorities = authorities;
        Email = email;
        Fullname = fullname;
        this.orders = orders;
        Password = password;
        Photo = photo;
        Username = username;
    }

    public List<Authorities> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authorities> authorities) {
        this.authorities = authorities;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String fullname) {
        Fullname = fullname;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String photo) {
        Photo = photo;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
}
