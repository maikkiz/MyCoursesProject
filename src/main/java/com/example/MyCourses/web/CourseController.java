package com.example.MyCourses.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.MyCourses.domain.Course;
import com.example.MyCourses.domain.CourseRepository;
import com.example.MyCourses.domain.GradeRepository;

@Controller
public class CourseController {

	@Autowired
	private CourseRepository crepository;

	@Autowired
	private GradeRepository grepository;

	// Shows login page
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	// shows all my courses
	@RequestMapping(value = "/courselist")
	public String courseList(Model model) {
		model.addAttribute("courses", crepository.findAll());
		model.addAttribute("avggrade", crepository.getAverageGrade());
		model.addAttribute("totalcredit", crepository.getTotalCredit());
		return "courselist";
	}

	// adds new course to the course list
	@RequestMapping(value = "/addcourse")
	public String addCourse(Model model) {
		model.addAttribute("course", new Course());
		model.addAttribute("grades", grepository.findAll());
		return "addcourse";
	}

	// edits the chosen course
	@RequestMapping(value = "/edit/{id}")
	public String editCourse(@PathVariable("id") Long courseId, Model model) {
		model.addAttribute("course", crepository.findById(courseId));
		model.addAttribute("grades", grepository.findAll());
		return "editcourse";
	}

	// saves new and edited courses to the course list
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(Course course) {
		crepository.save(course);
		return "redirect:courselist";
	}

	// deletes chosen course from the course list
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteCourse(@PathVariable("id") Long courseId, Model model) {
		crepository.deleteById(courseId);
		return "redirect:../courselist";
	}

	// RESTful service that shows all courses
	@RequestMapping(value = "/courses", method = RequestMethod.GET)
	public @ResponseBody List<Course> courseListRest() {
		return (List<Course>) crepository.findAll();
	}

	// RESTful service that shows course by id
	@RequestMapping(value = "/course/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Course> findCourseRest(@PathVariable("id") Long courseId) {
		return crepository.findById(courseId);
	}

}
