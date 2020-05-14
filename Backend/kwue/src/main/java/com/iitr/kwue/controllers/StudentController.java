package com.iitr.kwue.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iitr.kwue.entities.Student;
import com.iitr.kwue.service.impl.StudentServiceImpl;

@RestController
@RequestMapping("/api")
public class StudentController {
	
	@Autowired
	private StudentServiceImpl studentServiceImpl;
	
	@PutMapping("/addstudent")
	public void addStudent(@RequestBody Student s) {
		studentServiceImpl.putStudent(s);
	}
	
	@GetMapping("/all")
	public Iterable<Student> getAllStudents(){
		return studentServiceImpl.getAll();
	}
	
	@DeleteMapping("/delete/{id}")
	private void deleting(@PathVariable int id) {
		studentServiceImpl.deleteStudent(id);
	}
	
	@GetMapping("/getByname")
	private ResponseEntity<Student> getByname(String name) {
		return new ResponseEntity<>(studentServiceImpl.getbyname(name),HttpStatus.OK);
	}

    @PostMapping("/update")
	public void updateStudent(@RequestBody Student s) {
		studentServiceImpl.postStudent(s);
	}
}
