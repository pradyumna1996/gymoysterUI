package com.oystergms.oysterapi.gympackagescategory.maincategory.repository;

import com.oystergms.oysterapi.gympackagescategory.maincategory.model.GymPackageMainCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymPackageMainCategoryRepository  extends JpaRepository<GymPackageMainCategory , Integer> {
}
