package com.example.MyCourses;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.MyCourses.domain.Course;
import com.example.MyCourses.domain.CourseRepository;
import com.example.MyCourses.domain.Grade;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CourseRepositoryTest {

	@Autowired
	private CourseRepository repository;

	// tests that searching by course name returns right course
	@Test
	public void findByNameShouldReturnCourse() {
		List<Course> courses = repository.findByName("Orientaatio ohjelmistotuotantoon");

		assertThat(courses).hasSize(1);
		assertThat(courses.get(0).getCredit()).isEqualTo(5);
	}

	// tests that adding new course is possible
	@Test
	public void createNewCourse() {
		Course course = new Course("Testi Kurssi", 5, "Testi alku pvm", "Testi loppu pvm", new Grade(5));
		repository.save(course);
		assertThat(course.getId()).isNotNull();
	}

}
