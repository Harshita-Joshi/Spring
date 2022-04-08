package com.springboot.workers.crudapi.repository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.crudapi.dao.WorkerDAO;
import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.util.WorkerMapper;




@Repository("workerRepo")
public class WorkerRepository implements WorkerDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	
	public boolean add(Worker worker) {
		String sql = "INSERT INTO worker VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		int rowAffected = jdbcTemplateObject.update(sql, worker.getWORKER_ID(), worker.getFIRST_NAME(), worker.getLAST_NAME(), worker.getSALARY(), worker.getJOINING_DATE(), worker.getDEPARTMENT(), worker.getEmail());		
		return (rowAffected==1);
	}
	
	@SuppressWarnings("deprecation")
	public Worker getWorker(int id) {
		String sql = "SELECT * FROM worker WHERE worker_id = ?";
		Worker worker = jdbcTemplateObject.queryForObject(
				sql, 
				new Object[] {id}, 
				new WorkerMapper()
				);
		
		return worker;
	}
	
	public List<Worker> getWorkers() {
		String sql = "SELECT * FROM worker";
		List<Worker> students = jdbcTemplateObject.query(
				sql, 
				new WorkerMapper()
				);
		
		return students;
	}
	
	public int replace(int id, String email) {
		String sql = "UPDATE worker SET email = "+"'email'"+" WHERE worker_id = ?";
		return jdbcTemplateObject.update(sql,id);
		
	}
	
	public boolean delete(int id) {
		String sql = "DELETE FROM worker WHERE worker_id = ?";
		int rowaffected = jdbcTemplateObject.update(sql, id);
		return (rowaffected==1);
	}


	@Override
	public boolean updateWorkerEmail(String email, int id) throws SQLException {
		// TODO Auto-generated method stub
		int rowsAffected = replace(id, email);
		if(rowsAffected==0)
			return false;
		return true;
	}

}