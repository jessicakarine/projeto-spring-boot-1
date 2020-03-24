package br.com.springboot.model;

import javax.persistence.Entity;

@Entity
public class Student extends AbstractEntity {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
//	private int id;
//	private String name;
//	public static List<Student> studentList;
//
//	static {
//		studentRepository();
//	}
//
//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public static List<Student> getStudentList() {
//		return studentList;
//	}
//
//	public static void setStudentList(List<Student> studentList) {
//		Student.studentList = studentList;
//	}
//
//	public Student(int id, String name) {
//		this(name);
//		this.id = id;
//	}
//
//	public Student(String name) {
//		this.name = name;
//	}
//
//	public Student() {
//	}
//
//	private static void studentRepository() {
//		studentList = new ArrayList<>(asList(new Student(1, "jess"), new Student(2, "aline")));
//	}
//
//	@Override
//	public int hashCode() {
//		final int prime = 31;
//		int result = 1;
//		result = prime * result + id;
//		return result;
//	}
//
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Student other = (Student) obj;
//		if (id != other.id)
//			return false;
//		return true;
//	}

}
