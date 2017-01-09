package com.springjava4dev.postgres;

import static org.junit.Assert.assertEquals;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.boot.test.SpringApplicationConfiguration;

import com.springjava4dev.postgres.dao.LocationsDao;
import com.springjava4dev.postgres.service.LocationsService;
import com.springjava4dev.postgres.service.impl.LocationsServiceImpl;


@RunWith(MockitoJUnitRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
public class JdbctemplatePostgresApplicationTests {
	
	@Mock
	LocationsDao locationsDao;
	
	@InjectMocks
	LocationsService locationsService = new LocationsServiceImpl();

	@Test
	public void contextLoads() {
	}

	@Test
	public void testLocationsService(){
		String timestamp = "2016-10-23 12:01:30.709142";
		String modifiedTimeStamp = "2016-10-23 12:01:30.709142";
		String expected = "a";
		Mockito.when(locationsDao.getLocationDataByTimeStamp(timestamp, modifiedTimeStamp)).thenReturn(expected);
		
		String actual = locationsService.getLocationDataByTimeStamp(timestamp, modifiedTimeStamp);
		
		assertEquals(expected, actual);
		
		
		
	}
}
