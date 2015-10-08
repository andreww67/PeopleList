package com.springmvc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springmvc.model.Family;
import com.springmvc.model.FamilyPersonMap;
import com.springmvc.model.Person;

public interface FamilyPersonMapRepository extends JpaRepository<FamilyPersonMap, Integer> {
	
	@Query("SELECT fpm.person FROM FamilyPersonMap fpm where fpm.family.id = :id") 
    public List<Person> findPeopleByFamilyId(@Param("id") Integer id);
	
	@Query("SELECT fpm.family FROM FamilyPersonMap fpm where fpm.person.id = :id") 
    public List<Family> findFamilesByPersonId(@Param("id") Integer id);
	
	@Query("SELECT fpm FROM FamilyPersonMap fpm where fpm.family.id = :id") 
    public List<FamilyPersonMap> findFPMByFamilyId(@Param("id") Integer id);
	
	@Query("SELECT fpm FROM FamilyPersonMap fpm where fpm.person.id = :id") 
    public List<FamilyPersonMap> findFPMByPersonId(@Param("id") Integer id);
     
}
