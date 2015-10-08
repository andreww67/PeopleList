package com.springmvc.model;

import javax.persistence.*;

@Table(
	    uniqueConstraints=
	        @UniqueConstraint(columnNames={"FAMILY_ID", "PERSON_ID"})
	)
@Entity
public class FamilyPersonMap {
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="ID", nullable=false, unique=true)
  private Integer id;
  
  @ManyToOne
  @JoinColumn(name="FAMILY_ID", nullable=false, referencedColumnName="ID")
  private Family family;

  @ManyToOne
  @JoinColumn(name="PERSON_ID", nullable=false, referencedColumnName="ID")
  private Person person;
  
  public Family getFamily() {
	return family;
  }

  public void setFamily(Family family) {
	this.family = family;
  }
  public Person getPerson() {
	return person;
  }

  public void setPerson(Person person) {
	 this.person = person;
  }
	
  public Integer getId() {
	  return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

}
