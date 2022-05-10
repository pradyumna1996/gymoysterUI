package com.oystergms.oysterapi.gymmember.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GymMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gymMemberId;

    private String gymMemberFullName;

    @Enumerated(EnumType.STRING)
    private GymMemberGender gymMemberGender;

    private Integer gymMemberAge;

    private String gymMemberAddress;

    private String gymMemberEmail;

    private String gymMemberContactNumber;

    private String gymMemberEmergencyContact;

    private String gymMemberContactPerson;

    private String gymMemberContactPersonRelation;

    private String gymMemberOccupation;

    private Double gymMemberHeight;

    private Double gymMemberWeight;

    private Double gymMemberBMI;

    private Double gymMemberBodyFat;

    @Enumerated(EnumType.STRING)
    private GymMemberWeightStatus gymMemberWeightStatus;

    @Enumerated(EnumType.STRING)
    private GymMemberHealthCondition gymMemberHealthCondition;

    private Boolean gymMemberHaveDisease;

    private String gymMemberDisease;

    @Enumerated(EnumType.STRING)
    private GymMemberBloodGroup gymMemberBloodGroup;

    private String gymMemberDescription;

    private String gymMemberPassportSizePhoto;

    private String gymMemberFullPhoto;

    @ElementCollection
    private List<GymMemberExtraPhoto> gymMemberExtraPhotos = new ArrayList<GymMemberExtraPhoto>();

    @Temporal(TemporalType.DATE)
    private Date gymMemberEnrollmentDate;

    @Enumerated(EnumType.STRING)
    private GymMemberVehicle gymMemberVehicle;

    private String gymMemberPersonalAccessToken;


}
