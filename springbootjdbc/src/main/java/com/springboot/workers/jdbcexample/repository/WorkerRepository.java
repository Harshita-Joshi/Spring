package com.springboot.workers.jdbcexample.repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

import com.springboot.workers.jdbcexample.dao.WorkerDAO;
import com.springboot.workers.jdbcexample.model.Worker;
import com.springboot.workers.jdbcexample.util.DatabaseConnection;


@Repository
public class WorkerRepository implements WorkerDAO {
		private static Connection conn;

		public WorkerRepository() {
			conn = DatabaseConnection.getConnection();
		}
		
		public void add(int id, String fname, String lname, int salary, Date joinDate, String department) throws SQLException {
			String sql = """
						INSERT INTO worker VALUES (?, ?, ?, ?, ?, ?)
						""";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.setString(2,  fname);
			pstmt.setString(3,  lname);
			pstmt.setInt(4,  salary);
			pstmt.setDate(5,  joinDate);
			pstmt.setString(6,  department);
			
			pstmt.executeUpdate();
			System.out.println("Worker " + id + "'s record inserted successfully");
			
		}
		
		public Worker getWorker(int id) throws SQLException {
			
			String sql = """
						SELECT * FROM worker WHERE worker_id = ?
						 """;
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  id);
			ResultSet res = pstmt.executeQuery();
			res.next();
			return new Worker(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getDate(5),
					res.getString(6));
			
			
		}
		
		public List<Worker> getWorkers() throws SQLException {
			String sql = """
						SELECT * FROM worker
						""";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			List<Worker> workerList = new ArrayList<>();
			ResultSet res = pstmt.executeQuery();
			
			while(res.next()) {
				workerList.add(new Worker(res.getInt(1), res.getString(2), res.getString(3), res.getInt(4), res.getDate(5),
						res.getString(6)));
			}
			return workerList;
			
		}
		
		public void update(int id, String department) throws SQLException {
			String sql = """
							UPDATE worker SET department = ? WHERE worker_id = ?
						""";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, department);
			pstmt.setInt(2, id);
			
			pstmt.executeUpdate();
			
			System.out.println("Record #" + id + "'s department updated to " + department);
		
		}
		
		public void delete(int id) throws SQLException {
			
			String sql = "DELETE FROM worker WHERE worker_id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
			System.out.println("Record #" + id + " deleted");
			
		}
}

