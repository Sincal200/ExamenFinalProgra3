package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.daos.GradeDao;
import com.example.entities.Grade;

@Service
public class GradeServiceImpl implements GradeService{
	
	@Autowired
	private GradeDao gradeDao;

	@Override
	public List<Grade> findAll() {
		return (List<Grade>)gradeDao.findAll();
	}

	@Override
	public Grade findById(Long id) {
		return gradeDao.findById(id).orElse(null);
	}

	@Override
	public Grade create(Grade grade) {
		return gradeDao.save(grade);
	}

	@Override
	public Grade modify(Long id, Grade grade) {
		if(gradeDao.existsById(id)){
			grade.setId(id);
			gradeDao.save(grade);
		} 
		return null;
	}

	@Override
	public void delete(Long id) {
		if(gradeDao.existsById(id)) {
			gradeDao.deleteById(id);
		}
		
	}
	

}
