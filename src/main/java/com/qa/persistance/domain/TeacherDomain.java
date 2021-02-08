package com.qa.persistance.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class TeacherDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	@NotNull
	private String name;
	
	@NotNull
	private String subject;
	
	@ManyToOne
	private SchoolDomain mySchool;

	public TeacherDomain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TeacherDomain(Long id, @NotNull String name, @NotNull String subject, SchoolDomain mySchool) {
		super();
		this.id = id;
		this.name = name;
		this.subject = subject;
		this.mySchool = mySchool;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public SchoolDomain getMySchool() {
		return mySchool;
	}

	public void setMySchool(SchoolDomain mySchool) {
		this.mySchool = mySchool;
	}
	
	
	

}
