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
@RequestMapping("/families")
public class FamilyController {
  @Autowired
  private FamilyRepository familyRepo;
  
  @Autowired
  private FamilyPersonMapRepository familyPersonRepo;
  
  @Autowired
  private PersonRepository personRepo;
  
  @RequestMapping(method = RequestMethod.GET)
  public List<Family> findFamily() {
    return familyRepo.findAll();
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Family getFamily(@PathVariable Integer id) {
    return familyRepo.findOne(id);
  }
  
  @RequestMapping(method = RequestMethod.POST)
  public Family addFamily(@RequestBody Family family) {
    family.setId(null);
    return familyRepo.saveAndFlush(family);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
  public Family updateFamily(@RequestBody Family updatedFamily, @PathVariable Integer id) {
	  updatedFamily.setId(id);
    return familyRepo.saveAndFlush(updatedFamily);
  }
  
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteFamily(@PathVariable Integer id) {
	  familyPersonRepo.delete(familyPersonRepo.findFPMByFamilyId(id));
	  familyRepo.delete(id);
  }
  
  @RequestMapping(value = "/{id}/addPerson/{personId}", method = RequestMethod.POST)
  public FamilyPersonMap addPerson(@PathVariable Integer id, @PathVariable Integer personId){
	  FamilyPersonMap fpm = new FamilyPersonMap();
	  fpm.setId(null);
	  fpm.setFamily(familyRepo.findOne(id));
	  fpm.setPerson(personRepo.findOne(personId));
	  return familyPersonRepo.saveAndFlush(fpm);
  }
  
  @RequestMapping(value = "/{id}/getPeople", method = RequestMethod.GET)
  public List<Person> findPeopleByFamilyId(@PathVariable Integer id){
    return familyPersonRepo.findPeopleByFamilyId(id);
  }
  
}
