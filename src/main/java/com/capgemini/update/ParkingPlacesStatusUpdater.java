/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini.update;

import com.capgemini.parking.groups.ParkPollGroupService;
import com.capgemini.parking.groups.ParkPollGroups;
import com.capgemini.parking.places.ParkingGroupFactory;
import com.capgemini.parking.places.ParkingPlaces;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author advena
 */
@Component
public class ParkingPlacesStatusUpdater {
    
    @Autowired
    private ParkPollGroupService parkPollGroupService;

    @Autowired
    private ParkingGroupFactory factory;

    @Autowired
    private ParkingPlacesContainer container;
    

    @Scheduled(fixedRate=15000)
    public void update() {
        ParkingPlaces updatedParkingPlaces = getSelfParkingPlaces();
        this.container.setParkingPlaces(updatedParkingPlaces);
    }

    private ParkingPlaces getSelfParkingPlaces() {
        ParkPollGroups  parkPollGroups = parkPollGroupService.getParkPollGroups();
        return factory.parseParkingPlacesFrom(parkPollGroups);
    }
}
