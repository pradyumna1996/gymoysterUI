package com.oystergms.oysterapi.gympackagescategory.maincategory.controller;

import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import com.oystergms.oysterapi.gympackagescategory.maincategory.model.GymPackageMainCategory;
import com.oystergms.oysterapi.gympackagescategory.maincategory.service.GymPackageMainCategoryService;
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
    @CrossOrigin
    public ResponseEntity <Object>getAllMainPackages(){
        List<GymPackageMainCategory> gymPackageMainCategories= gymPackageMainCategoryService.getMainCategories();
        if (gymPackageMainCategories.size()<=0){
            return GymResponseHandler.generateResponse("Nothing in Packages !. Please Add.",HttpStatus.OK,null);
        }else{
            return  GymResponseHandler.generateResponse("Packages Fetched !", HttpStatus.OK,gymPackageMainCategories);
        }
    }

    @GetMapping("/gymPackages/{gymPackageId}")
    @CrossOrigin
    public ResponseEntity<Object> getMainPackagesById(@PathVariable("gymPackageId") Integer gymPackageId){

        GymPackageMainCategory gymPackageMainCategory = gymPackageMainCategoryService.getMainPackagesById(gymPackageId);

         if (gymPackageMainCategory == null){
            return GymResponseHandler.generateResponse("Nothing in Packages !. Please Add.",HttpStatus.OK,null);
        }else{
            return  GymResponseHandler.generateResponse("Packages Fetched !", HttpStatus.OK,gymPackageMainCategory);
        }
    }

    @PutMapping("/gymPackages/updatePackage")
    @CrossOrigin
    public ResponseEntity<Object>  updateMember( @RequestBody GymPackageMainCategory gymPackageMainCategory){

        if (gymPackageMainCategory.toString().equals("{}")) {
            return GymResponseHandler.generateResponse("Error In Request",HttpStatus.INTERNAL_SERVER_ERROR,null);
        }
        else {
            String result = gymPackageMainCategoryService.updateGymPackage(gymPackageMainCategory);
            return GymResponseHandler.generateResponse("Package Modified Added !",HttpStatus.OK,result);
        }
    }

    @PostMapping("/gymPackages/addPackage")
    @CrossOrigin
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
    @CrossOrigin
    public ResponseEntity<Object> deleteGymPackage(@PathVariable("gymPackageId") Integer gymPackageId){

        try {
            String result = gymPackageMainCategoryService.deleteGymPackage(gymPackageId);
            return GymResponseHandler.generateResponse("Selected Package is Deleted!", HttpStatus.OK, result);
        } catch (Exception e) {
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }

}
