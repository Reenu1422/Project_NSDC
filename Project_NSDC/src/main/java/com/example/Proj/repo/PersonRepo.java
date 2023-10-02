package com.example.Proj.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Proj.Entity.Person;

public interface PersonRepo extends JpaRepository<Person, Integer>{

	List<Person> findPersonByName(String name);

}
