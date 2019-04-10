package com.example.MyCourses.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CourseRepository extends CrudRepository<Course, Long> {

	// finds courses by name
	List<Course> findByName(@Param("name") String name);

	// counts the average grade of all courses
	@Query("SELECT AVG(c.grade) from Course c")
	double getAverageGrade();
	
	// counts the sum on all credits
	@Query("SELECT SUM(c.credit) from Course c")
	int getTotalCredit();

}
