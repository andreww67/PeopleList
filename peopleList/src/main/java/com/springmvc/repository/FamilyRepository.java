package com.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springmvc.model.Family;

public interface FamilyRepository extends JpaRepository<Family, Integer> {

}
