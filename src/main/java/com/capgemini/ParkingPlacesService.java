/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini;

import com.capgemini.parking.places.ParkingPlaceDTO;
import com.capgemini.parking.places.CompanyName;
import com.capgemini.parking.places.ParkingPlace;
import com.capgemini.parking.places.ParkingPlaces;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author advena
 */
@Service
class ParkingPlacesService {

	@Autowired
	ParkingPlacesRepository parkingPlacesRepository;

	ParkingPlaceDTO getForCapgemini() {
		ParkingPlaces parkingPlaces = getParkingPlaces();
		ParkingPlace capgeminiParkingPlaces = parkingPlaces.getCapgeminiParkingPlace();
		return capgeminiParkingPlaces.getParkingPlacesDTO();

	}

	ParkingPlaceDTO getForIdea() {
		ParkingPlaces parkingPlaces = getParkingPlaces();
		ParkingPlace ideaParkingPlaces = parkingPlaces.getIdeaParkingPlace();
		return ideaParkingPlaces.getParkingPlacesDTO();
	}

	ParkingPlaceDTO getForMerck() {
		ParkingPlaces parkingPlaces = getParkingPlaces();
		ParkingPlace merckParkingPlaces = parkingPlaces.getMerckParkingPlace();
		return merckParkingPlaces.getParkingPlacesDTO();
	}

	ParkingPlaceDTO getForPorp() {
		ParkingPlaces parkingPlaces = getParkingPlaces();
		ParkingPlace porpParkingPlaces = parkingPlaces.getPorpParkingPlace();
		return porpParkingPlaces.getParkingPlacesDTO();
	}

	ParkingPlaceDTO getForPfleiderer() {
		ParkingPlaces parkingPlaces = getParkingPlaces();
		ParkingPlace pfleidererParkingPlaces = parkingPlaces.getPfleidererParkingPlace();
		return pfleidererParkingPlaces.getParkingPlacesDTO();
	}

	Map<CompanyName, ParkingPlaceDTO> getAllFreePlaces() {
		ParkingPlaces parkingPlaces = getParkingPlaces();
		Map<CompanyName, ParkingPlace> pfleidererParkingPlaces = parkingPlaces.getAllParkingPlaces();
		return createAllParkingPlacesDTO(pfleidererParkingPlaces);
	}

	private ParkingPlaces getParkingPlaces() {
		return parkingPlacesRepository.getParkingPlaces();
	}

	private Map<CompanyName, ParkingPlaceDTO> createAllParkingPlacesDTO(
			Map<CompanyName, ParkingPlace> pfleidererParkingPlaces) {
		Map<CompanyName, ParkingPlaceDTO> dtosMap = new HashMap();
		
		for (Entry<CompanyName, ParkingPlace> item : pfleidererParkingPlaces.entrySet()) {
			dtosMap.put(item.getKey(), item.getValue().getParkingPlacesDTO());
		}

		return dtosMap;
	}

}
