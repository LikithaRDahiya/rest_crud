package org.jsp.rest_crud.controller;

import java.util.List;

import org.apache.catalina.connector.Response;
import org.jsp.rest_crud.dto.ResponseStructure;
import org.jsp.rest_crud.dto.Student;
import org.jsp.rest_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;

@RestController
// restcontroller : it is a combination of response body and controller
public class StudentController {
	@Autowired
	StudentService service;

	@Operation(summary = "Saving one record")
	@PostMapping("/students")
	public ResponseEntity<ResponseStructure> saveRequest(@RequestBody Student student) {
		return new ResponseEntity<ResponseStructure>(service.saveStudent(student), HttpStatus.FOUND); 
	}

	@DeleteMapping("/students/delete/{id}")
	public ResponseEntity<ResponseStructure> deleteRequest(@PathVariable int id) {
		return new ResponseEntity<ResponseStructure>(service.deleteStudent(id),HttpStatus.FOUND);
	}

	@Operation(summary = "Fetching student by id")
	@GetMapping("/students/{id}")
	public ResponseEntity<ResponseStructure> fetchRequest(@PathVariable int id) {
		return new ResponseEntity<ResponseStructure>(service.fetchStudent(id), HttpStatus.FOUND);
	}

	@Operation(summary = "Fetching all students")
	@GetMapping("/students")
	public ResponseStructure fetchAllRequest() {
		return service.fetchAllStudents();
	}

	@Operation(summary = "fetch student by name")
	@GetMapping("/students/name/{name}")
	public ResponseStructure fetchbyNameRequest(@PathVariable String name) {
		return service.fetchByName(name);
	}

	@Operation(summary = "fetch student by mobile number")
	@GetMapping("/students/mobile/{mobile}")
	public ResponseStructure fetchbyMobieleRequest(@PathVariable Long mobile) {
		return service.fetchByMobile(mobile);
	}

	@Operation(summary = "save multiple students")
	@PostMapping("/students/many")
	public ResponseStructure saveStudents(@RequestBody List<Student> l1) {
		return service.saveStudents(l1);
	}

	@Operation(summary = "fetch student by result")
	@GetMapping("/students/result/{result}")
	public ResponseStructure findByResult(@PathVariable String result) {
		return service.findByResult(result);
	}

	@Operation(summary = "fetch student whose english marks id greter than")
	@GetMapping("/students/english/{marks}")
	public ResponseStructure findByEMarks(@PathVariable int marks) {
		return service.findByEngMarks(marks);
	}

	@GetMapping("/students/maths/{marks1}/{marks2}")
	public ResponseStructure findByMaths(@PathVariable int marks1, @PathVariable int marks2) {
		return service.findByMaths(marks1, marks2);
	}

	@GetMapping("/students/nameStartingWith/{prefix}")
	public ResponseStructure findByalpha(@PathVariable String prefix) {
		return service.findByAlphabet(prefix);
	}
	
//	@PutMapping("/students/update/phone/{id}/{mobile}")
//	public ResponseStructure updateMobile(@PathVariable int id,@PathVariable Long mobile) {
//		return service.updateByMobile(id,mobile);
//	}
}
