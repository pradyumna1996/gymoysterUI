package com.oystergms.oysterapi.membersubscription.model;

import com.oystergms.oysterapi.gymmember.model.GymMember;
import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GymMemberPackageSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gymMemberPackageSubscriptionId;

    private Double gymPackageSubscriptionDiscount;

    @OneToOne
    @JoinColumn(name="gym_member_id")
    private GymMember gymMember ;

    @OneToOne
    @JoinColumn(name="gym_package_sub_category_id")
    private GymPackageSubCategory gymPackageSubCategory;

}
