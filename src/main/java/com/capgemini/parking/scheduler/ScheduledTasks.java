package com.capgemini.parking.scheduler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.capgemini.parking.groups.Group;
import com.capgemini.parking.groups.ParkPollGroupService;
import com.capgemini.parking.groups.ParkPollGroups;
import com.capgemini.parking.groups.ParkingPollGroupsConfiguration;

@Component
public class ScheduledTasks {

	@Autowired
	private CompanyParkingPlaceRepository companyParkingPlaceRepository;
	@Autowired
	private CompanyRepository companyRepository;
	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
	@Autowired
	private ParkPollGroupService parkPollGroupService;
	Map<String, Company> companies;
	@Autowired
	ParkingPollGroupsConfiguration configuration;

	private Long lastTimeStamp;

	@PostConstruct
	public void loadCompanies() {
		companies = new HashMap<>();
		for (Company c : companyRepository.findAll()) {
			companies.put(c.getName(), c);
		}
	}

	@Scheduled(fixedRate = 15 * 1000)
	public void reportCurrentTime() {

		try{
		ParkPollGroups parkGroups = parkPollGroupService.getParkPollGroups();
		Long timeStamp;
		try {
			timeStamp = getTimeStampFrom(parkGroups.getTimestamp());
		} catch (Exception e) {
			System.out.println("input file is empy or corupted \n" + e.getMessage());
			return;
		}

		if (lastTimeStamp == null || !lastTimeStamp.equals(timeStamp)) {
			Company company;
			for (Group g : parkGroups.getGroup()) {
				company = companies.get(g.getName());
				if (company == null) {
					company = new Company(g.getName());
					companyRepository.save(company);
					companies.put(company.getName(), company);
				}
				CompanyParkingPlace companyParkingPlace = new CompanyParkingPlace(company, g, timeStamp);
				companyParkingPlaceRepository.save(companyParkingPlace);
			}

			lastTimeStamp = timeStamp;
		}
		}catch (Exception e) {
			System.out.println("ScheduledTasks.reportCurrentTime()");
			e.printStackTrace();
		}

	}

	public CompanyParkingPlaceRepository getCompanyParkingPlaceRepository() {
		return companyParkingPlaceRepository;
	}

	public void setCompanyParkingPlaceRepository(CompanyParkingPlaceRepository companyParkingPlaceRepository) {
		this.companyParkingPlaceRepository = companyParkingPlaceRepository;
	}

	public ParkPollGroupService getParkPollGroupService() {
		return parkPollGroupService;
	}

	public void setParkPollGroupService(ParkPollGroupService parkPollGroupService) {
		this.parkPollGroupService = parkPollGroupService;
	}

	private Long getTimeStampFrom(String timestamp) throws ParseException {
		SimpleDateFormat date = new SimpleDateFormat(configuration.getDate());
		date.setTimeZone(TimeZone.getTimeZone(configuration.getTimezone()));
		return date.parse(timestamp).getTime();
	}

}