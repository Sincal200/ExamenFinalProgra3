package com.example.daos;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Student;

public interface StudentDao extends CrudRepository<Student,Long>{

}
