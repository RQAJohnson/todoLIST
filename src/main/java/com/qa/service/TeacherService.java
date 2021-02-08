package com.qa.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistance.domain.TeacherDomain;
import com.qa.persistance.dto.TeacherDTO;
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
	
	private TeacherDTO mapToDTO (TeacherDomain model) {
		return this.mapper.map(model, TeacherDTO.class);
	}
	
	
//	CREATE
	public TeacherDTO create(TeacherDomain cat) {
		return this.mapToDTO(this.repo.save(cat));
	}
	
	
//	READALL
	public List<TeacherDTO> readAll() {
	List<TeacherDomain> dbList = this.repo.findAll();
	List<TeacherDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return resultList;
	}
	
//	READ BY ID
	public TeacherDTO readOne(Long id ) {
		TeacherDomain result = this.repo.findById(id).orElseThrow();
			return this.mapToDTO(result);
		}

//	UPDATE
	public TeacherDTO update(Long id, TeacherDomain newDetails) {
		this.repo.findById(id).orElseThrow();
		newDetails.setId(id);
		return this.mapToDTO(this.repo.save(newDetails));
		
	}
	
//	DELETE
	public boolean delete(Long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
		
	}
	
	

}
