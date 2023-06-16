package com.example.daos;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Course;

public interface CourseDao extends CrudRepository<Course,Long>{

}
