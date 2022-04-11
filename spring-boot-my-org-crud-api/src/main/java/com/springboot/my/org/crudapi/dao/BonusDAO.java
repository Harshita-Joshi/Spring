package com.springboot.my.org.crudapi.dao;

import java.util.List;

import com.springboot.my.org.crudapi.model.Bonus;

public interface BonusDAO {
	
	public boolean addBonusById(Bonus bonus);

	public boolean deleteBonusById(int workerRefId);

	public Bonus findBonusById(int workerRefId);
	
	public boolean replaceBonus(Bonus bonus);
	
	public List<Bonus> findAllBonus();

}