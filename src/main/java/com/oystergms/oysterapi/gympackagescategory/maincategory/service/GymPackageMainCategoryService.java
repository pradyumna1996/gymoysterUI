package com.oystergms.oysterapi.gympackagescategory.maincategory.service;

import com.oystergms.oysterapi.gympackagescategory.maincategory.model.GymPackageMainCategory;
import com.oystergms.oysterapi.gympackagescategory.maincategory.repository.GymPackageMainCategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymPackageMainCategoryService {

    private final GymPackageMainCategoryRepository gymPackageMainCategoryRepository;


    public GymPackageMainCategoryService(GymPackageMainCategoryRepository gymPackageMainCategoryRepository) {
        this.gymPackageMainCategoryRepository = gymPackageMainCategoryRepository;
    }

    public GymPackageMainCategory getMainPackagesById(Integer gymPackageId) {

    return gymPackageMainCategoryRepository.findById(gymPackageId).get();

    }


    public List<GymPackageMainCategory> getMainCategories() {

        return gymPackageMainCategoryRepository.findAll();
    }

    public void addMainCategory(GymPackageMainCategory gymPackageMainCategory) {
        gymPackageMainCategoryRepository.save(gymPackageMainCategory);
    }


    public String deleteGymPackage(Integer gymPackageId) {
        gymPackageMainCategoryRepository.deleteById(gymPackageId);
        return " Selected Package Category is Deleted ";
    }

    public String updateGymPackage(GymPackageMainCategory gymPackageMainCategory) {
        gymPackageMainCategoryRepository.save(gymPackageMainCategory);
        return "Package Edited Successful";
    }
}
