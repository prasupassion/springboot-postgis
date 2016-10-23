package com.springjava4dev.postgres.dao;


public interface LocationsDao {
	
	String getLocationDataByTimeStamp(String timestamp,String modifiedTimeStamp);
	int getTotalNumberOfLocations();
}
