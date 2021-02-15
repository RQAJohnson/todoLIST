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
	
	//Create a mocked list for the readAll
	

	@Test //Create
	public void create() {
		TeacherDomain TEST_T = new TeacherDomain(1L, "Kate", "Maths", null);
		TeacherDTO TEST_DTO = new TeacherDTO(1L, "Kate", "Maths");
		
		Mockito.when(this.mockRepo.save(Mockito.any(TeacherDomain.class))).thenReturn(TEST_T); //RULES
		Mockito.when(this.mockMapper.map(TEST_T, TeacherDTO.class)).thenReturn(TEST_DTO); //RULES

		TeacherDTO result = this.service.create(TEST_T); //ACTIONS
	
		//ASSERTIONS. Either assertions work!
		Assertions.assertThat(result).isNotNull();
		
		Assertions.assertThat(result).isEqualTo(TEST_DTO); 
		Assertions.assertThat(result).usingRecursiveComparison().isEqualTo(TEST_DTO);
		// this.mockMapper.map(TEST_T, TeacherDTO.class) 
		
		Mockito.verify(this.mockRepo, Mockito.times(1)).save(Mockito.any(TeacherDomain.class));
		Mockito.verify(this.mockMapper, Mockito.times(1)).map(TEST_T, TeacherDTO.class);

		
	}
		
	@Test //ReadALL
	public void readAll() {
//		TeacherDomain TEST_T = new TeacherDomain(1L, "Kate", "Maths", null);
//		TeacherDTO TEST_DTO = this.mockMapper.map(TEST_T, TeacherDTO.class);
//		Mockito.when(this.mockRepo.findAll().thenReturn(Optional.of(TEST_T));
		
		
	
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
		TeacherDomain TEST_T = new TeacherDomain(1L, "Kate", "Maths", null);
		
		this.mockRepo.deleteById(1L);
		Mockito.when(this.mockRepo.existsById(1L)).thenReturn(false);	
		
//		boolean result = this.service.delete(1L);
		
//		Assertions.assertThat(result).isEqualTo(true);

		Mockito.verify(this.mockRepo, Mockito.times(1)).deleteById(1L);
		
//		TeacherDTO TEST_DTO = this.mockMapper.map(TEST_T, TeacherDTO.class); //WILL return null
//		Mockito.verify(this.mockRepo, Mockito.times(1)).existsById(1L);

		// CAN'T RETURN ANYTHING --- DELETE BY ID
		
		
		
//		this.mockRepo.deleteById(1L);
//	    Mockito.verify(this.mockRepo, Mockito.times(1))
//	            .deleteById(1L);
		
		
		
	}
	
	
//	TEST_T.getId())).thenReturn(Optional.of(TEST_T)
	
	public void mockitoRules() {
		
		//RESOURCES
		
		
		//RULES

		
		//ACTIONS
		
		
		//ASSERTIONS
	}
	
	
	}
	



