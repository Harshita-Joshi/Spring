package com.springboot.workers.springjdbcexample.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.springboot.workers.springjdbcexample.model.Worker;



public class WorkerMapper implements RowMapper<Worker> {
	public Worker mapRow(ResultSet result, int rowNum) throws SQLException {
		Worker worker = new Worker();
		worker.setWORKER_ID(result.getInt("worker_id"));
		worker.setFIRST_NAME(result.getString("first_name"));
		worker.setLAST_NAME(result.getString("last_name"));
		worker.setSALARY(result.getInt("salary"));
		worker.setJOINING_DATE(result.getDate("joining_date"));
		worker.setDEPARTMENT(result.getString("department"));
		
		return worker;
	}
}