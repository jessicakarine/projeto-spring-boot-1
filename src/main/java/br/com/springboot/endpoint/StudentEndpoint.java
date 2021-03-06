package br.com.springboot.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.springboot.error.ResourceNotFoundException;
import br.com.springboot.model.Student;
import br.com.springboot.repository.StudentRepository;

@RestController
@RequestMapping("students")
public class StudentEndpoint {

	private final StudentRepository studentDAO;

	@Autowired
	public StudentEndpoint(StudentRepository studentDAO) {
		this.studentDAO = studentDAO;
	}

	@GetMapping
	public ResponseEntity<?> listAll(Pageable pageable) {
		return new ResponseEntity<>(studentDAO.findAll(pageable), HttpStatus.OK);
	}

	@GetMapping(path = "/{id}")
	public ResponseEntity<?> getStudentById(@PathVariable("id") Long id, 
											@AuthenticationPrincipal UserDetails userDetails) {
 		System.out.println(userDetails);
		verifyIfStudentExists(id);
		return new ResponseEntity<>(studentDAO, HttpStatus.OK);
	}

	@GetMapping(path = "/findByName/{name}")
	public ResponseEntity<?> findStudentsByName(@PathVariable String name) {
		return new ResponseEntity<>(studentDAO.findByNameIgnoreCaseContaining(name), HttpStatus.OK);
	}

	@PostMapping
	@Transactional(rollbackFor = Exception.class)
	public ResponseEntity<?> save(@Valid @RequestBody Student student) {
		return new ResponseEntity<>(studentDAO.save(student), HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<?> update(@RequestBody Student student) {
		verifyIfStudentExists(student.getId());
		studentDAO.save(student);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@DeleteMapping(path = "/{id}")
	@PreAuthorize("hasRole('ADM')")
	public ResponseEntity<?> delete(@PathVariable Long id) {
		verifyIfStudentExists(id);
		studentDAO.deleteById(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	private void verifyIfStudentExists(Long id) {
		if (!studentDAO.findById(id).isPresent())
			throw new ResourceNotFoundException("Student not found for ID: " + id);
	}

}
