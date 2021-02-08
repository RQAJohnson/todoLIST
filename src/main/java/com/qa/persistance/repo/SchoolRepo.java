package com.qa.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.persistance.domain.SchoolDomain;

public interface SchoolRepo extends JpaRepository<SchoolDomain, Long> {

}
