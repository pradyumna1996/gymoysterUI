package com.oystergms.oysterapi.gympackagescategory.maincategory.controller;

import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import com.oystergms.oysterapi.gympackagescategory.maincategory.model.GymPackageMainCategory;
import com.oystergms.oysterapi.gympackagescategory.maincategory.service.GymPackageMainCategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class GymPackageMainCategoryController {

    private final GymPackageMainCategoryService gymPackageMainCategoryService;

    public GymPackageMainCategoryController(GymPackageMainCategoryService gymPackageMainCategoryService) {
        this.gymPackageMainCategoryService = gymPackageMainCategoryService;
    }

    @GetMapping("/gymPackages")
    public ResponseEntity <Object>getAllMainPackages(){
        List<GymPackageMainCategory> gymPackageMainCategories= gymPackageMainCategoryService.getMainCategories();
        if (gymPackageMainCategories.size()<=0){
            return GymResponseHandler.generateResponse("Nothing in Packages !. Please Add.",HttpStatus.OK,null);
        }else{
            return  GymResponseHandler.generateResponse("Packages Fetched !", HttpStatus.OK,gymPackageMainCategories);
        }
    }


    @PostMapping("/gymPackages/addPackage")
    public ResponseEntity<Object>  addMember( @RequestBody GymPackageMainCategory gymPackageMainCategory){

        if (gymPackageMainCategory.toString().equals("{}")) {
            return GymResponseHandler.generateResponse("Error In Request",HttpStatus.INTERNAL_SERVER_ERROR,null);

        }
        else {
            gymPackageMainCategoryService.addMainCategory(gymPackageMainCategory);
            return GymResponseHandler.generateResponse("Package Added !",HttpStatus.OK,gymPackageMainCategory);
        }
    }

    @DeleteMapping("/gymPackages/deletePackage/{gymPackageId}")
    public ResponseEntity<Object> deleteGymPackage(@PathVariable("gymPackageId") Integer gymPackageId){

        try {
            String result = gymPackageMainCategoryService.deleteGymPackage(gymPackageId);
            return GymResponseHandler.generateResponse("Selected Package is Deleted!", HttpStatus.OK, result);
        } catch (Exception e) {
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
