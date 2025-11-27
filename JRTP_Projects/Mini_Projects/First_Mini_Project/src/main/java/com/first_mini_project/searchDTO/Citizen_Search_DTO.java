package com.first_mini_project.searchDTO;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Citizen_Search_DTO {

    private String citizenPlaneName;     // dropdown
    private String citizenPlaneStatus;   // dropdown
    private String citizenGender;        // dropdown
    private String startDate;            // YYYY-MM-DD
    private String endDate;
}
