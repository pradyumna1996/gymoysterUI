package com.oystergms.oysterapi.gymfollowup.model;

import com.oystergms.oysterapi.gymmember.model.GymMember;
import com.oystergms.oysterapi.gymstaff.model.GymStaff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class GymMemberFollowUp {


    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private Integer gymMemberFollowUpId;
    private String gymMemberFollowUpTitle;
    private String gymMemberFollowUpDescription;
    private String gymMemberFollowUpCause;
    private Boolean gymMemberFollowUpRequired;

    @Temporal(TemporalType.DATE)
    private Date gymMemberNextFollowUpDate;

    @Temporal(TemporalType.DATE)
    private Date gymMemberFollowUpDate;

    @OneToOne
    @JoinColumn(name = "gym_staff_id")
    private GymStaff gymStaff;

    @OneToOne
    @JoinColumn(name = "gym_member_id")
    private GymMember gymMember;



}
