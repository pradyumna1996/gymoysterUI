package com.oystergms.oysterapi.gymtrainer.model;

import com.oystergms.oysterapi.gymmember.model.GymMember;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class GymTrainer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer gymTrainerId;

    private String gymTrainerName;

    private String gymTrainerTraining;

//    @OneToMany()
//    @JoinColumn(name = "gymMemberId")
//    private List<GymMember> gymMember;

}
