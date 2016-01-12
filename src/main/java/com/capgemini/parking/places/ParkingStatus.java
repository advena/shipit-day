/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini.parking.places;

/**
 *
 * @author advena
 */
public class ParkingStatus {

    private final Integer spaces;
    private final Integer occupied;
    private final Integer free;

    public ParkingStatus(Integer spaces, Integer occupied, Integer free) {
        this.spaces = spaces;
        this.occupied = occupied;
        this.free = free;
    }

    public Integer getFree() {
        return free;
    }
    

}
