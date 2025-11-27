package com.first_mini_project.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        name = "citizen_plan",
        schema = "first_mini_project"

)
public class CitizenPlane {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "citizen_plane_id")
    private Integer citizenPlaneId;
    @Column(name = "citizen_name")
    private String citizenName;
    @Column(name = "citizen_gender")
    private String citizenGender;
    @Column(name = "citizen_plane_name")
    private String citizenPlaneName;
    @Column(name = "citizen_plane_status")
    private String citizenPlaneStatus;
    @Column(name = "citizen_plane_start_date")
    private Date citizenPlaneStartDate;
    @Column(name = "citizen_plane_end_date")
    private Date citizenPlaneEndDate;
    @Column(name = "citizen_benefit_amount")
    private String citizenBenefitAmount;
    @Column(name = "citizen_plane_denial_reason")
    private String citizenPlaneDenialReason;


}
