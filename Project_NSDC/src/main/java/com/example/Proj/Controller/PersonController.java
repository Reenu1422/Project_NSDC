package com.example.Proj.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Proj.Entity.Movie;
import com.example.Proj.Entity.Person;
import com.example.Proj.Service.PersonService;
import com.example.Proj.exception.UserNotFoundException;
import com.example.Proj.repo.MovieRepo;
import com.example.Proj.repo.PersonRepo;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/person/movie")

public class PersonController {
	@Autowired
	private PersonService service;
	@Autowired
	private MovieRepo movieRepository;
	@Autowired
	private PersonRepo personRepo;
	
	@PostMapping
	public ResponseEntity<Person> savePerson(@RequestBody @Valid Person prsn){
		return new ResponseEntity<>(service.savePerson(prsn),HttpStatus.CREATED);	
	}
	
	@PostMapping("/list")
	public ResponseEntity<List<Person>> savePerson(@RequestBody @Valid List<Person> prsns){
		return new ResponseEntity<>(service.savePersons(prsns),HttpStatus.CREATED);	
	}
	
	@GetMapping
	public ResponseEntity<List<Person>> getAllPersonsInfo(){
        return ResponseEntity.ok(service.getALlPersons());
	}


	 @GetMapping("/findbyid/{id}")
	 public Person getAllPersonById( @PathVariable int id) throws UserNotFoundException {
			return service.findAllPersonById(id);
		}
	 
	 @GetMapping("/PersonByName/{name}")
		public List<Person> findPersonByName(@PathVariable String name) {
			return service.getPersonByName(name);
		}
	 @GetMapping("/search/{genres}")
	 public List<Movie> genresList(@PathVariable String genres){
		 return movieRepository.getMovieByGenres(genres);
	 }
		@PutMapping("/update")
		public Person updatePerson(@RequestBody Person prsn) {
			return personRepo.save(prsn);
		}

		@DeleteMapping("/delete/{id}")
		public String deletePerson(@PathVariable int id) {
			return service.deletePerson(id);
		}
	 
	 @DeleteMapping("/delete")
	 public String delete() {
		 return service.deleteAllData();
	 }
}


