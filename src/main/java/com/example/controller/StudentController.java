package com.example.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Student;
import com.example.repository.StudentRepository;

@RestController
public class StudentController {
     @Autowired
     private StudentRepository studentRepository;
     @PostMapping("/saveStudent")
     public Student saveData(@RequestBody Student student) {
    	 studentRepository.save(student);
    	 return student;
     }
 	
 	
 	@GetMapping("/getAllStudents")
 	public List<Student> getAll(){
 		List<Student> studentList=studentRepository.findAll();
 		return studentList;
 	}
 	
 	
 	@DeleteMapping("/deleteStudent/{id}")
 	public String deleteStudentById(@PathVariable Long id) {
 		Student student=studentRepository.findById(id).get();
 		if(student!=null) {
 			studentRepository.delete(student);
 		}
 		return "Student deleted successfully";
 	}
 	@PutMapping("/updateData")
 	public Student updateStudentData(@RequestBody Student student){
 		studentRepository.save(student);
   	    return student;
 	}
 	
 	@GetMapping("/getStudent/{id}")
 	public Student getStudent(@PathVariable Long id) {
 		Student student=studentRepository.findById(id).get();
 		return student;
 	}
}