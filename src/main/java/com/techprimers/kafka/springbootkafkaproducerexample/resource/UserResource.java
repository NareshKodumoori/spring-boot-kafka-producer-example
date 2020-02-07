package com.techprimers.kafka.springbootkafkaproducerexample.resource;


import com.techprimers.kafka.springbootkafkaproducerexample.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/kafka")
public class UserResource {

    /*@Autowired
    KafkaTemplate<String, String> kafkaTemplate;*/

    @Autowired
    KafkaTemplate<String, User> kafkaUserTemplate;

    public static final String TOPIC = "mytest";

    /*@GetMapping("/publish/{message}")
    public String postMessege(@PathVariable("message") final String message){

        kafkaTemplate.send(TOPIC, message);
        return "Published Successfully N@ri";
    }*/

    @GetMapping("/publish/{email}")
    public String postUser(@PathVariable("email") final String email){

        kafkaUserTemplate.send(TOPIC, new User("Nari", email));
        return "Published Successfully N@ri";
    }

}
