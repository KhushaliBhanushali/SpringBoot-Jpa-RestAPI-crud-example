package in.aurosoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import in.aurosoft.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
