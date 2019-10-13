// Arsen Cui
// ICS3U1-01
// December 13, 2018
// Mr. Radulovic
// Assignment 3 - Grader Assignment

// Class storing all the methods needed to access the students file

import java.util.ArrayList;

public class Student {
	
	// Variables used to store the values obtained by the student methods
	private String lastName;
	private String firstName;
	private String studentNumber;
	private String phoneNumber;
	private ArrayList<String> course;
	
	public Student() 
	{
		course = new ArrayList<String>();
	}
	
	// Gets a student's last name
	public String getLastName()
	{
		return lastName;
	}
	
	// Sets a value to a student's last name
	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}
	
	// Gets a student's first name
	public String getFirstName() {
		return firstName;
	}

	// Sets a value to a student's first name
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	// Gets a student's student number
	public String getStudentNumber() {
		return studentNumber;
	}
	
	// Sets a value to a student's student number
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}
	
	// Gets a student's phone number
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	// Sets a value to a student's phone number
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	// Gets a student's course
	public String getCourse(int i) 
	{
		if (i < course.size())
			return course.get(i);
		return "";
	}
	
	// Sets a value to a student's course
	public void addCourse(String courseCode)
	{
		course.add(courseCode);
	}
	
}
