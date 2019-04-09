package com.example.MyCourses.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Course {
	// creating automated id
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long id;
	private String name;
	private int credit;
	private String startDate;
	private String endDate;

	// creating many to one relationship to grade class
	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "gradeid")
	private Grade grade;

	public Course() {
	}

	public Course(String name, int credit, String startDate, String endDate, Grade grade) {
		super();
		this.name = name;
		this.credit = credit;
		this.startDate = startDate;
		this.endDate = endDate;
		this.grade = grade;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		if (this.grade != null)
			return "Course [id=" + id + ", name=" + name + ", credit=" + credit + ", startDate=" + startDate
					+ ", endDate=" + endDate + ", grade=" + this.getGrade() + "]";
		else
			return "Course [id=" + id + ", name=" + name + ", credit=" + credit + ", startDate=" + startDate
					+ ", endDate=" + endDate + "]";
	}

}
