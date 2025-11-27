package com.KAFKA_SpringFunction.Cloud_Stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RiderConfig {

    private int riderId;
    private String riderName;
    private String riderPhone;
}
