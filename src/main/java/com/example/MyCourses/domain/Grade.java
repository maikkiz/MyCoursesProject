package com.example.MyCourses.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Grade {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long gradeid;
	private int grade;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "grade")
	private List<Course> courses;
	
	public Grade() {}

	public Grade(int grade) {
		super();
		this.grade = grade;
	}

	public long getGradeid() {
		return gradeid;
	}

	public void setGradeid(long gradeid) {
		this.gradeid = gradeid;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "Grade [gradeid=" + gradeid + ", grade=" + grade + "]";
	}

}
