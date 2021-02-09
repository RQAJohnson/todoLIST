package com.qa.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.persistance.domain.TeacherDomain;
import com.qa.persistance.dto.TeacherDTO;
import com.qa.persistance.repo.TeacherRepo;

@SpringBootTest
public class TeacherServiceTEST {
		
	@MockBean
	private ModelMapper mockMapper;
	
	@MockBean
	private TeacherRepo mockRepo;

	@Autowired
	private TeacherService service;
	

	@Test //Create
	public void create() {
		TeacherDomain TEST_T = new TeacherDomain(1L, "Kate", "Maths", null);
		Mockito.when(this.mockRepo.save(Mockito.any(TeacherDomain.class))).thenReturn(TEST_T); //RULES
		
		TeacherDTO result = this.service.create(TEST_T); //ACTIONS
		
		Assertions.assertThat(result).isEqualTo
		(this.mockMapper.map(TEST_T, TeacherDTO.class)); //ASSERTIONS. Either assertions work!
		
		Assertions.assertThat(result).usingRecursiveComparison()
		.isEqualTo(this.mockMapper.map(TEST_T, TeacherDTO.class));
		
		Mockito.verify(this.mockRepo, Mockito.times(1)).save(Mockito.any(TeacherDomain.class));
		
	}
		
	@Test //ReadALL
	public void readAll() {
		
	
	}
		
	@Test //ReadOne
	public void readOne() {
		TeacherDomain TEST_T = new TeacherDomain(1L, "Kate", "Maths", null);
		TeacherDTO TEST_DTO = this.mockMapper.map(TEST_T, TeacherDTO.class);
		
		Mockito.when(this.mockRepo.findById(TEST_T.getId())).thenReturn(Optional.of(TEST_T)); //RULES
		
		TeacherDTO result = this.service.readOne(1L); //ACTIONS
		
		Assertions.assertThat(result).isEqualTo(TEST_DTO); //ASSERTIONS. Either assertions work!
		
		Mockito.verify(this.mockRepo, Mockito.times(1)).findById(1L);
		
 
		
	}
		
	@Test //Update
	public void update() {
			
	}
	
	
	@Test //Delete
	public void delete() {	
	}
	
	
	}
	


