/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebBanHangCaNhan.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    public Accounts() {
    }

    public Accounts(String Username, String Password, String Fullname, String Email, String Photo) {
        this.Username = Username;
        this.Password = Password;
        this.Fullname = Fullname;
        this.Email = Email;
        this.Photo = Photo;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getFullname() {
        return Fullname;
    }

    public void setFullname(String Fullname) {
        this.Fullname = Fullname;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }
    
    
}
