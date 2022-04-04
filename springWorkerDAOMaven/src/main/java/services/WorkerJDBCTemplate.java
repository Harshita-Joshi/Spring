package services;

import java.sql.Date;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;


import dao.WorkerDAO;
import mappers.WorkerMapper;
import model.Worker;

public class WorkerJDBCTemplate implements WorkerDAO {
	@SuppressWarnings("unused")
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}
	
	public void add(int id, String fname, String lname, int salary, Date joinDate, String department) {
		String sql = "INSERT INTO worker VALUES (" +"?, ?, ?, ?, ?, ?)";
		
		jdbcTemplateObject.update(sql, id, fname, lname, salary, joinDate, department);
		
		System.out.println("Worker " + id + "'s record inserted successfully");
		return;
	}
	
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