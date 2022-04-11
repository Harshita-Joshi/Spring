package com.springboot.my.org.crudapi.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springboot.my.org.crudapi.dao.BonusDAO;
import com.springboot.my.org.crudapi.mapper.BonusMapper;
import com.springboot.my.org.crudapi.model.Bonus;

@Repository("bRepo")
public class BonusRepository implements BonusDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplateObject;
	@Override
	public boolean addBonusById(Bonus bonus) {
		String sql = "insert into bonus values (?,?,?)";
		return jdbcTemplateObject.update(sql,bonus.getWorker_ref_id(),bonus.getBonus_amount(),bonus.getBonus_date())==1;
	}

	@Override
	public boolean deleteBonusById(int workerRefId) {
		String sql = "delete from bonus where worker_ref_id=" + workerRefId + " order by bonus_date desc limit 1";
		return jdbcTemplateObject.update(sql)>0;
	}

	@Override
	public Bonus findBonusById(int workerRefId) {
		String sql = "select * from bonus where worker_ref_id="+workerRefId;
		return jdbcTemplateObject.queryForObject(sql, new BonusMapper());
	}


	@Override
	public List<Bonus> findAllBonus() {
		String sql = "select * from bonus";
		return jdbcTemplateObject.query(sql, new BonusMapper());
	}

	@Override
	public boolean replaceBonus(Bonus bonus) {
		String update = "update bonus set bonus_amount=?, bonus_date=? where worker_ref_id=?";
		return jdbcTemplateObject.update(update,bonus.getBonus_amount(),bonus.getBonus_date(),bonus.getWorker_ref_id())>0;
	}

}