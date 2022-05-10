package com.oystergms.oysterapi.gympackagescategory.maincategory.service;

import com.oystergms.oysterapi.gympackagescategory.maincategory.model.GymPackageMainCategory;
import com.oystergms.oysterapi.gympackagescategory.maincategory.repository.GymPackageMainCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymPackageMainCategoryService {

    private final GymPackageMainCategoryRepository gymPackageMainCategoryRepository;


    public GymPackageMainCategoryService(GymPackageMainCategoryRepository gymPackageMainCategoryRepository) {
        this.gymPackageMainCategoryRepository = gymPackageMainCategoryRepository;
    }


    public List<GymPackageMainCategory> getMainCategories() {

        return gymPackageMainCategoryRepository.findAll();
    }

    public void addMainCategory(GymPackageMainCategory gymPackageMainCategory) {
        gymPackageMainCategoryRepository.save(gymPackageMainCategory);
    }


}
