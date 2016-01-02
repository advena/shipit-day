/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.capgemini.somethingnew;

import java.util.List;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author advena
 */
@XmlRootElement(name="ParkPollGroups")
public class ParkPollGroups {

    private String timestamp;
    private List<Group> group;

    public ParkPollGroups() {
    }

    public String getTimestamp() {
        return timestamp;
    }

    @XmlAttribute
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public List<Group> getGroup() {
        return group;
    }
    
    @XmlElement(name="Group")
    public void setGroup(List<Group> group) {
        this.group = group;
    }

}
