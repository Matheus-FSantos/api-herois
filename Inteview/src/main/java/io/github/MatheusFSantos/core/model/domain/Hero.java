package io.github.MatheusFSantos.core.model.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Hero implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "HERO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String name;

	private Race race;

	@ManyToOne
	@JoinColumn(nullable=false, name="powerStats_id")
	private PowerStats powerStats;

	@Column(nullable = false)
	private Date createdAt;

	@Column(nullable = false)
	private Date updatedAt;

	private Boolean enabled;
	
	public Hero() { }
	
	public Hero(Long id, String name, Race race, PowerStats powerStats, Date createdAt, Date updatedAt, Boolean enabled) {
		this.id = id;
		this.name = name;
		this.race = race;
		this.powerStats = powerStats;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.enabled = enabled;
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
		Hero other = (Hero) obj;
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

	public String getName() {
		return name;
	}
	
	public void updateName(String name) {
		this.setName(name);
	}

	private void setName(String name) {
		this.name = name;
	}

	public Race getRace() {
		return race;
	}
	
	public void updateRace(Race race) {
		this.setRace(race);
	}

	private void setRace(Race race) {
		this.race = race;
	}

	public PowerStats getPowerStats() {
		return powerStats;
	}
	
	public void updatePowerStats(PowerStats powerStats) {
		this.setPowerStats(powerStats);
	}

	private void setPowerStats(PowerStats powerStats) {
		this.powerStats = powerStats;
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

	public Boolean isEnabled() {
		return enabled;
	}
	
	public void updateEnabled(Boolean enabled) {
		this.setEnabled(enabled);
	}

	private void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
	
	public String getRaceFormated() {
		return Race.valueOf(this.race.getCode());
	}
}
