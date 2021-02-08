package com.qa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qa.persistance.domain.SchoolDomain;
import com.qa.persistance.dto.SchoolDTO;
import com.qa.persistance.repo.SchoolRepo;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

@Service
public class SchoolService {
	
	private SchoolRepo repo;
	private ModelMapper mapper;
	
	
	@Autowired
	public SchoolService(SchoolRepo repo, ModelMapper mapper) {
		super();
		this.repo = repo;
		this.mapper = mapper;
	}
	
	private SchoolDTO mapToDTO (SchoolDomain model) {
		return this.mapper.map(model, SchoolDTO.class);
	}
	
	
//	CREATE
	public SchoolDTO create(SchoolDomain school) {
		return this.mapToDTO(this.repo.save(school));
	}
	
	
//	READALL
	public List<SchoolDTO> readAll() {
	List<SchoolDomain> dbList = this.repo.findAll();
	List<SchoolDTO> resultList = dbList.stream().map(this::mapToDTO).collect(Collectors.toList());
		return resultList;
		//`dbList` can be renamed `houseList` for better readability and same within CatService
	}
	
//	READ BY ID
	public SchoolDTO readOne(Long id ) {
		SchoolDomain result = this.repo.findById(id).orElseThrow();
			return this.mapToDTO(result);
			// this.repo.findbyID can be passed into the `return` like create... see above
		}

//	UPDATE
	public SchoolDTO update(Long id, SchoolDomain newDetails) {
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
