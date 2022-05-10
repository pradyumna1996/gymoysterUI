package com.oystergms.oysterapi.gympackagescategory.subcategories.model;

import com.oystergms.oysterapi.gympackagescategory.maincategory.model.GymPackageMainCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GymPackageSubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gymPackageSubCategoryId;

    private String gymPackageSubCategoryName;

    private Double gymPackageSubCategoryPrice;

    private Double gymPackageSubCategoryDuration;

    private String gymPackageSubCategoryDescription;

    private Double gymPackageSubCategoryOfferPrice;

    private String gymPackageSubCategoryPhoto;

    @ManyToOne
    @JoinColumn(name = "gym_package_main_category_id")
    private GymPackageMainCategory gymPackageMainCategories;
}
