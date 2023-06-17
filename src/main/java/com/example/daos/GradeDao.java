package com.example.daos;

import org.springframework.data.repository.CrudRepository;

import com.example.entities.Grade;

public interface GradeDao extends CrudRepository<Grade,Long>{

}
