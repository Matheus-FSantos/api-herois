package io.github.MatheusFSantos.core.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class PowerStats implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "POWERSTATS_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@JsonIgnore
	@OneToMany(mappedBy="powerStats", orphanRemoval=true)
	private List<Hero> heroes = new ArrayList<Hero>();
	
	private Integer strength;
    
    private Integer agility;
    
    private Integer dexterity;
    
    private Integer intelligence;
    
    private Date createdAt;
    
    private Date updatedAt;
    
    public PowerStats() { }

	public PowerStats(Long id, Integer strength, Integer agility, Integer dexterity, Integer intelligence, Date createdAt, Date updatedAt) {
		this.id = id;
		this.strength = strength;
		this.agility = agility;
		this.dexterity = dexterity;
		this.intelligence = intelligence;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PowerStats other = (PowerStats) obj;
		return Objects.equals(id, other.id);
	}

	public Long getId() {
		return id;
	}
	
	public void updateId(Long id) {
		this.setId(id);
	}

	private void setId(Long id) {
		this.id = id;
	}

	public Integer getStrength() {
		return strength;
	}
	
	public void updateStrength(Integer strength) {
		this.setStrength(strength);
	}

	private void setStrength(Integer strength) {
		this.strength = strength;
	}

	public Integer getAgility() {
		return agility;
	}
	
	public void updateAgility(Integer agility) {
		this.setAgility(agility);
	}

	private void setAgility(Integer agility) {
		this.agility = agility;
	}

	public Integer getDexterity() {
		return dexterity;
	}
	
	public void updateDexterity(Integer dexterity) {
		this.setDexterity(dexterity);
	}

	private void setDexterity(Integer dexterity) {
		this.dexterity = dexterity;
	}

	public Integer getIntelligence() {
		return intelligence;
	}
	
	public void updateIntelligence(Integer intelligence) {
		this.setIntelligence(intelligence);
	}

	private void setIntelligence(Integer intelligence) {
		this.intelligence = intelligence;
	}

	public Date getCreatedAt() {
		return createdAt;
	}
	
	public void updateCreatedAt(Date createdAt) {
		this.setCreatedAt(createdAt);
	}

	private void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	public void updateUpdatedAt(Date updatedAt) {
		this.setUpdatedAt(updatedAt);
	}

	private void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Hero> getHeroes() {
		return heroes;
	}
    
}