package com.basson.JavaBeans;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.ToString;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
public class Coupon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Basic(optional = false)
    @Column(nullable = false)
    private long id;

    @Basic(optional = false)
    @Column(nullable = false , unique = true)
    private @NonNull String title;

    @Basic(optional = false)
    @Column(nullable = false)
    private @NonNull Date startDate;

    @Basic(optional = false)
    @Column(nullable = false)
    private @NonNull Date endDate;

    @Basic(optional = false)
    @Column(nullable = false)
    private @NonNull int amount;

    @Basic(optional = false)
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private @NonNull CouponType type;

    @Basic(optional = false)
    @Column(nullable = false)
    private @NonNull String message;

    @Basic(optional = false)
    @Column(nullable = false)
    private @NonNull double price;

    @Basic(optional = false)
    @Column(nullable = false)
    private @NonNull String image;

    @Basic(optional = false)
    @Column(nullable = false)
    private @NonNull long companyId;

    @Basic(optional = false)
    @Column(nullable = false)
    private @NonNull boolean isActive;


    @ToString.Exclude
    @ManyToOne
    @JoinTable(
            name = "Company_Coupon",
            joinColumns = { @JoinColumn(name= "company_id") },
            inverseJoinColumns = { @JoinColumn(name = "coupon_id") }
    )
    private Company company;


    @ToString.Exclude
    @OneToMany
    @JoinTable(
            name = "Customer_Coupon",
            joinColumns = { @JoinColumn(name= "customer_id") },
            inverseJoinColumns = { @JoinColumn(name = "coupon_id") }
    )
    private List<Customer> customers = new ArrayList<>();


}
