package com.qa.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.persistance.domain.TeacherDomain;
import com.qa.persistance.dto.TeacherDTO;
import com.qa.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {
	
	private TeacherService service;

	public TeacherController(TeacherService service) {
		super();
		this.service = service;
	}
	
	
//	POST or CREATE
	@PostMapping("/create")
	public ResponseEntity<TeacherDTO> create(@RequestBody TeacherDomain teacher) {
		return new ResponseEntity<TeacherDTO>(this.service.create(teacher), HttpStatus.CREATED);
		}
	
	
//	READ
	@GetMapping("/readAll")
	public ResponseEntity<List<TeacherDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}
	
//	READ BY ID
	@GetMapping("/read/{id}")
	public ResponseEntity<TeacherDTO> readTeacher(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readOne(id));
	}
	
//	UPDATE	
	@PutMapping("update/{id}")
	public ResponseEntity<TeacherDTO> update(@PathVariable("id") Long id, @RequestBody TeacherDomain teacher){
		return new ResponseEntity<TeacherDTO>(this.service.update(id, teacher), HttpStatus.ACCEPTED);
	}
	
//	DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
	return this.service.delete(id) ?
			new ResponseEntity<>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
	}

}
