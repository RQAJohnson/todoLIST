package com.qa.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<TeacherDomain, Long> {

}
