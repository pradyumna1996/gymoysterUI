package com.oystergms.oysterapi.gymstaff.model;

import com.oystergms.oysterapi.gymmember.model.GymMemberGender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class GymStaff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gymStaffId;

    private String gymStaffFullName;

    @Enumerated(EnumType.STRING)
    private GymMemberGender gymStaffGender;

    private String gymStaffDesignation;

    private String gymStaffAddress;

    private String gymStaffContactNumber;

    @ElementCollection
    private List<GymStaffDocuments> gymStaffDocuments = new ArrayList<GymStaffDocuments>();

}
