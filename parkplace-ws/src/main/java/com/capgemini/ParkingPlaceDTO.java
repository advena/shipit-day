/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini;

import java.util.Date;

/**
 *
 * @author advena
 */
public class ParkingPlaceDTO {

    private final Integer freeParkplaces;
    private final Date lastDateUpdate;

    public ParkingPlaceDTO(Integer freeParkplaces, Date lastDateUpdate) {
        this.freeParkplaces = freeParkplaces;
        this.lastDateUpdate = lastDateUpdate;
    }

    public Integer getFreeParkplaces() {
        return freeParkplaces;
    }

    public Date getLastDateUpdate() {
        return lastDateUpdate;
    }

    
}
