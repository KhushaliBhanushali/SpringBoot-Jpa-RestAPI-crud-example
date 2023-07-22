package in.aurosoft.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import in.aurosoft.entity.Student;
import in.aurosoft.repository.StudentRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService{
	
	private StudentRepository repository;
	
	@Override
	public List<Student> getAllStudent() {
		return repository.findAll();
	}

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Student getStudentById(Integer id) {
		Optional<Student> optional = repository.findById(id);
		Student student = null;
		if(optional.isPresent()) {
			student = optional.get();
		}else {
			throw new RuntimeException("Student not found for id:: "+id);
		}
		return student;
	}

	@Override
	public Student updateStudent(Student student, Integer id) {
		Student existingStudent = repository.findById(id).get();
		
		existingStudent.setName(student.getName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setPassword(student.getPassword());
		existingStudent.setPhone(student.getPhone());
		this.repository.save(existingStudent);
		return existingStudent;
	}

	@Override
	public void deleteStudentById(Integer id) {
		repository.findById(id);
		repository.deleteById(id);
		
	}

}
