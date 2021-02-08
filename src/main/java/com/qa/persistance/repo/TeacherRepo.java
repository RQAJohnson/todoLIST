package com.qa.persistance.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.qa.persistance.domain.TeacherDomain;

public interface TeacherRepo extends JpaRepository<TeacherDomain, Long> {

}
