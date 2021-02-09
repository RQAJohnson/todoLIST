package com.qa.service;

import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.persistance.repo.TeacherRepo;

@SpringBootTest
public class TeacherServiceTEST {
	
	@MockBean
	private ModelMapper mockMapper;
	
	@MockBean
	private TeacherRepo mockRepo;

}
