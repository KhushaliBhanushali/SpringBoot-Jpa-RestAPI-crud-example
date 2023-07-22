package in.aurosoft.service;

import java.util.List;

import in.aurosoft.entity.Student;

public interface StudentService {

	List<Student> getAllStudent();
	
	Student saveStudent(Student student);
	
	Student getStudentById(Integer id);
	
	Student updateStudent(Student student, Integer id);
	
	void deleteStudentById(Integer id);
}
