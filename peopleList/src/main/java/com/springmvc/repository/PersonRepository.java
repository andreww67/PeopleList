package com.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.model.Person;

public interface PersonRepository extends JpaRepository<Person, Integer> {

}
