package com.springmvc.model;

import javax.persistence.*;

@Entity
public class Family {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ID", nullable=false, unique=true)
  private Integer id;
  
  @Column(name="NAME", nullable=false, unique=false)
  private String name;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
