package com.example.services;

import java.util.List;

import com.example.entities.Student;


public interface StudentService {
	
	public List<Student> findAll();
	public Student findById(Long id);
	public Student create(Student student);
	public Student modify(Long id, Student student);
    public void delete(Long id);
    

}
