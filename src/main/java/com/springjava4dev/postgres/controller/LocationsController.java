package com.springjava4dev.postgres.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springjava4dev.postgres.service.LocationsService;

@Controller
@RequestMapping("/locations")
public class LocationsController {
	
	@Autowired
	LocationsService locationsService;
    
	
	@RequestMapping(value = "/changes", method = RequestMethod.POST)//, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String getLocationDataByTimeStamp(@RequestBody String timestamp) {
		System.out.println("Test print");
        return locationsService.getLocationDataByTimeStamp(timestamp,"2016-10-23 12:07:38.07772");
    }
	
}
