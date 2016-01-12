/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini.parking.places;

import com.capgemini.parking.groups.Group;
import com.capgemini.parking.groups.ParkPollGroupService;
import com.capgemini.parking.groups.ParkPollGroups;
import com.capgemini.parking.groups.ParkingPollGroupsConfiguration;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author advena
 */
@Service
public class ParkingGroupFactory {

    @Autowired
    ParkPollGroupService pollGroupService;

    @Autowired
    ParkingPollGroupsConfiguration configuration;

    public ParkingPlaces getParkingPlaces() {
        ParkPollGroups parkPollGroups = pollGroupService.getParkPollGroups();
        ParkingPlaces parkingPlaces = parseParkingPlacesFrom(parkPollGroups);
        return parkingPlaces;
    }

    private ParkingPlaces parseParkingPlacesFrom(ParkPollGroups parkPollGroups) {
        Map<CompanyName, ParkingPlace> parsed = new HashMap<>();
        Long timestamp = getTimeStampFrom(parkPollGroups.getTimestamp());
        for (Group parkingGroup : parkPollGroups.getGroup()) { 
            switch(parkingGroup.getName()) {
                case("Capgemini rotacyjny"):
                    parsed.put(CompanyName.CAPGEMINI, createParkingPlaceFrom(parkingGroup, timestamp));
                    break;
                case("Idea Leasing"):
                    parsed.put(CompanyName.IDEA, createParkingPlaceFrom(parkingGroup, timestamp));
                    break;
                case("Merck"):
                    parsed.put(CompanyName.MERCK, createParkingPlaceFrom(parkingGroup, timestamp));
                    break;
                case("PORR"):
                    parsed.put(CompanyName.PORP, createParkingPlaceFrom(parkingGroup, timestamp));
                    break;
                case("Pfleiderer"):
                    parsed.put(CompanyName.PFLEIDERER, createParkingPlaceFrom(parkingGroup, timestamp));
                    break;
            }
        }
        return new ParkingPlaces(parsed);
    }

    private ParkingPlace createParkingPlaceFrom(Group parkingGroup, Long timestamp) {
        ParkingStatus status = new ParkingStatus(parkingGroup.getSpaces(), parkingGroup.getOccupied(), parkingGroup.getFree());
        return new ParkingPlace(status, timestamp);
    }

    private Long getTimeStampFrom(String timestamp) {
        Long time = 1L;
        try {
            return new SimpleDateFormat(configuration.getDate()).parse(timestamp).getTime();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return time;
    }
    
}
