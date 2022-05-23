package com.oystergms.oysterapi.gymdashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymDashboardResponse {

    private Integer gymTotalMember;

    private Integer gymTotalPackages;

    private Integer gymTotalSubPackages;

    private Integer gymTotalGymStaffs;

    private Integer gymTotalSubscriptions;

    private Double gymTotalIncome;

    private Integer gymTotalExpenses;
}
