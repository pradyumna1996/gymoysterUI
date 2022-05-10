package com.oystergms.oysterapi.gymevents.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GymEvents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gymEventId;

    private String gymEventName;

    @Temporal(TemporalType.DATE)
    private Date gymEventStartDate;

   @Temporal(TemporalType.DATE)
    private Date gymEventEndDate;

    private String gymEventPhoto;

    private String gymEventDescription;
}
