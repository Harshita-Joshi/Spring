package com.springboot.my.org.crudapi.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.RowMapper;

public class DBMapper implements RowMapper<Map<String,String>>{

	@Override
	public Map<String, String> mapRow(ResultSet res, int rowNum) throws SQLException {
		Map<String,String> map=new HashMap<>();
		map.put("worker_id", ""+res.getInt("worker_id"));
		map.put("first_name", res.getString("first_name"));
		map.put("last_name", res.getString("last_name"));
		map.put("salary",""+res.getInt("salary"));
		map.put("joining_date", res.getDate("joining_date")+"");
		map.put("department", res.getString("department"));
		map.put("email", res.getString("email"));
		map.put("worker_title", res.getString("worker_title"));
		map.put("affected_from",res.getDate("affected_from")+"");
		map.put("bonus_amount", res.getInt("bonus_amount")+"");
		map.put("bonus_date", res.getDate("bonus_date")+"");
		return map;
	}

}