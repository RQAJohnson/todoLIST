package com.qa.persistance.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class SchoolDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;

}
