/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebBanHangCaNhan.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 *
 * @author truon
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Accounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Username")
    String username;
    String Password;
    String Fullname;
     String Email;
     String Photo;

    @JsonIgnore
    @OneToMany(mappedBy = "accounts")
    List<Orders> orders;

    @JsonIgnore
    @OneToMany(mappedBy = "accounts", fetch = FetchType.EAGER)
    List<Authorities> authorities;




}
