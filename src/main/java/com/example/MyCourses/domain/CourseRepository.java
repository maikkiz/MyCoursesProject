package com.example.MyCourses.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends CrudRepository<Course, Long> {

	List<Course> findByName(@Param("name") String name);
	
	@Query("SELECT AVG(c.grade) from Course c")
    int getAverageGrade();
	
}
