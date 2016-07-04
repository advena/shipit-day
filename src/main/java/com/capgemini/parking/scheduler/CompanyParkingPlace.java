package com.capgemini.parking.scheduler;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.parking.groups.Group;

@Entity
@Table(name = "COMPANY_PLACES")
public class CompanyParkingPlace {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	private Long timestamp;
	private int groupId;
	@ManyToOne(targetEntity=Company.class)
	private Company company;
	private int spaces;
	private int occupied;
	private int free;
	private Date insertDate = new Date();

	public CompanyParkingPlace(Company company, Group group, Long timeStamp) {
		this.company = company;
		this.groupId = group.getId();
		this.spaces = group.getSpaces();
		this.occupied = group.getOccupied();
		this.free = group.getFree();
		this.setTimestamp(timeStamp);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	public int getSpaces() {
		return spaces;
	}

	public void setSpaces(int spaces) {
		this.spaces = spaces;
	}

	public int getOccupied() {
		return occupied;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public void setOccupied(int occupied) {
		this.occupied = occupied;
	}

	public int getFree() {
		return free;
	}

	public void setFree(int free) {
		this.free = free;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public Date getInsertDate() {
		return insertDate;
	}

	public void setInsertDate(Date insertDate) {
		this.insertDate = insertDate;
	}

}
