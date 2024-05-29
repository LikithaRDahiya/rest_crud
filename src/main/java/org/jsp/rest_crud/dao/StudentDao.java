package org.jsp.rest_crud.dao;

import java.util.List;
import java.util.Optional;

import org.jsp.rest_crud.dto.Student;
import org.jsp.rest_crud.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentDao {

	@Autowired
	StudentRepository repository;

	public void save(Student student) {
		repository.save(student);
	}

	public Optional<Student> fetch(int id) {
		return repository.findById(id);

	}

	public List<Student> fetchAll() {
		return repository.findAll();

	}

	public void saveStudents(List<Student> students) {
		repository.saveAll(students);

	}

	public List<Student> fetchByName(String name) {
		return repository.findByName(name);

	}

	public List<Student> fetchByMobile(Long mobile) {
		return repository.findByMobile(mobile);
	}

	public List<Student> findByResult(String result) {
		return repository.findByResult(result);
	}

	public List<Student> findByEngMarks(int marks) {
		return repository.findByEnglishGreaterThan(marks);
	}

	public List<Student> findByMathsMarks(int marks1, int marks2) {
		return repository.findByMathsBetween(marks1, marks2);
	}

	public List<Student> findByAlpha(String prefix) {
		return repository.findByNameStartingWith(prefix);
	}

	public void delete(int id) {
			repository.deleteById(id);
	}

}
