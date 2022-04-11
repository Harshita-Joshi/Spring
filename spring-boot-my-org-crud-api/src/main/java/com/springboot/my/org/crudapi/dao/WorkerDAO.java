package com.springboot.my.org.crudapi.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.springboot.my.org.crudapi.model.Worker;

public interface WorkerDAO {
    public boolean addWorker(Worker worker)
            throws SQLException;

    public boolean deleteWorkerById(int workerId)
            throws SQLException;

    public Worker getWorker(int workerId)
            throws SQLException;

    public List<Worker> getWorkers()
            throws SQLException;
    
    public boolean updateWorkerEmail(String email, int id) 
    		throws SQLException;

    public int replace(int id, String email)
            throws SQLException;
    
    public List<Map<String,String>> getAllDetails();
}