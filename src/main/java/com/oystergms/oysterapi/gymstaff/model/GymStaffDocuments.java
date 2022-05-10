package com.oystergms.oysterapi.gymstaff.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymStaffDocuments {

    private String gymStaffDocument;
}
