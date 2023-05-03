package io.github.MatheusFSantos.core.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.MatheusFSantos.core.model.domain.PowerStats;

@Repository
public interface PowerStatsRepository extends JpaRepository<PowerStats, Long>{
	
}