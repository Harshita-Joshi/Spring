package com.springboot.workers.springjdbcexample.dao;

import java.sql.SQLException;
import java.util.List;

import com.springboot.workers.springjdbcexample.model.Worker;

import java.sql.Date;


public interface WorkerDAO {
    public void add(int id, String fname, String lname, int salary, Date joinDate, String department)
            throws SQLException;

    public void delete(int workerId)
            throws SQLException;

    public Worker getWorker(int workerId)
            throws SQLException;

    public List<Worker> getWorkers()
            throws SQLException;

    public void update(int id, String department)
            throws SQLException;
}
