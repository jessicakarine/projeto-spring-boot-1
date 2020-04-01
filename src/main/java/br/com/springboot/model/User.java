package br.com.springboot.model;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User extends AbstractEntity {
	
	@NotEmpty
	@Column(unique = true)
	private String userName;
	
	@NotEmpty
	@JsonIgnore
	private String password;
	
	
	
	

}
