package com.example.MyCourses;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.MyCourses.web.CourseController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyCoursesApplicationTests {

	@Autowired
	private CourseController controller;

	// tests that controller is created
	@Test
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}

}
