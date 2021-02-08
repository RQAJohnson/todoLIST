package com.qa.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TeacherDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;

}
