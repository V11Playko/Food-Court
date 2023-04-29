package com.pragma.powerup.usermicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;

@Entity
@Table(name = "restaurant")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "restaurant_id", nullable = false)
    private Long id;
    //@Column(name="name", nullable = false)
    private String name;
    //@Column(name = "adress",nullable = false)
    private String address;

    private String idOwner;
    //@OneToMany(mappedBy = "restaurant")
    //private List<EmployeeEntity> owner;
    //@Column(name="phone",nullable = false)
    private String phone;
    //@Column(name="url_logo",nullable = false)
    private String urlLogo;
    //@Column(name="nit",nullable = false)
    private String nit;
    //@OneToMany(mappedBy = "restaurant")
    //private List<DishEntity> dishes;
}
