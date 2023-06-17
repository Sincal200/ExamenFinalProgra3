package com.example.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.daos.CourseDao;
import com.example.daos.GradeDao;
import com.example.daos.StudentDao;
import com.example.entities.Course;
import com.example.entities.Grade;
import com.example.entities.GradeRequest;
import com.example.entities.Student;

@RestController
@RequestMapping("/grades")
public class GradeController {
	
	private final StudentDao studentDao;
    private final CourseDao courseDao;
    private final GradeDao gradeDao;
    
    public GradeController(StudentDao studentDao, CourseDao courseDao, GradeDao gradeDao) {
        this.studentDao = studentDao;
        this.courseDao = courseDao;
		this.gradeDao =  gradeDao;
    }

	 @PostMapping("/")
	    public ResponseEntity<?> assignGrade(@RequestBody GradeRequest gradeRequest) {
	        Student student = studentDao.findById(gradeRequest.getStudentId()).orElse(null);
	        Course course = courseDao.findById(gradeRequest.getCourseId()).orElse(null);

	        if (student == null || course == null) {
	            return ResponseEntity.notFound().build();
	        }

	        Grade grade = new Grade();
	        grade.setGrade(gradeRequest.getGrade());
	        grade.setStudent(student);
	        grade.setCourse(course);

	        student.addGrade(grade);

	        studentDao.save(student);

	        GradeRequest gradeResponse = new GradeRequest();
	        gradeResponse.setGrade(grade.getGrade());
	        gradeResponse.setCourseId(grade.getCourseId());

	        return ResponseEntity.ok(gradeResponse);
	    }
}
