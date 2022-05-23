package com.oystergms.oysterapi.membersubscription.service;

import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import com.oystergms.oysterapi.gympackagescategory.subcategories.service.GymPackageSubCategoryService;
import com.oystergms.oysterapi.membersubscription.model.GymMemberPackageSubscription;
import com.oystergms.oysterapi.membersubscription.repository.GymMemberPackageSubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GymMemberPackageSubscriptionService {

    private final GymMemberPackageSubscriptionRepository gymMemberPackageSubscriptionRepository;

    @Autowired
    private GymPackageSubCategoryService gymPackageSubCategoryService;
    public GymMemberPackageSubscriptionService(GymMemberPackageSubscriptionRepository gymMemberPackageSubscriptionRepository) {
        this.gymMemberPackageSubscriptionRepository = gymMemberPackageSubscriptionRepository;
    }



    public void addGymMemberPackageSubscription(GymMemberPackageSubscription gymMemberPackageSubscription) {
           gymMemberPackageSubscriptionRepository.save(gymMemberPackageSubscription);
    }

    public List<GymMemberPackageSubscription> getAllGymMemberSubscriptions() {

        return gymMemberPackageSubscriptionRepository.findAll();
    }

    public String updateGymMemberSubscription(GymMemberPackageSubscription gymMemberPackageSubscription) {
     gymMemberPackageSubscriptionRepository.save(gymMemberPackageSubscription);
     return "Subscription Modified";
    }



}
