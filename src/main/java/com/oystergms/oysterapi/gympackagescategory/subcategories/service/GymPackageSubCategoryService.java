package com.oystergms.oysterapi.gympackagescategory.subcategories.service;

import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import com.oystergms.oysterapi.gympackagescategory.subcategories.repository.GymPackageSubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymPackageSubCategoryService {

    private final GymPackageSubCategoryRepository gymPackageSubCategoryRepository;

    public GymPackageSubCategoryService(GymPackageSubCategoryRepository gymPackageSubCategoryRepository) {
        this.gymPackageSubCategoryRepository = gymPackageSubCategoryRepository;
    }


    public List<GymPackageSubCategory> getSubCategories() {

        return gymPackageSubCategoryRepository.findAll();
    }


    public void addSubCategory(GymPackageSubCategory gymPackageSubCategory) {

        gymPackageSubCategoryRepository.save(gymPackageSubCategory);
    }

    public String deleteGymSubPackage(Integer gymSubPackageId) {
        gymPackageSubCategoryRepository.deleteById(gymSubPackageId);
        return "Selected Sub Package is Deleted";
    }
}
