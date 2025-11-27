package com.KAFKA_producer.Controller;


import com.KAFKA_producer.Config.RiderConfig;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/producer")
public class Producer {

    //KAFAK Producer code will go here
   // private  final KafkaTemplate<String, String> kafkaTemplate;
    private  final KafkaTemplate<String, Object> kafkaTemplate;

    public Producer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // Post mapping to send message to Kafka topic
    @PostMapping("/send")
    public String sendMessage(@RequestParam String message) {
        kafkaTemplate.send("second-kraft-topic", message);
        return "sending msg by using spring boot === "+ message;
    }

   /* // e topic anedi nenu KAFKA lo create cheyaledu but eikkada eisthe KAFKA create chesthundi but its not recommended
        so ala spring boot use chesi create cheyali anukunte separate configuration file lo create cheyali
    @PostMapping("/send")
    public String sendMessage1(@RequestParam String message) {
        kafkaTemplate.send("second-kraft-topic-1", message);
        return "sending msg by using spring boot === "+ message;
    }

    */

    // above Ex : lo string message kakunka KFAKA direct ga serializer chesukuntadi but
    // object ni KAFKA lo use cheyali ante serializer properties ni properties file lo rayali
    @GetMapping ("/rider")
    public int getRider() {
        RiderConfig rider = new RiderConfig(12345, "John Doe", "9876543210");
        kafkaTemplate.send("Rider-topic", rider);
        return rider.getRiderId();
    }


    @PostMapping("/send1")
    public String sendMessagee(@RequestParam String message) {
        kafkaTemplate.send("sample-kraft-topic", message);
        return "sample KAFKA === "+ message;
    }

}
