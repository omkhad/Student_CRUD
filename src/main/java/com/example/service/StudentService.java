package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@Service
public class StudentService {
   @Autowired
   private StudentRepository studentRepository;
   public void save(Student student) {
   	studentRepository.save(student);
   }
   public List<Student> getAll(){
   	return studentRepository.findAll();
   }
   public Student getStudentById(Long id) {
		return studentRepository.findById(id).get();
	}
	
	public void deleteStudentById(Long id) {
		 studentRepository.deleteById(id);
	}
}