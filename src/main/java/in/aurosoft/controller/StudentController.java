package in.aurosoft.controller;

import java.util.List;

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

import in.aurosoft.entity.Student;
import in.aurosoft.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

	StudentService service;

	@Autowired
	public void setService(StudentService service) {
		this.service = service;
	}
	
	@PostMapping()
	public ResponseEntity<Student> saveStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(service.saveStudent(student),HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Student> getAllStudents(){
		return service.getAllStudent();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable ("id") Integer id){
		return new ResponseEntity<Student>(service.getStudentById(id),HttpStatus.OK);
	}
	@PutMapping("{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable ("id") Integer id, @RequestBody Student student){
		return new ResponseEntity<Student>(service.updateStudent(student, id), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable ("id") Integer id){
		service.deleteStudentById(id);
		return new ResponseEntity<String>("Student deleted successfully!", HttpStatus.OK);
	}
}
