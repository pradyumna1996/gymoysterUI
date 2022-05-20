package com.oystergms.oysterapi.memberpayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberPackageDueAmount {
    private Integer gymMemberId;
    private Integer gymSubPackageId;
    private Double gymDueAmount;
}
