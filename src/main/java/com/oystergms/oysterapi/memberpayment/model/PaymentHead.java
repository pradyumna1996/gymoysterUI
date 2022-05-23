package com.oystergms.oysterapi.memberpayment.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentHead {

    private Integer gymMemberId;
    private Double gymPackagePaidAmount;
    private Double gymPackageSubCategoryPrice;
}
