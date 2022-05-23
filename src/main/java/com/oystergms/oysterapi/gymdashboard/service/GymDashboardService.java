package com.oystergms.oysterapi.gymdashboard.service;

import com.oystergms.oysterapi.gymdashboard.model.GymDashboardResponse;
import com.oystergms.oysterapi.gymmember.model.GymMember;
import com.oystergms.oysterapi.gymmember.service.GymMemberService;
import com.oystergms.oysterapi.gympackagescategory.maincategory.model.GymPackageMainCategory;
import com.oystergms.oysterapi.gympackagescategory.maincategory.service.GymPackageMainCategoryService;
import com.oystergms.oysterapi.gympackagescategory.subcategories.model.GymPackageSubCategory;
import com.oystergms.oysterapi.gympackagescategory.subcategories.service.GymPackageSubCategoryService;
import com.oystergms.oysterapi.gymstaff.model.GymStaff;
import com.oystergms.oysterapi.gymstaff.service.GymStaffRepositoryService;
import com.oystergms.oysterapi.memberpayment.service.GymMemberPaymentService;
import com.oystergms.oysterapi.membersubscription.model.GymMemberPackageSubscription;
import com.oystergms.oysterapi.membersubscription.service.GymMemberPackageSubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class GymDashboardService {

    @Autowired
    private GymMemberService gymMemberService;

    @Autowired
    private GymPackageMainCategoryService gymPackageMainCategoryService;

    @Autowired
    private GymPackageSubCategoryService gymPackageSubCategoryService;

    @Autowired
    private GymMemberPaymentService gymMemberPaymentService;

    @Autowired
    private GymStaffRepositoryService gymStaffRepositoryService;

    @Autowired
    private GymMemberPackageSubscriptionService gymMemberPackageSubscriptionService;

    public GymDashboardResponse gymMemberDashboardView(){

        GymDashboardResponse gymDashboardResponses = new GymDashboardResponse();

            List <GymMember> gymMember= gymMemberService.getAllGymMembers();
            Integer gymMemberCount = gymMember.size();

            List<GymPackageMainCategory> gymPackageMainCategories= gymPackageMainCategoryService.getMainCategories();
            Integer gymPackageMainCategoryCount = gymPackageMainCategories.size();

            List<GymPackageSubCategory> gymPackageSubCategory = gymPackageSubCategoryService.getSubCategories();
            Integer gymPackageSubCategoryCount= gymPackageSubCategory.size();

            List<GymStaff> gymStaffs = gymStaffRepositoryService.getAllGymStaffs();
            Integer gymStaffCount = gymStaffs.size();

            Double gymTotalIncome = gymMemberPaymentService.getTotaPaidAmount();

            List<GymMemberPackageSubscription> gymMemberPackageSubscriptionList=gymMemberPackageSubscriptionService.getAllGymMemberSubscriptions();
            Integer totalSubscription= gymMemberPackageSubscriptionList.size();

             gymDashboardResponses.setGymTotalMember(gymMemberCount);
             gymDashboardResponses.setGymTotalPackages(gymPackageMainCategoryCount);
             gymDashboardResponses.setGymTotalSubPackages(gymPackageSubCategoryCount);
             gymDashboardResponses.setGymTotalGymStaffs(gymStaffCount);
             gymDashboardResponses.setGymTotalIncome(gymTotalIncome);
             gymDashboardResponses.setGymTotalSubscriptions(totalSubscription);

        return gymDashboardResponses;
    }
}
