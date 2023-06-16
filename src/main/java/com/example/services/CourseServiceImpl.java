package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.CourseDao;
import com.example.entities.Course;

@Service
public class CourseServiceImpl implements CourseService{
	
	@Autowired
	private CourseDao courseDao;

	@Override
	public List<Course> findAll() {
		return (List<Course>)courseDao.findAll();
	}

	@Override
	public Course findById(Long id) {
		return courseDao.findById(id).orElse(null);
	}

	@Override
	public Course create(Course course) {
		return courseDao.save(course);
	}

	@Override
	public Course modify(Long id, Course course) {
		if(courseDao.existsById(id)){
			course.setId(id);
			courseDao.save(course);
		} 
		return null;
	}

	@Override
	public void delete(Long id) {
		if(courseDao.existsById(id)) {
			courseDao.deleteById(id);
		}
		
	}

}
