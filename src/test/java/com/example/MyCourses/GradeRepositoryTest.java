package com.example.MyCourses;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.MyCourses.domain.Grade;
import com.example.MyCourses.domain.GradeRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class GradeRepositoryTest {

	@Autowired
	private GradeRepository repository;

	// tests that searching by grade returns grade
	@Test
	public void findByGradeShouldReturnGrade() {
		List<Grade> grades = repository.findByGrade(5);

		assertThat(grades).hasSize(1);
	}

	// tests that adding new grade is possible
	@Test
	public void createNewGrade() {
		Grade grade = new Grade(0);
		repository.save(grade);
		assertThat(grade.getGradeid()).isNotNull();
	}

}
