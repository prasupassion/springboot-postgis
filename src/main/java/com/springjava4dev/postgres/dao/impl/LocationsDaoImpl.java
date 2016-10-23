package com.springjava4dev.postgres.dao.impl;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.springjava4dev.postgres.dao.LocationsDao;

@Repository
public class LocationsDaoImpl extends JdbcDaoSupport implements LocationsDao{
	
	@Autowired 
	DataSource dataSource;
	
	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}
	

	@Override
	public String getLocationDataByTimeStamp(String timeStamp,String modifiedTimeStamp) {
		//String sql = "SELECT row_to_json(fc)  FROM ( SELECT 'FeatureCollection' As type, array_to_json(array_agg(f)) As features  FROM (SELECT 'Feature' As type     , geometry     , row_to_json((SELECT l FROM (SELECT device_id, device_ts, loc_name) As l       )) As properties    FROM (SELECT a.device_id as device_id,a.device_ts as device_ts,a.loc_name as loc_name,ST_AsGeoJSON(a.geog)::json As geometry from locations as a     WHERE EXISTS       ( SELECT b.device_id as device_id,b.device_ts as device_ts,b.loc_name as loc_name,ST_AsGeoJSON(b.geog)::json as geometry         FROM locations AS b         WHERE a.device_id = b.device_id           AND a.device_ts > b.device_ts   AND a.device_ts >=  ? AND a.device_ts <= "+ "'"+modifiedTimeStamp+"'"+ " ORDER BY b.device_ts DESC         LIMIT 1       )  )As lg   ) As f )  As fc";	
		String sql = "SELECT row_to_json(fc)  FROM ( SELECT 'FeatureCollection' As type, array_to_json(array_agg(f)) As features  FROM (SELECT 'Feature' As type     , geometry     , row_to_json((SELECT l FROM (SELECT device_id, device_ts, loc_name) As l       )) As properties    FROM (SELECT a.device_id as device_id,a.device_ts as device_ts,a.loc_name as loc_name,ST_AsGeoJSON(a.geog)::json As geometry from locations as a     WHERE EXISTS       ( SELECT b.device_id as device_id,b.device_ts as device_ts,b.loc_name as loc_name,ST_AsGeoJSON(b.geog)::json as geometry         FROM locations AS b         WHERE a.device_id = b.device_id           AND a.device_ts > b.device_ts   AND a.device_ts >="+"'"+timeStamp+"'" + " AND a.device_ts <= "+ "'"+modifiedTimeStamp+"'"+ " ORDER BY b.device_ts DESC         LIMIT 1       )  )As lg   ) As f )  As fc";
		System.out.println("SQL: "+ sql);
		//return getJdbcTemplate().queryForObject(sql, new Object[]{timeStamp}, String.class);
		return getJdbcTemplate().queryForObject(sql,String.class);
	}

	@Override
	public int getTotalNumberOfLocations() {
		String sql = "SELECT Count(*) FROM locations";
		int total = getJdbcTemplate().queryForObject(sql, Integer.class);
		return total;
	}

	
}

