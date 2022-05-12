package com.oystergms.oysterapi.gympackagescategory.subcategories.controller;


import com.oystergms.oysterapi.gymhandler.GymResponseHandler;
import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import com.oystergms.oysterapi.gympackagescategory.subcategories.service.GymPackageSubCategoryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
public class GymPackageSubCategoryController {

    private final GymPackageSubCategoryService gymPackageSubCategoryService;

    public GymPackageSubCategoryController(GymPackageSubCategoryService gymPackageSubCategoryService) {
        this.gymPackageSubCategoryService = gymPackageSubCategoryService;
    }

    @GetMapping("/gymSubPackages")
    public ResponseEntity<Object> getAllSubPackages(){
        List<GymPackageSubCategory> gymPackageSubCategories= gymPackageSubCategoryService.getSubCategories();
        if (gymPackageSubCategories.size()<=0){
            return GymResponseHandler.generateResponse("Nothing in Sub Packages", HttpStatus.OK,null);
        }else{
            return  GymResponseHandler.generateResponse("Sub Packages Fetched ",HttpStatus.OK ,gymPackageSubCategories);
        }
    }



    @PostMapping("/gymSubPackages/addSubPackage")
    public ResponseEntity<Object>  addMember( @RequestBody GymPackageSubCategory gymPackageSubCategory){

        try {
            if (gymPackageSubCategory.toString().equals("{}")) {
                return GymResponseHandler.generateResponse("Error In Request",HttpStatus.BAD_REQUEST,null);
            }
            gymPackageSubCategoryService.addSubCategory(gymPackageSubCategory);
            return GymResponseHandler.generateResponse("Sub Package Added !",HttpStatus.OK,gymPackageSubCategory);
        }catch(Exception e){
            return GymResponseHandler.generateResponse(e.getMessage(),HttpStatus.MULTI_STATUS,null);
        }
    }


    @DeleteMapping("/gymSubPackages/deleteSubPackage/{gymSubPackageId}")
    public ResponseEntity<Object> deleteGymEvent(@PathVariable("gymSubPackageId") Integer gymSubPackageId){

        try {
            String result = gymPackageSubCategoryService.deleteGymSubPackage(gymSubPackageId);
            return GymResponseHandler.generateResponse("Deleted Sub Package!", HttpStatus.OK, result);
        } catch (Exception e) {
            return GymResponseHandler.generateResponse(e.getMessage(), HttpStatus.MULTI_STATUS, null);
        }
    }
}
