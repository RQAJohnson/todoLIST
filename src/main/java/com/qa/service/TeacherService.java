package com.qa.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistance.repo.TeacherRepo;

@Service
public class TeacherService {
	
	private TeacherRepo repo;
	private ModelMapper mapper;
	
	@Autowired
	public TeacherService(TeacherRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	

}
