/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.WebBanHangCaNhan.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

/**
 *
 * @author truon
 */
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Orders implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("Id")
    Long id;
    @JsonProperty("Address")
    String address;
    @JsonProperty("CreateDate")
    @Column(name = "CreateDate")
    Date createDate;
    @ManyToOne
    @JsonProperty("Accounts")
    @JoinColumn(name = "Username")
    Accounts accounts;

    @JsonIgnore
    @OneToMany(mappedBy = "order")
    List<OrderDetails> orderDetails;

}
