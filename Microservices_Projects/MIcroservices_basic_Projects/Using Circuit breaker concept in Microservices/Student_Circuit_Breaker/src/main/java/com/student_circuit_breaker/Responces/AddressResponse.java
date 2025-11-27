package com.student_circuit_breaker.Responces;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AddressResponse {

    @JsonProperty("addid")
    private long AddressId;
   // @JsonProperty("state_name")  // Address project lo ye veriable names vunna yoo ave evvali
    private String state;

    private String city;
}
