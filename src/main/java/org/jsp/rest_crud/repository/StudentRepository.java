package org.jsp.rest_crud.repository;

import java.util.List;

import org.jsp.rest_crud.dto.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByName(String name);

	List<Student> findByMobile(Long mobile);

	List<Student> findByResult(String result);

	List<Student> findByEnglishGreaterThan(int marks);

	List<Student> findByMathsBetween(int marks1, int marks2);

	List<Student> findByNameStartingWith(String prefix);


}
