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
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Basic(optional = false)
    @Column(nullable = false)
    private long companyId;

    @Basic(optional = false)
    @Column(nullable = false , unique = true)
    private String compName;

    @Basic(optional = false)
    @Column(nullable = false)
    private String password;

    @Basic(optional = false)
    @Column(nullable = false)
    private String email;

//    @ToString.Exclude
//    @OneToMany
//    private List<Coupon> coupons = new ArrayList<>();

}
