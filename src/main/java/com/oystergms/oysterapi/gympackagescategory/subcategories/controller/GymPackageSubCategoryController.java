package com.oystergms.oysterapi.gympackagescategory.subcategories.controller;


import com.oystergms.oysterapi.gympackagescategory.maincategory.model.GymPackageMainCategory;
import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import com.oystergms.oysterapi.gympackagescategory.subcategories.service.GymPackageSubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GymPackageSubCategoryController {

    private final GymPackageSubCategoryService gymPackageSubCategoryService;

    public GymPackageSubCategoryController(GymPackageSubCategoryService gymPackageSubCategoryService) {
        this.gymPackageSubCategoryService = gymPackageSubCategoryService;
    }

    @GetMapping("/gymSubPackages")
    public ResponseEntity<List<GymPackageSubCategory>> getAllSubPackages(){
        List<GymPackageSubCategory> gymPackageSubCategories= gymPackageSubCategoryService.getSubCategories();
        if (gymPackageSubCategories.size()<=0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return  ResponseEntity.of(Optional.of(gymPackageSubCategories));
        }
    }



    @PostMapping("/gymSubPackages/addSubPackage")
    public ResponseEntity<?>  addMember( @RequestBody GymPackageSubCategory gymPackageSubCategory){

        if (gymPackageSubCategory.toString().equals("{}")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nothing insert in form");

        }
        if (gymPackageSubCategory ==null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nothing inset in form");
        }
        if (gymPackageSubCategory !=null){
            gymPackageSubCategoryService.addSubCategory(gymPackageSubCategory);
            return ResponseEntity.status(HttpStatus.OK).body("Sub Package added successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error in request");
    }


}
