package com.springboot.workers.springjdbcexample.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.workers.springjdbcexample.dao.WorkerDAO;
import com.springboot.workers.springjdbcexample.mapper.WorkerMapper;
import com.springboot.workers.springjdbcexample.model.Worker;


@Repository("workerRepo")
public class WorkerRepository implements WorkerDAO {
	@Autowired
	private JdbcTemplate jdbcTemplateObject;
	
	
	public void add(int id, String fname, String lname, int salary, Date joinDate, String department) {
		String sql = "INSERT INTO worker VALUES (" +"?, ?, ?, ?, ?, ?)";
		
		jdbcTemplateObject.update(sql, id, fname, lname, salary, joinDate, department);
		
		System.out.println("Worker " + id + "'s record inserted successfully");
		return;
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
	
	public void update(int id, String department) {
		String sql = "UPDATE worker SET department = ? WHERE worker_id = ?";
		jdbcTemplateObject.update(sql, department, id);
		System.out.println("Record #" + id + "'s department updated to " + department);
		return;
	}
	
	public void delete(int id) {
		String sql = "DELETE FROM worker WHERE worker_id = ?";
		jdbcTemplateObject.update(sql, id);
		System.out.println("Record #" + id + " deleted");
		return;
	}
}