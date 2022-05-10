package com.oystergms.oysterapi.gymattendance.memberattendance.model;

import com.oystergms.oysterapi.gymmember.model.GymMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymMemberAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gymMemberAttendanceId;

    @OneToOne
    @JoinColumn(name="gym_member_id")
    private GymMember gymMember;

    private Date gymAttendanceDate;

    private Boolean gymMemberAttendanceStatus;

}
