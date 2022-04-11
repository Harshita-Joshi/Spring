package com.springboot.workers.crudapi.service;

import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.springboot.workers.crudapi.model.Worker;
import com.springboot.workers.crudapi.repository.WorkerRepository;

@Service
public class WorkerService {
	
	@Resource(name = "workerRepo")
	private WorkerRepository wrepo;
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	
	
	public boolean add(Worker worker) {
		return this.wrepo.addWorker(worker);
	}
	
	public Worker getWorker(int id) {
		return this.wrepo.getWorker(id);
	}
	
	public List<Worker> getWorkers() {
		return this.wrepo.getWorkers();
	}
	
	
	public boolean delete(int id) {
		return this.wrepo.deleteWorkerById(id);
	}


	public boolean updateWorkerById(String email, int id) throws SQLException {
		return this.wrepo.updateWorkerEmail(email, id);
	}
	
}
