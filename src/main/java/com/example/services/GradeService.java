package com.example.services;

import java.util.List;

import com.example.entities.Grade;


public interface GradeService {
	
	public List<Grade> findAll();
	public Grade findById(Long id);
	public Grade create(Grade grade);
	public Grade modify(Long id, Grade grade);
    public void delete(Long id);
}
