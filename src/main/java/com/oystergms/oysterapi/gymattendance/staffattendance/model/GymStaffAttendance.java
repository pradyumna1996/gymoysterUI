package com.oystergms.oysterapi.gymattendance.staffattendance.model;


import com.oystergms.oysterapi.gymstaff.model.GymStaff;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymStaffAttendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gymStaffAttendanceId;

    @OneToOne
    @JoinColumn(name="gym_staff_id")
    private GymStaff gymStaff;

    private Date gymStaffAttendanceDate;

    private Boolean gymStaffAttendanceStatus;
}
