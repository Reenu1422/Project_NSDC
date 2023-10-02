package com.example.Proj.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Proj.Entity.Person;
import com.example.Proj.exception.UserNotFoundException;
import com.example.Proj.repo.PersonRepo;

import jakarta.validation.Valid;

@Service
public class PersonService {
	
	@Autowired
    private PersonRepo repo;
	public Person savePerson(Person prsn) {
		return repo.save(prsn);
	}
	public List<Person> getALlPersons() {
        return repo.findAll();
    }

	public String deleteAllData() {
		repo.deleteAll();
		return "All Entries are removed.....";
		
	}
	public Person findAllPersonById(int id) throws UserNotFoundException {
		Optional<Person> prsn= repo.findById(id);
		if(prsn.isPresent())
		return prsn.get();
		else
			throw new UserNotFoundException("Person not found with id:"+id);
	}
	public List<Person> getPersonByName(String name) {
		return repo.findPersonByName(name);
	}
	
	public String deletePerson(int id) {
		repo.deleteById(id);
		return "Selected Person is removed.."+id;
	}
	public List<Person> savePersons(@Valid List<Person> prsns) {
		// TODO Auto-generated method stub
		return repo.saveAll(prsns);
	}

}

 