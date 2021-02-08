package com.qa.persistance.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class SchoolDomain {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Long id;
	
	private String address;
	
	@OneToMany(mappedBy = "mySchool", fetch = FetchType.EAGER)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private List<TeacherDomain> teacherList;
	
	
	public SchoolDomain() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SchoolDomain(Long id, String address, List<TeacherDomain> teacherList) {
		super();
		this.id = id;
		this.address = address;
		this.teacherList = teacherList;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public List<TeacherDomain> getTeacherList() {
		return teacherList;
	}


	public void setTeacherList(List<TeacherDomain> teacherList) {
		this.teacherList = teacherList;
	}

}
