/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini.parking.places;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author advena
 */
public class ParkingPlaces {

    public static ParkingPlaces empty = new EmptyParkingPlaces();

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

    private static class EmptyParkingPlaces extends ParkingPlaces {

        private final ParkingPlace emptyParkingPlaces = new ParkingPlace(new ParkingStatus(666, 666, 666), 1L);
        
        public EmptyParkingPlaces() {
            super(new HashMap<>());
        }

        @Override
        public ParkingPlace getPorpParkingPlace() {
            return emptyParkingPlaces;
        }

        @Override
        public ParkingPlace getPfleidererParkingPlace() {
            return emptyParkingPlaces;
        }

        @Override
        public ParkingPlace getMerckParkingPlace() {
            return emptyParkingPlaces;
        }

        @Override
        public ParkingPlace getIdeaParkingPlace() {
            return emptyParkingPlaces;
        }

        @Override
        public ParkingPlace getCapgeminiParkingPlace() {
            return emptyParkingPlaces;
        }

        

        
    }
}
