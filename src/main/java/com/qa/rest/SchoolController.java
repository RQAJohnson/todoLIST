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

import com.qa.persistance.domain.SchoolDomain;
import com.qa.persistance.dto.SchoolDTO;
import com.qa.service.SchoolService;

@RestController
@RequestMapping("/school")
public class SchoolController {
	
	private SchoolService service;

	public SchoolController(SchoolService service) {
		super();
		this.service = service;
	}
	
	
//	POST or CREATE
	@PostMapping("/create")
	public ResponseEntity<SchoolDTO> create(@RequestBody SchoolDomain school) {
		return new ResponseEntity<SchoolDTO>(this.service.create(school), HttpStatus.CREATED);
		}
	
	
//	READ
	@GetMapping("/readAll")
	public ResponseEntity<List<SchoolDTO>> readAll() {
		return ResponseEntity.ok(this.service.readAll());
	}
	
//	READ BY ID
	@GetMapping("/read/{id}")
	public ResponseEntity<SchoolDTO> readOne(@PathVariable("id") Long id) {
		return ResponseEntity.ok(this.service.readOne(id));
	}
	
//	UPDATE	
	@PutMapping("update/{id}")
	public ResponseEntity<SchoolDTO> update(@PathVariable("id") Long id, @RequestBody SchoolDomain school){
		return new ResponseEntity<SchoolDTO>(this.service.update(id, school), HttpStatus.ACCEPTED);
	}
	
//	DELETE
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> delete(@PathVariable("id") Long id) {
	return this.service.delete(id) ?
			new ResponseEntity<>(HttpStatus.NO_CONTENT) :
				new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
	}
	

}
