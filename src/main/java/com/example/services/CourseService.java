package com.example.services;

import java.util.List;

import com.example.entities.Course;



public interface CourseService {
	
	public List<Course> findAll();
	public Course findById(Long id);
	public Course create(Course course);
	public Course modify(Long id, Course course);
    public void delete(Long id);
}
