package com.oystergms.oysterapi.gympackagescategory.maincategory.controller;

import com.oystergms.oysterapi.gympackagescategory.maincategory.model.GymPackageMainCategory;
import com.oystergms.oysterapi.gympackagescategory.maincategory.service.GymPackageMainCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class GymPackageMainCategoryController {

    private final GymPackageMainCategoryService gymPackageMainCategoryService;

    public GymPackageMainCategoryController(GymPackageMainCategoryService gymPackageMainCategoryService) {
        this.gymPackageMainCategoryService = gymPackageMainCategoryService;
    }

    @GetMapping("/gymPackages")
    public ResponseEntity <List<GymPackageMainCategory> >getAllMainPackages(){
        List<GymPackageMainCategory> gymPackageMainCategories= gymPackageMainCategoryService.getMainCategories();
        if (gymPackageMainCategories.size()<=0){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }else{
            return  ResponseEntity.of(Optional.of(gymPackageMainCategories));
        }
    }


    @PostMapping("/gymPackages/addPackage")
    public ResponseEntity<?>  addMember( @RequestBody GymPackageMainCategory gymPackageMainCategory){
        if (gymPackageMainCategory.toString().equals("{}")) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nothing insert in form");

        }
        if (gymPackageMainCategory ==null) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("nothing inset in form");
        }
        if (gymPackageMainCategory !=null){
            gymPackageMainCategoryService.addMainCategory(gymPackageMainCategory);
            return ResponseEntity.status(HttpStatus.OK).body("Main Package added successfully");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("error in request");
    }


}
