package com.oystergms.oysterapi.gympackagescategory.subcategories.repository;

import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymPackageSubCategoryRepository extends JpaRepository<GymPackageSubCategory , Integer> {
}
