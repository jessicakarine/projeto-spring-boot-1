package br.com.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	List<Student> findByNameIgnoreCaseContaining(String name);

}
