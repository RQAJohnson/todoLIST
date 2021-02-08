package com.qa.persistance.dto;

import java.util.List;

public class SchoolDTO {
	
	private Long id;
	private String address;
	private List<TeacherDTO> TeacherList;
	
	
	public SchoolDTO() {
		super();
		// TODO Auto-generated constructor stub
	}


	public SchoolDTO(Long id, String address, List<TeacherDTO> teacherList) {
		super();
		this.id = id;
		this.address = address;
		TeacherList = teacherList;
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


	public List<TeacherDTO> getTeacherList() {
		return TeacherList;
	}


	public void setTeacherList(List<TeacherDTO> teacherList) {
		TeacherList = teacherList;
	}
	
	
	

}
