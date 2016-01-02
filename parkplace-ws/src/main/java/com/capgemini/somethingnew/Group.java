/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini.somethingnew;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author advena
 */
@XmlRootElement(name="Group")
class Group {

    private int id;
    private String name;
    private int spaces;
    private int occupied;
    private int free;

    public int getId() {
        return id;
    }

    @XmlAttribute
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    @XmlAttribute
    public void setName(String name) {
        this.name = name;
    }

    public int getSpaces() {
        return spaces;
    }

    @XmlAttribute
    public void setSpaces(int spaces) {
        this.spaces = spaces;
    }

    public int getOccupied() {
        return occupied;
    }

    @XmlAttribute
    public void setOccupied(int occupied) {
        this.occupied = occupied;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }
}
