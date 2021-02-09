package com.qa.service;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.persistance.domain.SchoolDomain;
import com.qa.persistance.dto.SchoolDTO;

import com.qa.persistance.repo.SchoolRepo;


@SpringBootTest
public class SchoolServiceTEST {
	@MockBean
	private ModelMapper mockMapper;
	
	@MockBean
	private SchoolRepo mockRepo;

	@Autowired
	private SchoolService service;
	

	@Test //Create
	public void create() {
		SchoolDomain TEST_S = new SchoolDomain(1L, "25 London Road", null);
		SchoolDTO TEST_DTO = new SchoolDTO();
		
		Mockito.when(this.mockRepo.save(Mockito.any(SchoolDomain.class))).thenReturn(TEST_S); //RULES
		Mockito.when(this.mockMapper.map(TEST_S, SchoolDTO.class)).thenReturn(TEST_DTO); //RULES

		SchoolDTO result = this.service.create(TEST_S); //ACTIONS
		
		//ASSERTIONS. Either assertions work!
		Assertions.assertThat(result).isNotNull();
		
		Assertions.assertThat(result).isEqualTo(TEST_DTO); 
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(TEST_DTO);
		// this.mockMapper.map(TEST_S, SchoolDTO.class) 
		
		Mockito.verify(this.mockRepo, Mockito.times(1)).save(Mockito.any(SchoolDomain.class));
		Mockito.verify(this.mockMapper, Mockito.times(1)).map(TEST_S, SchoolDTO.class);

		
	}
		
	@Test //ReadALL
	public void readAll() {
		
	
	}
		
	@Test //ReadOne
	public void readOne() {
		SchoolDomain TEST_S = new SchoolDomain(1L, "25 London Road", null);
		SchoolDTO TEST_DTO = this.mockMapper.map(TEST_S, SchoolDTO.class);
		
		Mockito.when(this.mockRepo.findById(TEST_S.getId())).thenReturn(Optional.of(TEST_S)); //RULES
		
		SchoolDTO result = this.service.readOne(1L); //ACTIONS
		
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
