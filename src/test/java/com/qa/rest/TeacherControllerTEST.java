package com.qa.rest;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.persistance.domain.TeacherDomain;
import com.qa.persistance.dto.TeacherDTO;
import com.qa.service.TeacherService;



@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Sql(scripts = {"classpath:schema-test.sql","classpath:data-test.sql"}, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles(profiles="test")
public class TeacherControllerTEST {
	
	private static final TeacherService TeacherService = null;

	@Autowired
	private MockMvc mock;
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private ObjectMapper jsonifier;
	
	private final int ID = 1;
	
	private TeacherDTO mapToDTO(TeacherDomain model) {
		return this.mapper.map(model, TeacherDTO.class);
	}
	

//	POST or CREATE
	@Test
	public void create() throws Exception {
		
		TeacherDomain contentBody = new TeacherDomain(3L,"Barry","Science", null);
		TeacherDTO expectedResult = mapToDTO(contentBody);
		 
		//set up request
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.POST, "/teacher/create/")
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
		
//		List<TeacherDTO> teachers = new ArrayList<>();
//		MockHttpServletRequestBuilder mockRequestT = MockMvcRequestBuilders
//				.request(HttpMethod.GET, "/teacher/readAll/"); //set up request
//		//isOk. If integer .204 OR HttpStatus.ACCEPTED **set up expected status**
//		ResultMatcher matchStatusT = MockMvcResultMatchers.status().isOk();  		
//		ResultMatcher matchContentT = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(teachers));
//		//PERFORM
//		this.mock.perform(mockRequestT).andExpect(matchStatusT);
//		this.mock.perform(mockRequestT).andExpect(matchContentT);	
	}
	
		
//	TeacherDomain contentBody = new TeacherDomain(3L,"Barry","Science", null);
//	TeacherDTO expectedResult = mapToDTO(contentBody);
//	
//	MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
//			.request(HttpMethod.GET, "/teacher/readAll/") //set up request
//			.contentType(MediaType.APPLICATION_JSON)
//			.content(jsonifier.writeValueAsString(contentBody))
//			.accept(MediaType.APPLICATION_JSON);
//	
//	//isOk. If integer .204 OR HttpStatus.ACCEPTED **set up expected status**
//	ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();  		
//	ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(contentBody));
//	
//	//PERFORM
//	this.mock.perform(mockRequest).andExpect(matchStatus);
//	this.mock.perform(mockRequest).andExpect(matchContent);
//		TeacherController teacherContoller = new TeacherController(TeacherService);
//		List<TeacherDTO> teachers = new ArrayList<>();
//		teachers.add(new TeacherDTO(3L,"Chris", "P.E"));
		
//		Mockito.when(contentBody.readAll()).thenReturn(teachers);
//		assertEquals(teachers, TeacherController.readAll());
//		
//		customers.add(new Customer("Rhys", "T"));
//		customers.add(new Customer("Nic", "J"));


	
//	READ BY ID
	@Test
	public void readTeacher() throws Exception {
		TeacherDTO expectedResult = new TeacherDTO(1L, "sarah", "maths");
		
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.GET, "/teacher/read/" + ID); //set up request
		
		//isOk. If integer .204 OR HttpStatus.ACCEPTED **set up expected status**
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isOk();  		
		ResultMatcher matchContent = MockMvcResultMatchers.content().json(jsonifier.writeValueAsString(expectedResult));
		
		//PERFORM
		this.mock.perform(mockRequest).andExpect(matchStatus);
		this.mock.perform(mockRequest).andExpect(matchContent);
		
	}
	
	
//	UPDATE	
	@Test
	public void update() throws Exception{
		
	}
	
//	DELETE
	@Test
	public void delete() throws Exception {
		MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders
				.request(HttpMethod.DELETE, "/teacher/delete/" + ID);
		ResultMatcher matchStatus = MockMvcResultMatchers.status().isNoContent();
		this.mock.perform(mockRequest).andExpect(matchStatus);
			
	}
	//MAYBE THIS!
//	Long id = 1L;
//	Mockito.doReturn(id).when(TeacherService).delete(id);
//	TeacherService.delete(id);
//	Mockito.verify(TeacherService, Mockito.times(1)).delete(1L);
	

}
