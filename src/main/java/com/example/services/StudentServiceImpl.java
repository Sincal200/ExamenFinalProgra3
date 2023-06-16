package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.daos.StudentDao;

import com.example.entities.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;
	

	@Override
	public List<Student> findAll() {
		return (List<Student>)studentDao.findAll();
	}

	@Override
	public Student findById(Long id) {
		return studentDao.findById(id).orElse(null);
	}

	@Override
	public Student create(Student student) {
		return studentDao.save(student);
	}

	@Override
	public Student modify(Long id, Student updatedStudent) {
	    Student existingStudent = studentDao.findById(id).orElse(null);
	    if (existingStudent == null) {
	        // Manejar el caso de estudiante no encontrado
	        return null;
	    }

	    // Actualizar solo las propiedades específicas que deseas modificar
	    existingStudent.setName(updatedStudent.getName());
	    // 

	    // No realizar cambios en la lista de cursos asignados

	    return studentDao.save(existingStudent);
	}

	@Override
	public void delete(Long id) {
		if(studentDao.existsById(id)) {
			studentDao.deleteById(id);
		}
		
	}


}
