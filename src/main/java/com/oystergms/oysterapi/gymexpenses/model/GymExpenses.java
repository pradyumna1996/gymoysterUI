package com.oystergms.oysterapi.gymexpenses.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GymExpenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gymExpenseId;

    private String gymExpenseItemName;

    private Integer gymExpenseItemQuantity;

    private Double gymExpenseItemPrice;

    @Temporal(TemporalType.DATE)
    private Date gymExpenseItemPurchaseDate;
}
