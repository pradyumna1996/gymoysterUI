package com.oystergms.oysterapi.gympackagescategory.maincategory.model;

import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GymPackageMainCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gymPackageMainCategoryId;

    private String gymPackageMainCategoryName;

}
