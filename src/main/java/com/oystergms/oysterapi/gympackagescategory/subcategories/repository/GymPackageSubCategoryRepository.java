package com.oystergms.oysterapi.gympackagescategory.subcategories.repository;

import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GymPackageSubCategoryRepository extends JpaRepository<GymPackageSubCategory , Integer> {
    @Query(value = "SELECT * FROM gym_package_sub_category WHERE gym_package_main_category_id=:gym_package_main_category_id ",nativeQuery = true)
    List<GymPackageSubCategory> getSubPackagesByCategoryId(@Param("gym_package_main_category_id") Integer gymCategoryId);
}
