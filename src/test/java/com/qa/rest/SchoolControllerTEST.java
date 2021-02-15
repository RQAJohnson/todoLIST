package com.qa.rest;

import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.persistance.domain.SchoolDomain;
import com.qa.persistance.dto.SchoolDTO;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema-test.sql","classpath:data-test.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles="test")
public class SchoolControllerTEST {
	
	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier; 
	
	private final int ID = 1;
	
	private SchoolDTO mapToDTO(SchoolDomain model) {
		return this.mapper.map(model, SchoolDTO.class);
	}
	
	@Test
	public void create() throws Exception {
		
		SchoolDomain contentBody = new SchoolDomain(1L, "25 Langley Lane", null);
		SchoolDTO expectedResult = mapToDTO(contentBody);
		 
		//set up request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.POST, "/school/create/")
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonifier.writeValueAsString(contentBody))
				.accept(MediaType.APPLICATION_JSON);
		
		//isOk. If integer .204 OR HttpStatus.ACCEPTED **set up expected status**
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isCreated();  		
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));
		
		//PERFORM
		this.mock.perform(mockRequest).andExpect(matchStatus);
		this.mock.perform(mockRequest).andExpect(matchContent);
		
		}
	
	
//	READ
	@Test
	public void readAll() throws Exception {
		// List<TeacherDomain> teacherList
//		TeacherDomain contentBody = new TeacherDomain(3L,"Barry","Science", null);
//		TeacherDTO expectedResult = mapToDTO(contentBody);
//		
//		//set up request
//		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
//				.request(HttpMethod.GET, "/teacher/readAll/")
//				.contentType(MediaType.APPLICATION_JSON)
//				.content(jsonifier.writeValueAsString(contentBody))
//				.accept(MediaType.APPLICATION_JSON);
//		
//		//isOk. If integer .204 OR HttpStatus.ACCEPTED **set up expected status**
//		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();  		
//		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));
//		
//		//PERFORM
//		this.mock.perform(mockRequest).andExpect(matchStatus);
//		this.mock.perform(mockRequest).andExpect(matchContent);

	}
	
//	READ BY ID
	@Test
	public void readSchool() throws Exception {
		SchoolDTO expectedResult = new SchoolDTO(1L, "25 Langley Lane", null);
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.GET, "/school/read/" + ID); //set up request
		
		//isOk. If integer .204 OR HttpStatus.ACCEPTED **set up expected status**
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();  		
		
		//PERFORM
		this.mock.perform(mockRequest).andExpect(matchStatus);
		
	}
	
	
//	UPDATE	
	@Test
	public void update() throws Exception{
		
	}
	
//	DELETE
	@Test
	public void delete() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.DELETE, "/school/delete/" + ID);
		
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();
		
		
		this.mock.perform(mockRequest).andExpect(matchStatus);
		
			
	}
	
		
	}

