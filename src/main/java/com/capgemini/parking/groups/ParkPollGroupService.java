/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini.parking.groups;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author advena
 */
@Service
public class ParkPollGroupService {

    @Autowired
    ParkingPollGroupsConfiguration configuration;       

    public ParkPollGroups getParkPollGroups() {
        RestTemplate restTemplate = new RestTemplate();
        ParkPollGroups parkPollGroups = restTemplate.getForObject(configuration.getUrl(), ParkPollGroups.class);
        return parkPollGroups;
    }
}
