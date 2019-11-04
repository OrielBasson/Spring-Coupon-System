package com.basson.JavaBeans;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private long companyId;

    @Basic(optional = false)
//    @Column(nullable = false , unique = true)
    @Column(nullable = false)
    private String compName;

    @Basic(optional = false)
    @Column(nullable = false)
    private String password;

    @Basic(optional = false)
    @Column(nullable = false)
    private String email;

//    @ToString.Exclude
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "company")
//    private List<Coupon> coupons = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(
            name = "Company_Coupon",
            joinColumns = { @JoinColumn(name= "company_id") },
            inverseJoinColumns = { @JoinColumn(name = "coupon_id") }
    )
    private List<Coupon> coupons = new ArrayList<>();

}
