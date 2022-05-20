package com.oystergms.oysterapi.memberpayment.model;

import com.oystergms.oysterapi.gymmember.model.GymMember;
import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GymMemberPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gymMemberPaymentId;

    @Enumerated(EnumType.STRING)
    private PackagePaymentType packagePaymentType;

    private Double gymPackagePaidAmount;

    @Temporal(TemporalType.DATE)
    private Date gymPackagePaymentDate;
    
    @OneToOne
    @JoinColumn(name = "gym_member_id")
    private GymMember gymMember;


    @OneToOne
    @JoinColumn(name = "gym_package_sub_category_id")
    private GymPackageSubCategory gymPackageSubCategory;
}
