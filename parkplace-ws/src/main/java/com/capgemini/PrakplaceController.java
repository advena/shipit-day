package com.capgemini;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrakplaceController {

    @Autowired
    private ParkingPlacesService parkingPlacesService;

    @RequestMapping("/capgemini")
    public ParkingPlaceDTO getCapgemini() {
        return parkingPlacesService.getForCapgemini();
    }

    @RequestMapping("/idea")
    public ParkingPlaceDTO getForIdea() {
        return parkingPlacesService.getForIdea();
    }
    @RequestMapping("/merck")
    public ParkingPlaceDTO getForMerck() {
        return parkingPlacesService.getForMerck();
    }

    @RequestMapping("/porp")
    public ParkingPlaceDTO getForPorp() {
        return parkingPlacesService.getForPorp();
    }
    @RequestMapping("/pfleiderer")
    public ParkingPlaceDTO getForPfleiderer() {
        return parkingPlacesService.getForPfleiderer();
    }

}
