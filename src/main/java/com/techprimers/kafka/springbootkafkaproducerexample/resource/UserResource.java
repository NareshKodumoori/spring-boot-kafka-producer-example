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

    public static final String TOPIC = "mytest";
    public static final String TOPIC_JSON = "mytest_json";

    @Autowired
    KafkaTemplate<String, String> kafkaTemplateForString;
    @Autowired
    KafkaTemplate<String, User> kafkaTemplateForUser;


    @GetMapping("/publishString/{message}")
    public String postString(@PathVariable("message") final String message){
        kafkaTemplateForString.send(TOPIC, message);
        return "Published Successfully...on 11-02-2020";
    }

    @GetMapping("/publishUser/{email}")
    public String postUser(@PathVariable("email") final String email){
        kafkaTemplateForUser.send(TOPIC_JSON, new User("Nari", email));
        return "User is Published Successfully on 11-02-2020";
    }

}
