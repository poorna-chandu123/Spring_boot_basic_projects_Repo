package com.KAFKA_SpringFunction.KAFKA_Topic_Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KAFKA_Topic_Config {

    // KAFAKA configuration to create topic with 3 partitions and 1 replication factor

    @Bean
    public NewTopic CreateTopic() {
        return new NewTopic("Rider-topic-new", 3, (short) 1);
    }


}
