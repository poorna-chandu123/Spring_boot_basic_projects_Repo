package com.KAFKA_producer.Config;

import jdk.jfr.DataAmount;
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
