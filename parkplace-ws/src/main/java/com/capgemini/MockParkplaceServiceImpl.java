/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini;

import java.util.Date;
import java.util.Random;
import org.springframework.stereotype.Service;

/**
 *
 * @author advena
 */
@Service
public class MockParkplaceServiceImpl implements FreeParkplacesService{

    @Override
    public ParkingPlaceDTO getFreeParkPlaces() {
        Integer freePlaces = getFreePlaces();
        Date lastDate = getLastDate();
        return new ParkingPlaceDTO(freePlaces, lastDate);
    }

    private Integer getFreePlaces() {
        return new Random().nextInt(300);
    }

    private Date getLastDate() {
        return new Date();
    }


    
}
