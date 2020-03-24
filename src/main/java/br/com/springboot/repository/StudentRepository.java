package br.com.springboot.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.springboot.model.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Long>{
	
	List<Student> findByName(String name);

}
