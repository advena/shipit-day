package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrakplaceController {

    @Autowired
    private ParkingPlacesService parkingPlacesService;

    @RequestMapping("/capgemini")
    public ParkingPlacesDTO getCapgemini() {
        return parkingPlacesService.getForCapgemini();
    }

}
