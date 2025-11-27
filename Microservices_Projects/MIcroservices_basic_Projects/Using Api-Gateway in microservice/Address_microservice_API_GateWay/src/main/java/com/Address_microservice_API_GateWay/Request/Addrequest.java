package com.Address_microservice_API_GateWay.Request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class Addrequest {

    private String CITY;  // veriable name java code lo yela echhina post man lo request send chesetappudu lowercase lone evvali
    private String State;

}
