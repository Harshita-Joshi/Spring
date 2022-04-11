package com.springboot.my.org.crudapi.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import org.springframework.stereotype.Service;
import com.springboot.my.org.crudapi.model.Worker;
import com.springboot.my.org.crudapi.repository.WorkerRepository;

@Service
public class WorkerService {
	@Resource(name="workerRepo")
	WorkerRepository wRepo;
	
	public Worker getWorker(Integer id) {
			return wRepo.getWorker(id);
	}
	

	public List<Worker> getWorkers() {
			return wRepo.getWorkers();
	}
	
	public boolean createWorker(Worker worker) {
			return wRepo.addWorker(worker);
	}

	public boolean updateWorker(int id, String email) {
		
			try {
				return wRepo.updateWorkerEmail(email, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return false;
	}

	public boolean deleteWorkerById(Integer id) {
			return wRepo.deleteWorkerById(id);
	}
	
	public List<Map<String,String>> getWorkerDetails() {
			return wRepo.getAllDetails();
	}
	
}