package com.KAFKA_consumer.ConsumerConfig;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    //KAFKA TWo Consumer with different group and same group

        @KafkaListener(topics = "second-kraft-topic", groupId = "my-group")
        public void consumeMessage(String message) {
            System.out.println("Received msg my-group:=== " + message);

        }
        /* // same topic same group
    @KafkaListener(topics = "second-kraft-topic", groupId = "my-group")
    public void consumeMessage1(String message) {
        System.out.println("Received msg my-group second:=== " + message);

    }

         */

    // this method add for diffrent consuer perpous
     //diffrent group Example kosam edi rasanu same group Ex ni comment chesanu
    @KafkaListener(topics = "second-kraft-topic", groupId = "my-group-1")
    public void consumeMessage2(String message) {
        System.out.println("Received msg my-group-1:=== " + message);
    }

    // above Ex : lo string message kakunka KFAKA direct ga deserializer chesukuntadi but
    // object ni KAFKA lo use cheyali ante deserializer properties ni properties file lo rayali
    @KafkaListener(topics = "Rider-topic", groupId = "Rider-group-new")
    public void consumeMessage3(RiderConfig Rider) {
        System.out.println("Received msg Rider:=== " + Rider.getRiderName() + " Phone Number: " + Rider.getRiderPhone());
    }



}
