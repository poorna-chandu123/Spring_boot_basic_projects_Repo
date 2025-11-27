package com.KAFKA_SpringFunction_For_Consumer.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class Consumer_Config {

    @Bean
    public Consumer <RiderConfig> consumer() {
        return riderConfig -> {
            System.out.println("Rider ID: " + riderConfig.getRiderId() + ", Rider Name: "
                    + riderConfig.getRiderName() + ", Rider Phone: "
                    + riderConfig.getRiderPhone());


        };
    }
}
