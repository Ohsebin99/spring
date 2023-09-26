package com.tjoeun.springDI_xml_namespace;

public class Studentinfo {
	
	private Student student;
	
	public Studentinfo() {	}

	public Studentinfo(Student student) {
		this.student = student;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Studentinfo [student=" + student + "]";
	}
	
	public void getStudentInfo() {
		System.out.println("이름: " + student.getName());
		System.out.println("나이: " + student.getAge());
		System.out.println("취미: " + student.getHobbies());
		System.out.println("신장: " + student.getHeight());
		System.out.println("체중: " + student.getWeight());
	}
}
