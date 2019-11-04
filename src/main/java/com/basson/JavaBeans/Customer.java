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
//    @Column(nullable = false , unique = true)
    @Column(nullable = false)

    private String customerName;

    @Basic(optional = false)
    @Column(nullable = false)
    private String password;

    @ToString.Exclude
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Customer_Coupon",
            joinColumns = { @JoinColumn(name= "customer_id") },
            inverseJoinColumns = { @JoinColumn(name = "coupon_id") }
    )
    private List<Coupon> coupons = new ArrayList<>();


}
