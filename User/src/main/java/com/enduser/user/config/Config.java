package com.enduser.user.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class Config {

    @KafkaListener(topics = AppConstants.TOPIC_NAME, groupId = AppConstants.GROUP_ID)
    public void updatedLocation(String location){
        System.out.println("Location updated to: "+location);
    }
}
