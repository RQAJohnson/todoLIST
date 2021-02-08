package com.qa.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SchoolRepo extends JpaRepository<SchoolDomain, Long> {

}
