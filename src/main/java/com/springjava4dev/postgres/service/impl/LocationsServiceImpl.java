package com.springjava4dev.postgres.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springjava4dev.postgres.dao.LocationsDao;
import com.springjava4dev.postgres.model.Locations;
import com.springjava4dev.postgres.service.LocationsService;


@Service
public class LocationsServiceImpl implements LocationsService{

	@Autowired LocationsDao locationsDao;
	

	@Override
	public String getLocationDataByTimeStamp(String timestamp, String modifiedTimestamp) {
		
		return locationsDao.getLocationDataByTimeStamp(timestamp, modifiedTimestamp);
	}

}
