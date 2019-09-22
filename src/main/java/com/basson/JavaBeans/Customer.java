package com.basson.JavaBeans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(nullable = false)
    private long id;

    @Basic(optional = false)
    @Column(nullable = false)
    private String customerName;

    @Basic(optional = false)
    @Column(nullable = false)
    private String password;

//    @ToString.Exclude
//    @OneToMany
//    private List<Coupon> coupons = new ArrayList<>();

}
