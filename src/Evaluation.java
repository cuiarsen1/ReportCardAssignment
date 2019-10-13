// Arsen Cui
// ICS3U1-01
// December 13, 2018
// Mr. Radulovic
// Assignment 3 - Grader Assignment

// Class storing all the methods needed to access the evaluations file

public class Evaluation {

	// Variables used to store the the values obtained by the evaluation methods
	private String courseCode;
	private String assignmentName;
	private String assignmentType;
	private double knowledgeMark;
	private double applicationMark;
	private double thinkingMark;
	private double communicationMark;
	private double weight;

	public Evaluation() {

	}

	// Gets the course code of an evaluation entry
	public String getCourseCode() {
		return courseCode;
	}

	// Sets a value to the course code of an evaluation try
	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

	// Gets the assignment name of an evaluation
	public String getAssignmentName() {
		return assignmentName;
	}

	// Sets a value to the assignment name of an evaluation
	public void setAssignmentName(String assignmentName) {
		this.assignmentName = assignmentName;
	}

	// Gets the assignment type of an evaluation
	public String getAssignmentType() {
		return assignmentType;
	}

	// Sets a value to the assignment type of an evaluation
	public void setAssignmentType(String assignmentType) {
		this.assignmentType = assignmentType;
	}

	// Gets the knowledge mark for an evaluation
	public double getKnowledgeMark() {
		return knowledgeMark;
	}

	// Sets a value to the knowledge mark for an evaluation
	public void setKnowledgeMark(double knowledgeMark) {
		this.knowledgeMark = knowledgeMark;
	}

	// Gets the application mark for an evaluation
	public double getApplicationMark() {
		return applicationMark;
	}

	// Sets a value to the application mark for an evaluation
	public void setApplicationMark(double applicationMark) {
		this.applicationMark = applicationMark;
	}

	// Gets the thinking mark for an evaluation
	public double getThinkingMark() {
		return thinkingMark;
	}

	// Sets a value to the thinking mark for an evaluation
	public void setThinkingMark(double thinkingMark) {
		this.thinkingMark = thinkingMark;
	}

	// Gets the communication mark for an evaluation
	public double getCommunicationMark() {
		return communicationMark;
	}

	// Sets a value to the communication mark for an evaluation
	public void setCommunicationMark(double communicationMark) {
		this.communicationMark = communicationMark;
	}

	// Gets the weight of an evaluation
	public double getWeight() {
		return weight;
	}

	// Sets a value to the weight of an evaluation
	public void setWeight(double weight) {
		this.weight = weight;
	}

}
