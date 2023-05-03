package io.github.MatheusFSantos.core.model.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.MatheusFSantos.core.model.domain.PowerStats;
import io.github.MatheusFSantos.core.model.repositories.PowerStatsRepository;

@Service
public class PowerStatsService {
	
	@Autowired
	private PowerStatsRepository powerStatsRepository;

	public List<PowerStats> findAll() {
		if(powerStatsRepository.findAll() == null)
			return null;
		
		return powerStatsRepository.findAll();
	}
	
	public PowerStats findById(Long id) {
		if(powerStatsRepository.findById(id).isEmpty())
			return null;
		
		return powerStatsRepository.findById(id).get();
	}
	
	public void post(PowerStats powerStats) {
		powerStats.updateCreatedAt(this.instant());
		powerStats.updateUpdatedAt(this.instant());
		
		this.validations(powerStats);
		
		powerStatsRepository.save(powerStats);
	}
	
	public Boolean deleteById(Long id) {
		if(this.findById(id) != null) {
			powerStatsRepository.deleteById(id);
			return true;
		}
		
		return false;
	}
	
	public PowerStats update(PowerStats newPowerStats) {
		PowerStats powerStats = this.findById(newPowerStats.getId());
		
		if(powerStats != null) {
			this.modify(powerStats, newPowerStats);
			return powerStatsRepository.save(powerStats);
		}
		
		return null;
	}

	private void modify(PowerStats powerStats, PowerStats newPowerStats) {
		this.validations(newPowerStats);
		
		powerStats.updateAgility(newPowerStats.getAgility());
		powerStats.updateIntelligence(newPowerStats.getIntelligence());
		powerStats.updateStrength(newPowerStats.getStrength());
		powerStats.updateDexterity(newPowerStats.getDexterity());
		
		powerStats.updateUpdatedAt(this.instant());
	}
	
	private Date instant() {
		return Calendar.getInstance().getTime();
	}
	
	private void validations(PowerStats powerStats) {
		if(powerStats.getAgility() > 100)
			powerStats.updateAgility(100);
		
		if(powerStats.getDexterity() > 100)
			powerStats.updateDexterity(100);
		
		if(powerStats.getIntelligence() > 100)
			powerStats.updateIntelligence(100);
		
		if(powerStats.getStrength() > 100)
			powerStats.updateStrength(100);
	}
}