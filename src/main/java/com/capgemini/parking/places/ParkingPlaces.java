/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini.parking.places;

import java.util.Map;

/**
 *
 * @author advena
 */
public class ParkingPlaces {

    private final Map<CompanyName, ParkingPlace> companyParkingPlace;

    public ParkingPlaces(Map<CompanyName, ParkingPlace> companyParkingPlace) {
        this.companyParkingPlace = companyParkingPlace;
    }

    public ParkingPlace getCapgeminiParkingPlace() {
        return companyParkingPlace.get(CompanyName.CAPGEMINI);  
    }

    public ParkingPlace getIdeaParkingPlace() {
        return companyParkingPlace.get(CompanyName.IDEA);  
    }

    public ParkingPlace getMerckParkingPlace() {
        return companyParkingPlace.get(CompanyName.MERCK);  
    }

    public ParkingPlace getPfleidererParkingPlace() {
        return companyParkingPlace.get(CompanyName.PORP);  
    }

    public ParkingPlace getPorpParkingPlace() {
        return companyParkingPlace.get(CompanyName.PFLEIDERER);  
    }
    
    public Map<CompanyName, ParkingPlace> getAllParkingPlaces(){
    	return companyParkingPlace;
    }
}
