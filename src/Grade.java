// Arsen Cui
// ICS3U1-01
// December 13, 2018
// Mr. Radulovic
// Assignment 3 - Grader Assignment

// Class storing all the methods needed to access the grades file

public class Grade {
	
	// Variables used to store the the values obtained by the grade methods
	private String studentNumber;
	private String courseCode;
	private String assignmentName;
	private double knowledgeMark;
	private double applicationMark;
	private double thinkingMark;
	private double communicationMark;

	public Grade() 
	{
		
	}
	
	// Gets the student number of a grade entry
	public String getStudentNumber() {
		return studentNumber;
	}

	// Sets a value to the student number of a grade entry
	public void setStudentNumber(String studentNumber) {
		this.studentNumber = studentNumber;
	}

	// Gets the course code of a grade entry
	public String getCourseCode() {
		return courseCode;
	}

	// Sets a value to the course code of a grade entry
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	// Gets the assignment name of a grade entry
	public String getAssignmentName() {
		return assignmentName;
	}

	// Sets a value to the assignment name of a grade entry
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	// Gets the knowledge mark for a grade entry
	public double getKnowledgeMark() {
		return knowledgeMark;
	}

	// Sets a value to the knowledge mark for a grade entry
	public void setKnowledgeMark(double knowledgeMark) {
		this.knowledgeMark = knowledgeMark;
	}

	// Gets the application mark for a grade entry
	public double getApplicationMark() {
		return applicationMark;
	}

	// Sets a value to the application mark for a grade entry
	public void setApplicationMark(double applicationMark) {
		this.applicationMark = applicationMark;
	}

	// Gets the thinking mark for a grade entry
	public double getThinkingMark() {
		return thinkingMark;
	}

	// Sets a value to the thinking mark for a grade entry
	public void setThinkingMark(double thinkingMark) {
		this.thinkingMark = thinkingMark;
	}

	// Gets the communication mark for a grade entry
	public double getCommunicationMark() {
		return communicationMark;
	}

	// Sets a value to the communication mark for a grade entry
	public void setCommunicationMark(double communicationMark) {
		this.communicationMark = communicationMark;
	}
	
}
