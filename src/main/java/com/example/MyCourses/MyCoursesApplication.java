package com.example.MyCourses;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.MyCourses.domain.Course;
import com.example.MyCourses.domain.CourseRepository;
import com.example.MyCourses.domain.Grade;
import com.example.MyCourses.domain.GradeRepository;
import com.example.MyCourses.domain.User;
import com.example.MyCourses.domain.UserRepository;

@SpringBootApplication
public class MyCoursesApplication {


	public static void main(String[] args) {
		SpringApplication.run(MyCoursesApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(CourseRepository crepository, GradeRepository grepository, UserRepository urepository) {
		return(args)-> {
			 //Create grades and save them in grade repository
			Grade grade = new Grade(1);
			grepository.save(grade);
			
			grade = new Grade(2);
			grepository.save(grade);
			
			grade = new Grade(3);
			grepository.save(grade);
			
			grade = new Grade(4);
			grepository.save(grade);
			
			grade = new Grade(5);
			grepository.save(grade);
			
			//Create courses and save them in course repository
			Course course = new Course("Orientaatio ohjelmistotuotantoon", 5, "15.1.2018", "20.5.2018", grepository.findByGrade(5).get(0));
			crepository.save(course);
			
			course = new Course("Orientaatio digitaalisiin palveluihin", 5, "15.1.2018", "20.5.2018", grepository.findByGrade(5).get(0));
			crepository.save(course);
			
			course = new Course("Orientaatio ICT-infrastruktuuriin", 5, "15.1.2018", "20.5.2018", grepository.findByGrade(5).get(0));
			crepository.save(course);
			
			course = new Course("Orientaatio ICT ja liiketoiminta", 5, "15.1.2018", "20.5.2018", grepository.findByGrade(5).get(0));
			crepository.save(course);
			
			course = new Course("Viestinnän perusteet kotimaisilla kielillä", 5, "15.1.2018", "20.5.2018", grepository.findByGrade(4).get(0));
			crepository.save(course);
			
			course = new Course("ICT and Business English", 5, "15.1.2018", "20.5.2018", grepository.findByGrade(4).get(0));
			crepository.save(course);
			
			// Create users: admin/admin user/user
			User user = new User("user", "$2a$10$fdyVvPFWxvJWlF/TRqU9lOvySDdNU85WC12FioV8HflzorgHhxsiO", "user@email.com", "USER");
			urepository.save(user);
						
			user = new User("admin", "$2a$10$vLQUan20K.TUkb275AAa1erTGwngYIOFnwyv0OaD1EYSSG1KtO.Qa", "admin@email.com", "ADMIN");
			urepository.save(user);
		};
	
	}
}
