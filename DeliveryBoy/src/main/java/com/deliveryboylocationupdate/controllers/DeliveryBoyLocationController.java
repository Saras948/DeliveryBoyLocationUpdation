package com.deliveryboylocationupdate.controllers;


import com.deliveryboylocationupdate.services.DeliveryBoyLocationUpdateService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
public class DeliveryBoyLocationController {


    DeliveryBoyLocationUpdateService deliveryBoyLocationUpdateService;

    DeliveryBoyLocationController(DeliveryBoyLocationUpdateService deliveryBoyLocationUpdateService){
        this.deliveryBoyLocationUpdateService = deliveryBoyLocationUpdateService;
    }

    @PostMapping("/updatelocation")
    public ResponseEntity<?> sendLocation(){
        try {
            for(int i=0;i<10000;i++) {
                long coordinates1 = Math.round(Math.random() * 100);
                long coordinates2 = Math.round(Math.random() * 100);
                StringBuilder sb = new StringBuilder();
                sb.append("(")
                        .append(coordinates1)
                        .append(",")
                        .append(coordinates2)
                        .append(")");
                this.deliveryBoyLocationUpdateService.updateLocation(sb.toString());
            }
            return ResponseEntity.ok("Location updated successfully");
        }
        catch (Exception e){
            return ResponseEntity.ok("Exception occurred while updating location");
        }
    }
}
