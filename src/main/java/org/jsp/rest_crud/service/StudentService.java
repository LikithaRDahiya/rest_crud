package org.jsp.rest_crud.service;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.jsp.rest_crud.Exception.DataNotFoundException;
import org.jsp.rest_crud.dao.StudentDao;
import org.jsp.rest_crud.dto.ResponseStructure;
import org.jsp.rest_crud.dto.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
	@Autowired
	ResponseStructure structure;

	@Autowired
	StudentDao dao;

	public ResponseStructure saveStudent(Student student) {
		double percentage = (student.getEnglish() + student.getMaths() + student.getScience()) / 3.0;
		String result = "";
		student.setPercentage(percentage);
		if (student.getEnglish() < 35 || student.getMaths() < 35 || student.getScience() < 35) {
			result = "Fail";
		} else {
			if (percentage >= 85) {
				result = "distinction";
			} else if (percentage >= 60) {
				result = "first class";
			} else if (percentage >= 35) {
				result = "second class";
			} else {
				result = "Fail";
			}
		}
		student.setResult(result);
		dao.save(student);

		structure.setData(student);
		structure.setMessage("Record saved success");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseStructure fetchStudent(int id) {
		Optional<Student> op = dao.fetch(id);
		if (op.isEmpty()) {
			throw new DataNotFoundException("Data not found with id :" + id);
		} else {
			structure.setData(op.get());
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());

		}
		return structure;
	}

	public ResponseStructure fetchAllStudents() {
		List<Student> l1 = dao.fetchAll();
		if (l1.isEmpty()) {
			throw new DataNotFoundException();
		} else {
			structure.setData(l1);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure saveStudents(List<Student> students) {
		for (Student student : students) {
			double percentage = (student.getEnglish() + student.getMaths() + student.getScience()) / 3.0;
			String result = "";
			student.setPercentage(percentage);
			if (student.getEnglish() < 35 || student.getMaths() < 35 || student.getScience() < 35) {
				result = "Fail";
			} else {
				if (percentage >= 85) {
					result = "distinction";
				} else if (percentage >= 60) {
					result = "first class";
				} else if (percentage >= 35) {
					result = "second class";
				} else {
					result = "Fail";
				}
			}
		}
		dao.saveStudents(students);
		structure.setData(students);
		structure.setMessage("Records saved success");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

	public ResponseStructure fetchByName(String name) {
		List<Student> students = dao.fetchByName(name);
		if (students.isEmpty()) {
			throw new DataNotFoundException("Data not present with name : " + name);
		} else {
			structure.setData(students);
			structure.setMessage("data found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure fetchByMobile(Long mobile) {
		List<Student> students = dao.fetchByMobile(mobile);
		if (students.isEmpty()) {
			throw new DataNotFoundException("Data not found with mobile number : " + mobile);
		} else {
			structure.setData(students);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure findByResult(String result) {
		List<Student> students = dao.findByResult(result);
		if (students.isEmpty()) {
			throw new DataNotFoundException("No Student records found with result : " + result);
		} else {
			structure.setData(students);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure findByEngMarks(int marks) {
		List<Student> students = dao.findByEngMarks(marks);
		if (students.isEmpty()) {
			throw new DataNotFoundException("No Student Record found with english marks greater than " + marks);
		} else {
			structure.setData(students);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure findByMaths(int marks1, int marks2) {
		List<Student> students = dao.findByMathsMarks(marks1, marks2);
		if (students.isEmpty()) {
			throw new DataNotFoundException("Data not found with the maths marks between " + marks1 + " and " + marks2);
		} else {
			structure.setData(students);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure findByAlphabet(String prefix) {
		List<Student> students = dao.findByAlpha(prefix);
		if (students.isEmpty()) {
			throw new DataNotFoundException("No Student data found with the name starting with " + prefix);
		} else {
			structure.setData(students);
			structure.setMessage("Data Found");
			structure.setStatus(HttpStatus.FOUND.value());
			return structure;
		}
	}

	public ResponseStructure deleteStudent(int id) {
		dao.delete(id);
		structure.setData(id);
		structure.setMessage("record delete success");
		structure.setStatus(HttpStatus.CREATED.value());
		return structure;
	}

//	public ResponseStructure updateByMobile(int id, Long mobile) {
//		Optional<Student> student1 = dao.fetch(id);
//	}

}
