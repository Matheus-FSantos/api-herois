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

import io.github.MatheusFSantos.core.model.domain.Hero;
import io.github.MatheusFSantos.core.model.services.HeroService;

@RestController
@RequestMapping("/heroes")
public class HeroController {
	
	@Autowired
	private HeroService heroService;
	
	@GetMapping
	public ResponseEntity<List<Hero>> findAll(){
		if(heroService.findAll() == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(heroService.findAll());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Hero> findById(@PathVariable Long id){
		if(heroService.findById(id) == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(heroService.findById(id));
	}
	
	@GetMapping("/name/{name}")
	public ResponseEntity<Hero> findByName(@PathVariable String name){
		if(heroService.findByName(name) == null)
			return ResponseEntity.notFound().build();
		
		return ResponseEntity.ok().body(heroService.findByName(name));
	}
	
	@PostMapping
	public ResponseEntity<Void> post(@RequestBody Hero newHero){
		heroService.post(newHero);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newHero.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> updateById(@PathVariable Long id, @RequestBody Hero newHero){
		newHero.updateId(id);
		
		if(heroService.update(newHero) != null)
			return ResponseEntity.noContent().build();
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteById(@PathVariable Long id){
		if(heroService.deleteById(id))
			return ResponseEntity.noContent().build();

		return ResponseEntity.notFound().build();
	}
}