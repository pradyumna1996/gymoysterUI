package com.oystergms.oysterapi.gymmember.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;


@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GymMemberExtraPhoto {

    private String gymMemberExtraPhotoUrl;
}
