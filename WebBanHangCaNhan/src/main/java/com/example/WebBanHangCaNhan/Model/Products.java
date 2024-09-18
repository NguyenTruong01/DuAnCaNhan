/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebBanHangCaNhan.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

import java.sql.Date;

/**
 *
 * @author truon
 */
@Data
@Entity
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Name;
    private String Image;
    private Double Price;
    private Date CreateDate;
    private boolean Available;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Categories categories;

    public Products() {
    }

    public Products(Long Id, String Name, String Image, Double Price, Date CreateDate, boolean Available, Categories categories) {
        this.Id = Id;
        this.Name = Name;
        this.Image = Image;
        this.Price = Price;
        this.CreateDate = CreateDate;
        this.Available = Available;
        this.categories = categories;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double Price) {
        this.Price = Price;
    }

    public Date getCreateDate() {
        return CreateDate;
    }

    public void setCreateDate(Date CreateDate) {
        this.CreateDate = CreateDate;
    }

    public boolean isAvailable() {
        return Available;
    }

    public void setAvailable(boolean Available) {
        this.Available = Available;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }





}
