package io.github.MatheusFSantos.core.model.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.github.MatheusFSantos.core.model.domain.Hero;

@Repository
public interface HeroRepository extends JpaRepository<Hero, Long> {
	
	public Optional<Hero> findByName(String name);
	
}