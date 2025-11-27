package com.Microservices_basic_add.Request;

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
