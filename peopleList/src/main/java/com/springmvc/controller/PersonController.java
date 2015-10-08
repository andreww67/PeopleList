package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.springmvc.model.Family;
import com.springmvc.model.FamilyPersonMap;
import com.springmvc.model.Person;
import com.springmvc.repository.FamilyPersonMapRepository;
import com.springmvc.repository.FamilyRepository;
import com.springmvc.repository.PersonRepository;

@RestController
@RequestMapping("/people")
public class PersonController {
  @Autowired
  private PersonRepository personRepo;
  
  @Autowired
  private FamilyRepository familyRepo;
  
  @Autowired
  private FamilyPersonMapRepository familyPersonRepo;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Person> findPeople() {
    return personRepo.findAll();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Person getFamily(@PathVariable Integer id) {
    return personRepo.findOne(id);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Person addPerson(@RequestBody Person person) {
    person.setId(null);
    return personRepo.saveAndFlush(person);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Person updatePerson(@RequestBody Person updatedPerson, @PathVariable Integer id) {
    updatedPerson.setId(id);
    return personRepo.saveAndFlush(updatedPerson);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deletePerson(@PathVariable Integer id) {
	  familyPersonRepo.delete(familyPersonRepo.findFPMByPersonId(id));
	  personRepo.delete(id);
  }
  
  @RequestMapping(value = "/{id}/addFamily/{familyId}", method = RequestMethod.POST)
  public FamilyPersonMap addPerson(@PathVariable Integer id, @PathVariable Integer familyId){
	  FamilyPersonMap fpm = new FamilyPersonMap();
	  fpm.setId(null);
	  fpm.setFamily(familyRepo.findOne(familyId));
	  fpm.setPerson(personRepo.findOne(id));
	  return familyPersonRepo.saveAndFlush(fpm);
  }
  
  @RequestMapping(value = "/{id}/getFamilies", method = RequestMethod.GET)
  public List<Family> findFamilyByPersonId(@PathVariable Integer id){
    return familyPersonRepo.findFamilesByPersonId(id);
  }
}
