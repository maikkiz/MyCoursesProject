package com.example.MyCourses.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface GradeRepository extends CrudRepository<Grade, Long>{
	
	List<Grade> findByGrade(int grade);

}
