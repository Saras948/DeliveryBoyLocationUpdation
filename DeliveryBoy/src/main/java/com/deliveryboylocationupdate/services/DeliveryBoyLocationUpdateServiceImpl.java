package com.deliveryboylocationupdate.services;

import com.deliveryboylocationupdate.config.AppConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class DeliveryBoyLocationUpdateServiceImpl implements DeliveryBoyLocationUpdateService{

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(DeliveryBoyLocationUpdateServiceImpl.class);
    @Override
    public boolean updateLocation(String location) {
        try{
            this.kafkaTemplate.send(AppConstants.TOPIC_NAME, location);
            logger.info("Location update request received for location: {}", location);
            return true;
        }
        catch (Exception e){
            logger.error("Exception occurred while sending message to kafka topic: {}", e.getMessage());
            logger.error("Exception stack trace: {}", e.getStackTrace());
            logger.error("Exception cause: {}", e.getCause());
            e.printStackTrace();;
            return false;
        }
    }
}
