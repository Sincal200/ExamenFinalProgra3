package com.example.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entities.Course;
import com.example.services.CourseService;


@RestController
@RequestMapping("/courses")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping
    public List<Course> findAll(){
		return courseService.findAll();
    }
	
	@GetMapping( value = "/{id}")
    public Course findById( @PathVariable Long id){
		return courseService.findById(id);
    }

	@PostMapping()
    public Course createTask( @RequestBody Course course){
		return courseService.create(course);
    }

	@PutMapping(value = "/{id}")
    public Course modifyTask( @PathVariable Long id, @RequestBody Course course){
		return courseService.modify(id,course);
    }

	@DeleteMapping(value = "/{id}")
	public void modificarProducto(@PathVariable Long id) {
		courseService.delete(id);
	}

}
