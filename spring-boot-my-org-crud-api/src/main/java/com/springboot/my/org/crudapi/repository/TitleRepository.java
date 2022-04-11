package com.springboot.my.org.crudapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.TitleDAO;
import com.springboot.my.org.crudapi.mapper.TitleMapper;
import com.springboot.my.org.crudapi.model.Title;
import com.springboot.my.org.crudapi.util.DateTimeUtilities;

@Repository("tRepo")
public class TitleRepository implements TitleDAO {

	@Autowired
	JdbcTemplate jdbcTemplateObject;

	@Override
	public boolean createTitleById(int id, String title) {
		String update = "insert into title values (?,?,?)";
		return jdbcTemplateObject.update(update, id, title, DateTimeUtilities.getTime()) > 0;
	}
	
	@Override
	public Title findTitleById(int workerRefId) {
		String sql = "select * from title where worker_ref_id=" + workerRefId;
		return jdbcTemplateObject.queryForObject(sql, new TitleMapper());
	}

	@Override
	public boolean deleteTitleById(int workerRefId) {
		String sql = "delete from title where worker_ref_id=" + workerRefId + " order by affected_from desc limit 1";
		return jdbcTemplateObject.update(sql) > 0;
	}

	@Override
	public boolean replaceTitle(Title title) {
		String update = "update title set worker_title=?, affected_from=? where worker_ref_id=?";
		return jdbcTemplateObject.update(update, title.getWorker_title(), title.getAffected_from(),
				title.getWorker_ref_id()) > 0;
	}


	@Override
	public List<Title> findAllTitles() {
		String sql = "select * from title";
		return jdbcTemplateObject.query(sql, new TitleMapper());
	}

	
	

}