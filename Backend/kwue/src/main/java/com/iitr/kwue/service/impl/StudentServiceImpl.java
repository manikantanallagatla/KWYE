package com.iitr.kwue.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iitr.kwue.entities.Student;
import com.iitr.kwue.repository.StudentRepository;
import com.iitr.kwue.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public Iterable<Student> getAll(){
		return studentRepository.findAll();
	}
	
	public void putStudent(Student s) {
		studentRepository.save(s);
	}	
	
    public Student getbyname(String name) {
    	return studentRepository.fetchStudentByName(name);
    }
	
	
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}

	public void postStudent(Student s) {
		// TODO Auto-generated method stub
		studentRepository.updateStudentInfoById(s.age, s.mailid, s.name, s.id);
	}
}
