package io.github.MatheusFSantos.core.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import io.github.MatheusFSantos.core.model.domain.PowerStats;
import io.github.MatheusFSantos.core.model.services.PowerStatsService;

@RestController
@RequestMapping("/powerStats")
public class PowerStatsController {
	
	@Autowired
	private PowerStatsService powerStatsService;
	
	@GetMapping
	public ResponseEntity<List<PowerStats>> findAll(){
		if(powerStatsService.findAll().isEmpty())
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(powerStatsService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PowerStats> findById(@PathVariable Long id){
		if(powerStatsService.findById(id) == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(powerStatsService.findById(id));
	}
	
	@PostMapping
	public ResponseEntity<Void> post(@RequestBody PowerStats powerStats){
		powerStatsService.post(powerStats);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(powerStats.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody PowerStats newPowerStats){
		newPowerStats.updateId(id);
		if(powerStatsService.update(newPowerStats) != null)
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		if(powerStatsService.deleteById(id))
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.notFound().build();
	}
}