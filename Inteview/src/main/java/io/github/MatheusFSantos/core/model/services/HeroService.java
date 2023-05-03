package io.github.MatheusFSantos.core.model.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.MatheusFSantos.core.model.domain.Hero;
import io.github.MatheusFSantos.core.model.repositories.HeroRepository;

@Service
public class HeroService {
	
	@Autowired
	private HeroRepository heroRepository;
	
	public List<Hero> findAll() {
		if(heroRepository.findAll().isEmpty())
			return null;
		
		return heroRepository.findAll();
	}
	
	public Hero findById(Long id) {
		if(!heroRepository.findById(id).isPresent())
			return null;
		
		return heroRepository.findById(id).get();
	}
	
	public Hero findByName(String name) {
		if(!heroRepository.findByName(name).isPresent())
			return null;
		
		return heroRepository.findByName(name).get();
	}
	
	public void post(Hero hero) {
		hero.updateCreatedAt(this.instant());
		hero.updateUpdatedAt(this.instant());
		
		heroRepository.save(hero);
	}
	
	public Boolean deleteById(Long id) {
		if(this.findById(id) != null) {
			heroRepository.deleteById(id);
			return true;
		}
		
		return false;
	}

	public Hero update(Hero newHero) {
		Hero hero = this.findById(newHero.getId());
		
		if(hero != null) {
			this.modify(hero, newHero);
			heroRepository.save(hero);
			
			return hero;
		}
		
		return null;
	}
	
	public void modify(Hero hero, Hero newHero) {
		hero.updateName(newHero.getName());
		hero.updateRace(newHero.getRace());
		hero.updatePowerStats(newHero.getPowerStats());
		hero.updateUpdatedAt(this.instant());
	}
	
	private Date instant() {
		return Calendar.getInstance().getTime();
	}
}