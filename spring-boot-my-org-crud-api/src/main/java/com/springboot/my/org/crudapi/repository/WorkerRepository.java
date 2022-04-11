package com.springboot.my.org.crudapi.repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.WorkerDAO;
import com.springboot.my.org.crudapi.mapper.DBMapper;
import com.springboot.my.org.crudapi.mapper.WorkerMapper;
import com.springboot.my.org.crudapi.model.Worker;

@Repository("workerRepo")
public class WorkerRepository implements WorkerDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	
	public boolean addWorker(Worker worker) {
		String sql = "INSERT INTO worker VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		int rowAffected = jdbcTemplateObject.update(sql, worker.getWorkerId(), worker.getfirstName(), worker.getlastName(), worker.getSalary(), worker.getjoiningDate(), worker.getDepartment(), worker.getEmail());		
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
		String sql = """
					UPDATE worker SET email = ? WHERE worker_id = ?
				""";
		return jdbcTemplateObject.update(sql,email,id);
		
	}
	
	public boolean deleteWorkerById(int id) {
		String sql = "DELETE FROM worker WHERE worker_id = ?";
		int rowaffected = jdbcTemplateObject.update(sql, id);
		return (rowaffected==1);
	}


	@Override
	public boolean updateWorkerEmail(String email, int id) throws SQLException {
		// TODO Auto-generated method stub
		String sql = """
				UPDATE worker SET email = ? WHERE worker_id = ?
			""";
		int rowsAffected = jdbcTemplateObject.update(sql,email,id);
		if(rowsAffected==0)
			return false;
		return true;
	}

	@Override
	public List<Map<String, String>> getAllDetails() {
		String sql = """
    			select * from 
    			(select * from worker inner join title on worker_id = worker_ref_id) joined left join bonus 
    			on joined.worker_id = bonus.worker_ref_id
    			""";
		return jdbcTemplateObject.query(sql, new DBMapper());
	}

}