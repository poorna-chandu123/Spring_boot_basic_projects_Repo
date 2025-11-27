package com.KAFKA_SpringFunction.Cloud_Stream;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.util.MimeTypeUtils;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;

@Configuration
public class KAFKA_Producer_Stream {
    // Spring Cloud Stream configurations can be added here
    @Bean
    public Supplier<RiderConfig> riderSupplier() {
        Random random = new Random();
        return () -> {
            int riderId = random.nextInt(6);
            RiderConfig rider =   new RiderConfig(riderId, "Alice", "1234567890");
            System.out.println("Rider Supplier function === " + rider.getRiderId());
return rider;
        };
    }


    @Bean
    public Supplier<String> riderMultiple_topic() {
        Random random = new Random();
        return () -> {
            int riderId = random.nextInt(6);
            String status = random.nextBoolean() ? "Active" : "Inactive";
            System.out.println("Rider status === " + status);
            return riderId + ":" + status;   // ✅ small fix: spacing + variable name
        };
    }


    @Bean
    public Supplier<Message<String>> riderMultiple_topics() {
        Random random = new Random();
        return () -> {
            int riderId = random.nextInt(6);
            String status = random.nextBoolean() ? "Active" : "Inactive";
            System.out.println("Rider status === " + status);

            // ✅ Corrected version below
            return MessageBuilder.withPayload("rider " + riderId + " : " + status)
                    .setHeader(KafkaHeaders.KEY, String.valueOf(riderId).getBytes()) // ✅ key must be String or byte[]
                    .setHeader(MessageHeaders.CONTENT_TYPE, MimeTypeUtils.TEXT_PLAIN)
                    .build();
        };
    }
}
