// Arsen Cui
// ICS3U1-01
// December 13, 2018
// Mr. Radulovic
// Assignment 3 - Grader Assignment

/*This program is an online report card. Through importing comma-separated files containing 
information about students and their marks, this program is able to display all of it in an orderly
manner. You can search for a student using their full name or student number, and it displays their
personal information, marks and mark breakdowns for each course, the class average, and information
about their courses.*/

/*Limitations 
When importing the files, the import buttons can't be pressed more than once, or else there
will be problems when importing and the file entries will be messed up.*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;

public class Assignment3 extends Application {

	private HBox root; // Contains the entire display

	private VBox fileLayout; // Contains the file importing menu
	
	private VBox reportLayout; // Contains the report card display

	private VBox studentInfoLayout; // Contains the student's personal information display
	
	private HBox studentMarkLayout; // Contains the student's marks display

	private VBox tableTitleLayout; // Contains the labels of the titles of each course

	private VBox tableCourseCodeLayout; // Contains the labels showing the course codes

	private VBox tableMarkLayout; // Contains the labels showing the total marks for each course

	private VBox tableKnowledgeLayout; // Contains labels showing the knowledge marks

	private VBox tableApplicationLayout; // Contains labels showing the application marks

	private VBox tableThinkingLayout; // Contains labels showing the thinking marks

	private VBox tableCommunicationLayout; // Contains labels showing the communication marks

	private VBox tableClassLayout; // Contains labels showing the class averages for each course

	private VBox tableCourseInfoLayout; // Contains labels showing information about each course

	private Border border; // Border surrounding the file importing menu

	// Arraylists containing information for all the students, courses, evaluations, and grades
	private ArrayList<Student> students; 
	private ArrayList<Course> courses;
	private ArrayList<Evaluation> evaluations;
	private ArrayList<Grade> grades; 
	
	private boolean studentValid; // Boolean checking if an inputted student is valid

	// Strings used to check the validity of an inputted student
	private String studentName; 
	private String studentNumber;
	
	// Labels containing student information, marks, and course information
	
	Label STUDENT_NAME;
	Label STUDENT_NUMBER;
	Label PHONE_NUMBER;
	
	Label COURSE_CODE_ONE;
	Label COURSE_CODE_TWO;
	Label COURSE_CODE_THREE;
	Label COURSE_CODE_FOUR;
	
	Label COURSE_ONE_MARK;
	Label COURSE_TWO_MARK;
	Label COURSE_THREE_MARK;
	Label COURSE_FOUR_MARK;
	
	Label COURSE_ONE_KNOWLEDGE;
	Label COURSE_TWO_KNOWLEDGE;
	Label COURSE_THREE_KNOWLEDGE;
	Label COURSE_FOUR_KNOWLEDGE;
	
	Label COURSE_ONE_APPLICATION;
	Label COURSE_TWO_APPLICATION;
	Label COURSE_THREE_APPLICATION;
	Label COURSE_FOUR_APPLICATION;
	
	Label COURSE_ONE_THINKING;
	Label COURSE_TWO_THINKING;
	Label COURSE_THREE_THINKING;
	Label COURSE_FOUR_THINKING;
	
	Label COURSE_ONE_COMMUNICATION;
	Label COURSE_TWO_COMMUNICATION;
	Label COURSE_THREE_COMMUNICATION;
	Label COURSE_FOUR_COMMUNICATION;
	
	Label CLASS_AVERAGE_ONE;
	Label CLASS_AVERAGE_TWO;
	Label CLASS_AVERAGE_THREE;
	Label CLASS_AVERAGE_FOUR;
	
	Label COURSE_INFO_ONE;
	Label COURSE_INFO_TWO;
	Label COURSE_INFO_THREE;
	Label COURSE_INFO_FOUR;
	

	public Assignment3() {
		
		students = new ArrayList<Student>();
		courses = new ArrayList<Course>();
		evaluations = new ArrayList<Evaluation>();
		grades = new ArrayList<Grade>();

	}

	// Method used to load in the student information
	public void loadStudents(String fileName) throws FileNotFoundException {
		
		// Sets up the file and the file reading scanner
		File studentFile = new File(fileName);
		Scanner studentInput = new Scanner(studentFile);

		studentInput.nextLine(); // Skips the headers

		/*While there are still student entries, read through the stundet file and store all the 
		information in the student object "s" */
		while (studentInput.hasNextLine()) 
		{
			String line = studentInput.nextLine();
			String[] fields = line.split(",");
			Student s = new Student();
			s.setFirstName(fields[0]);
			s.setLastName(fields[1]);
			s.setStudentNumber(fields[2]);
			s.setPhoneNumber(fields[3]);
			s.addCourse(fields[4]);
			s.addCourse(fields[5]);
			s.addCourse(fields[6]);
			s.addCourse(fields[7]);

			students.add(s);
		}

		studentInput.close();
	}

	// Method used to load in the course information
	public void loadCourses(String fileName) throws FileNotFoundException {
		
		// Sets up the file and the file reading scanner
		File courseFile = new File(fileName);
		Scanner courseInput = new Scanner(courseFile);

		courseInput.nextLine(); // Skips the headers

		/*While there are still course entries, read through the course file and store all the 
		information in the course object "c" */
		while (courseInput.hasNextLine()) {
			String line = courseInput.nextLine();
			String[] fields = line.split(",");
			Course c = new Course();
			c.setCourseCode(fields[0]);
			c.setCourseName(fields[1]);
			c.setRoomNumber(fields[2]);

			courses.add(c);

		}

		courseInput.close();
	}

	// Method used to load in the evaluation information
	public void loadEvaluations(String fileName) throws FileNotFoundException {
		
		// Sets up the file and the file reading scanner
		File evaluationFile = new File(fileName);
		Scanner evaluationInput = new Scanner(evaluationFile);

		evaluationInput.nextLine(); // Skips the headers

		/*While there are still evaluation entries, read through the evaluation file and store all 
		the information in the evaluation object "e" */
		while (evaluationInput.hasNextLine()) {
			String line = evaluationInput.nextLine();
			String[] fields = line.split(",");
			Evaluation e = new Evaluation();
			e.setCourseCode(fields[0]);
			e.setAssignmentName(fields[1]);
			e.setAssignmentType(fields[2]);
			e.setKnowledgeMark(Double.parseDouble(fields[3]));
			e.setApplicationMark(Double.parseDouble(fields[4]));
			e.setThinkingMark(Double.parseDouble(fields[5]));
			e.setCommunicationMark(Double.parseDouble(fields[6]));
			e.setWeight(Double.parseDouble(fields[7]));

			evaluations.add(e);

		}

		evaluationInput.close();
	}

	public void loadGrades(String fileName) throws FileNotFoundException {
	
		// Sets up the file and the file reading scanner
		File gradeFile = new File(fileName);
		Scanner gradeInput = new Scanner(gradeFile);

		gradeInput.nextLine(); // Skips the headers

		/*While there are still grade entries, read through the grade file and store all the 
		information in the grade object "g" */
		while (gradeInput.hasNextLine()) {
			String line = gradeInput.nextLine();
			String[] fields = line.split(",");
			Grade g = new Grade();
			g.setStudentNumber(fields[0]);
			g.setCourseCode(fields[1]);
			g.setAssignmentName(fields[2]);
			g.setKnowledgeMark(Double.parseDouble(fields[3]));
			g.setApplicationMark(Double.parseDouble(fields[4]));
			g.setThinkingMark(Double.parseDouble(fields[5]));
			g.setCommunicationMark(Double.parseDouble(fields[6]));

			grades.add(g);

		}

		gradeInput.close();
	}

	// Method used to calculate the overall mark for a course
	private String calculateCourse(String student_number, String courseCode) {

		ArrayList<Double> markBreakdown = new ArrayList<Double>();
		ArrayList<Double> markBreakdownTotal = new ArrayList<Double>();
		ArrayList<Double> totalMarkAssignment = new ArrayList<Double>();

		// Variables used to store the student's total mark and the course evaluation's total mark
		double markBreakdownSum;
		double markBreakdownTotalSum;

		ArrayList<Double> weightAssignments = new ArrayList<Double>();

		// Variables used to calculate the final mark
		double totalMark = 0;
		double totalWeight = 0;
		
		// Variable used to store the final mark of the course
		String totalMarkFinal;

		// For loop running through all of the assignments in the grade file
		for (int i = 0; i < grades.size(); i += 1) {
			
			// If the student number and course code in the student file and grade file match
			if (grades.get(i).getStudentNumber().equals(student_number)
				&& grades.get(i).getCourseCode().equals(courseCode)) 
			{
				/* Add up student's marks for all 4 categories 
				of assignment and store in markBreakdownSum*/
				
				markBreakdownSum = grades.get(i).getKnowledgeMark();
				markBreakdownSum += grades.get(i).getApplicationMark();
				markBreakdownSum += grades.get(i).getThinkingMark();
				markBreakdownSum += grades.get(i).getCommunicationMark();

				markBreakdown.add(markBreakdownSum);

			}

		}

		// For loop running through all of assignments in the evaluation file
		for (int i = 0; i < evaluations.size(); i += 1) {
			
			// If the course code in the student file and evaluation file match
			if (evaluations.get(i).getCourseCode().equals(courseCode)) 
			{
				/* Add up assignment's total marks for all 4 categories 
				and store in markBreakdownTotalSum*/
				
				markBreakdownTotalSum = evaluations.get(i).getKnowledgeMark();
				markBreakdownTotalSum += evaluations.get(i).getApplicationMark();
				markBreakdownTotalSum += evaluations.get(i).getThinkingMark();
				markBreakdownTotalSum += evaluations.get(i).getCommunicationMark();

				markBreakdownTotal.add(markBreakdownTotalSum);

				// Add the assignment's weight to the Arraylist weightAssignments
				weightAssignments.add(evaluations.get(i).getWeight());

			}

		}

		// Add the student's mark for each assignment into the Arraylist totalMarkAssignment
		for (int i = 0; i < markBreakdown.size(); i += 1) {
			totalMarkAssignment.add
			((markBreakdown.get(i) / markBreakdownTotal.get(i)) * weightAssignments.get(i));

		}
		
		// Finds the sum of all the assignment marks
		for (int i = 0; i < totalMarkAssignment.size(); i += 1) {
			totalMark += totalMarkAssignment.get(i);
		}
		
		// Finds the sum of all the weights of every assignment in the course
		for (int i = 0; i < weightAssignments.size(); i += 1) {
			totalWeight += weightAssignments.get(i);
		}

		// Calculates the final mark and stores it in a string
		totalMarkFinal = Double.toString(Math.round((totalMark / totalWeight) * 100));

		// If there are no entries for a course, return a blank
		if (totalMark == 0)
			return ""; 	
		
		// Returns the final mark of the course	
		else
			return totalMarkFinal;

	}

	// Method used to calculate the category breakdown of a course
	private String[] calculateBreakdown(String student_number, String courseCode) {

		// Arraylists used to store the marks and total marks of each category
		
		ArrayList<Double> markBreakdownKnowledge = new ArrayList<Double>();
		ArrayList<Double> markBreakdownApplication = new ArrayList<Double>();
		ArrayList<Double> markBreakdownThinking = new ArrayList<Double>();
		ArrayList<Double> markBreakdownCommunication = new ArrayList<Double>();

		ArrayList<Double> markBreakdownKnowledgeTotal = new ArrayList<Double>();
		ArrayList<Double> markBreakdownApplicationTotal = new ArrayList<Double>();
		ArrayList<Double> markBreakdownThinkingTotal = new ArrayList<Double>();
		ArrayList<Double> markBreakdownCommunicationTotal = new ArrayList<Double>();

		ArrayList<Double> totalMarkAssignmentKnowledge = new ArrayList<Double>();
		ArrayList<Double> totalMarkAssignmentApplication = new ArrayList<Double>();
		ArrayList<Double> totalMarkAssignmentThinking = new ArrayList<Double>();
		ArrayList<Double> totalMarkAssignmentCommunication = new ArrayList<Double>();

		// Arraylist used to store the weights of each assignment
		ArrayList<Double> weightAssignments = new ArrayList<Double>();

		// Variables used to calculate the marks for each category
		double totalWeight = 0;
		double[] totalMark = new double[4];
		
		// String array used to store the marks for each category
		String[] totalMarkFinal = new String[4];
		
		// String array used to store blanks in the case that the course has no entries
		String[] spaces = new String[4];

		// Runs through the assignments in the grade file
		for (int i = 0; i < grades.size(); i += 1) {
			
			// If the student number and course code in the student file and grade file match
			if (grades.get(i).getStudentNumber().equals(student_number)
				&& grades.get(i).getCourseCode().equals(courseCode)) 
			{
				// Adds the marks for each category into their respective Arraylists
				markBreakdownKnowledge.add(grades.get(i).getKnowledgeMark());
				markBreakdownApplication.add(grades.get(i).getApplicationMark());
				markBreakdownThinking.add(grades.get(i).getThinkingMark());
				markBreakdownCommunication.add(grades.get(i).getCommunicationMark());
			}

		}

		// Runs through the assignments in the evaluation file
		for (int i = 0; i < evaluations.size(); i += 1) {
			
			// if the course code in the student file and evaluation file matches
			if (evaluations.get(i).getCourseCode().equals(courseCode)) 
			{
				// Adds the total mark for each category into their respective Arraylist
				markBreakdownKnowledgeTotal.add(evaluations.get(i).getKnowledgeMark());
				markBreakdownApplicationTotal.add(evaluations.get(i).getApplicationMark());
				markBreakdownThinkingTotal.add(evaluations.get(i).getThinkingMark());
				markBreakdownCommunicationTotal.add(evaluations.get(i).getCommunicationMark());

				// Adds the weight of the assignment to an Arraylist
				weightAssignments.add(evaluations.get(i).getWeight());
			}

		}

		// Runs through the Arraylists and calculates the breakdown marks for each assignment
		for (int i = 0; i < markBreakdownKnowledge.size(); i += 1) 
		{
			totalMarkAssignmentKnowledge.add(
			(markBreakdownKnowledge.get(i) / markBreakdownKnowledgeTotal.get(i))
			* weightAssignments.get(i));

			totalMarkAssignmentApplication.add
			((markBreakdownApplication.get(i) / markBreakdownApplicationTotal.get(i))
			* weightAssignments.get(i));

			totalMarkAssignmentThinking
			.add((markBreakdownThinking.get(i) / markBreakdownThinkingTotal.get(i))
			* weightAssignments.get(i));

			totalMarkAssignmentCommunication
			.add((markBreakdownCommunication.get(i) / markBreakdownCommunicationTotal.get(i))
			* weightAssignments.get(i));
		}

		// Finds the sum of the marks for all the assignments for each category 
		for (int i = 0; i < totalMarkAssignmentKnowledge.size(); i += 1) 
		{
			totalMark[0] += totalMarkAssignmentKnowledge.get(i);
			totalMark[1] += totalMarkAssignmentApplication.get(i);
			totalMark[2] += totalMarkAssignmentThinking.get(i);
			totalMark[3] += totalMarkAssignmentCommunication.get(i);

		}
		
		// Finds the sum of all the weights
		for (int i = 0; i < weightAssignments.size(); i += 1) 
		{
			totalWeight += weightAssignments.get(i);
		}

		// Calculates the final mark for each category for the course
		totalMarkFinal[0] = Double.toString(Math.round((totalMark[0] / totalWeight) * 100)) + "%";
		totalMarkFinal[1] = Double.toString(Math.round((totalMark[1] / totalWeight) * 100)) + "%";
		totalMarkFinal[2] = Double.toString(Math.round((totalMark[2] / totalWeight) * 100)) + "%";
		totalMarkFinal[3] = Double.toString(Math.round((totalMark[3] / totalWeight) * 100)) + "%";

		// If there are no entries for the course, return a blank
		if (totalMark[0] == 0)
		{
			for (int i = 0; i < spaces.length; i += 1)
				spaces[i] = "";
			
			return spaces; 	
		}
		
		// Returns the final mark for each category
		else
			return totalMarkFinal;

	}
	
	// Method used to calculate the class average of a course
	private String calculateClassAverage(String courseCode) {
	 
		// Variables used to calculate the class average
		double classMarks = 0;
		double studentCount = 0;
		String classAverage;
		
		// Runs through all the assignments in the grade file
		for (int i = 0; i < grades.size(); i += 1)
		{
			// If a student has the course in the grade file
			if (grades.get(i).getCourseCode().equals(courseCode))
			{
				/* Calculate the mark for the course of that 
				student, and add it to the total class mark*/
				classMarks += Double.parseDouble
							  (calculateCourse(grades.get(i).getStudentNumber(), courseCode));
				
				// Keeps track of how many students are in the class
				studentCount += 1;
				
			}
		}
		
		// Calculates the average of the entire class
		classAverage = Double.toString(classMarks / studentCount);
		
		return classAverage;
	}
	
	// Method used to display the personal information of the student
	private void addStudentInfo(String STUDENT_INPUT)
	{
		// Runs through all of the students in the student file
		for (int i = 0; i < students.size(); i += 1) {

			studentName = students.get(i).getFirstName() + " " + students.get(i).getLastName();
			
			studentNumber = students.get(i).getStudentNumber();

			// If the input from the user matches a student's name or student number
			if (STUDENT_INPUT.equals(studentName) || STUDENT_INPUT.equals(studentNumber)) 
			{
				// Display the information 
				
				STUDENT_NAME.setText("Student Name: " + studentName);

				STUDENT_NUMBER.setText("Student Number: " + studentNumber);

				String phoneNumber = students.get(i).getPhoneNumber();
				PHONE_NUMBER.setText("Phone Number: " + phoneNumber);

			}		
		}
	}
	
	// Method used to display the course codes of the student
	private void addStudentCourses(String STUDENT_INPUT)
	{
		// Runs through all of the students in the student file
		for (int i = 0; i < students.size(); i += 1) {

			studentName = students.get(i).getFirstName() + " " 
						+ students.get(i).getLastName();
			
			studentNumber = students.get(i).getStudentNumber();

			// If the input from the user matches a student's name or student number
			if (STUDENT_INPUT.equals(studentName) || STUDENT_INPUT.equals(studentNumber)) 
			{
				// Find the course codes of the student's courses and display it
				
				String[] timetable = new String[4];

				for (int j = 0; j < timetable.length; j += 1)
					timetable[j] = students.get(i).getCourse(j);

				COURSE_CODE_ONE.setText(timetable[0]);
				COURSE_CODE_TWO.setText(timetable[1]);
				COURSE_CODE_THREE.setText(timetable[2]);
				COURSE_CODE_FOUR.setText(timetable[3]);
			}

		}
		
	}
	
	// Method used to display the overall mark for each of a student's courses
	private void addStudentMarks(String STUDENT_INPUT)
	{
		// Runs through all of the students in the student file
		for (int i = 0; i < students.size(); i += 1) {

			studentName = students.get(i).getFirstName() + " " + students.get(i).getLastName();
			
			studentNumber = students.get(i).getStudentNumber();

			// If the input from the user matches a student's name or student number
			if (STUDENT_INPUT.equals(studentName) || STUDENT_INPUT.equals(studentNumber)) 
			{
				// Calculate the overall mark for each of the student's courses and display it
				
				String courseOneMark = calculateCourse(studentNumber, students.get(i).getCourse(0));
		
				String courseTwoMark = calculateCourse(studentNumber, students.get(i).getCourse(1));
				
				String courseThreeMark = calculateCourse(studentNumber, 
									 students.get(i).getCourse(2));
				
				String courseFourMark = calculateCourse(studentNumber, 
									students.get(i).getCourse(3));
				
				if (courseOneMark != "")
					COURSE_ONE_MARK.setText(courseOneMark + "%");
				
				if (courseTwoMark != "")
					COURSE_TWO_MARK.setText(courseTwoMark + "%");
				
				if (courseThreeMark != "")
					COURSE_THREE_MARK.setText(courseThreeMark + "%");
				
				if (courseFourMark != "")
					COURSE_FOUR_MARK.setText(courseFourMark + "%");
				
				
			}
			
		}
	}
	
	// Method used to display the mark breakdown of each course
	private void addStudentBreakdown(String STUDENT_INPUT)
	{
		// Runs through all the students in the student file
		for (int i = 0; i < students.size(); i += 1) {

			studentName = students.get(i).getFirstName() + " " + students.get(i).getLastName();
			
			studentNumber = students.get(i).getStudentNumber();

			// If the input from the user matches a student's name or student number
			if (STUDENT_INPUT.equals(studentName) || STUDENT_INPUT.equals(studentNumber)) 
			{
				// Displays the values of the mark breakdown for each course
				
				String[] courseOneBreakdown;
				String[] courseTwoBreakdown;
				String[] courseThreeBreakdown;
				String[] courseFourBreakdown;
				
				/* If the calculated value is not null, display the
				marks. Otherwise, don't display anything*/
				if (calculateBreakdown
					(studentNumber, students.get(i).getCourse(0)) != null) {
					
					courseOneBreakdown = calculateBreakdown(studentNumber, 
															students.get(i).getCourse(0));
		
					COURSE_ONE_KNOWLEDGE.setText(courseOneBreakdown[0]);
					COURSE_ONE_APPLICATION.setText(courseOneBreakdown[1]);
					COURSE_ONE_THINKING.setText(courseOneBreakdown[2]);
					COURSE_ONE_COMMUNICATION.setText(courseOneBreakdown[3]);
				
				} else 
				{	
					COURSE_ONE_KNOWLEDGE.setText(null);
					COURSE_ONE_APPLICATION.setText(null);
					COURSE_ONE_THINKING.setText(null);
					COURSE_ONE_COMMUNICATION.setText(null);
				}
		
				/* If the calculated value is not null, display the
				marks. Otherwise, don't display anything*/
				if (calculateBreakdown
				   (studentNumber, students.get(i).getCourse(1)) != null) {
					
					courseTwoBreakdown = calculateBreakdown
										 (studentNumber, students.get(i).getCourse(1));
					
					COURSE_TWO_KNOWLEDGE.setText(courseTwoBreakdown[0]);
					COURSE_TWO_APPLICATION.setText(courseTwoBreakdown[1]);
					COURSE_TWO_THINKING.setText(courseTwoBreakdown[2]);
					COURSE_TWO_COMMUNICATION.setText(courseTwoBreakdown[3]);
				
				} else 
				{
					COURSE_TWO_KNOWLEDGE.setText(null);
					COURSE_TWO_APPLICATION.setText(null);
					COURSE_TWO_THINKING.setText(null);
					COURSE_TWO_COMMUNICATION.setText(null);
				}
		
				/* If the calculated value is not null, display the
				marks. Otherwise, don't display anything*/
				if (calculateBreakdown
				   (studentNumber, students.get(i).getCourse(2)) != null) {
				
					courseThreeBreakdown = calculateBreakdown(studentNumber, 
															 students.get(i).getCourse(2));
					
					COURSE_THREE_KNOWLEDGE.setText(courseThreeBreakdown[0]);
					COURSE_THREE_APPLICATION.setText(courseThreeBreakdown[1]);
					COURSE_THREE_THINKING.setText(courseThreeBreakdown[2]);
					COURSE_THREE_COMMUNICATION.setText(courseThreeBreakdown[3]);
			
				} else 
				{
					COURSE_THREE_KNOWLEDGE.setText(null);
					COURSE_THREE_APPLICATION.setText(null);
					COURSE_THREE_THINKING.setText(null);
					COURSE_THREE_COMMUNICATION.setText(null);
				}
		
				/* If the calculated value is not null, display the
				marks. Otherwise, don't display anything*/
				if (calculateBreakdown
				   (studentNumber, students.get(i).getCourse(3)) != null) {
					
					courseFourBreakdown = calculateBreakdown(studentNumber, 
														     students.get(i).getCourse(3));
					COURSE_FOUR_KNOWLEDGE.setText(courseFourBreakdown[0]);
					COURSE_FOUR_APPLICATION.setText(courseFourBreakdown[1]);
					COURSE_FOUR_THINKING.setText(courseFourBreakdown[2]);
					COURSE_FOUR_COMMUNICATION.setText(courseFourBreakdown[3]);
				
				} else 
				{
					COURSE_FOUR_KNOWLEDGE.setText(null);
					COURSE_FOUR_APPLICATION.setText(null);
					COURSE_FOUR_THINKING.setText(null);
					COURSE_FOUR_COMMUNICATION.setText(null);
				}
				
			}
		}
	}
	
	// Method used to display the class average for a course
	private void addClassAverage(String STUDENT_INPUT)
	{
		// Runs through all the students in the student file
		for (int i = 0; i < students.size(); i += 1) {

			studentName = students.get(i).getFirstName() + " " + students.get(i).getLastName();
			
			studentNumber = students.get(i).getStudentNumber();

			// If the input from the user matches a student's name or student number
			if (STUDENT_INPUT.equals(studentName) || STUDENT_INPUT.equals(studentNumber)) 
			{
				// Displays the class average for each course
				
				String[] classAverage = new String[4];
				
				classAverage[0] = calculateClassAverage(students.get(i).getCourse(0));
				classAverage[1] = calculateClassAverage(students.get(i).getCourse(1));
				classAverage[2] = calculateClassAverage(students.get(i).getCourse(2));
				classAverage[3] = calculateClassAverage(students.get(i).getCourse(3));
				
				// If there is a valid value for the calculated mark, display it 
				
				if (classAverage[0] != "NaN")
					CLASS_AVERAGE_ONE.setText(classAverage[0] + "%");
				
				if (classAverage[1] != "NaN")
					CLASS_AVERAGE_TWO.setText(classAverage[1] + "%");
				
				if (classAverage[2] != "NaN")
					CLASS_AVERAGE_THREE.setText(classAverage[2] + "%");
				
				if (classAverage[3] != "NaN")
					CLASS_AVERAGE_FOUR.setText(classAverage[3] + "%");
			}	
		}
	}
	
	// Method used to display more information about each course
	private void addCourseInfo(String STUDENT_INPUT)
	{
		// Runs through all the students in the student file
		for (int i = 0; i < students.size(); i += 1) {

			studentName = students.get(i).getFirstName() + " " + students.get(i).getLastName();
			
			studentNumber = students.get(i).getStudentNumber();

			// If the input from the user matches a student's name or student number
			if (STUDENT_INPUT.equals(studentName) || STUDENT_INPUT.equals(studentNumber)) 
			{
				// Displays the information about each course
				
				String[] courseName = new String[4];
				String[] roomNumber = new String[4];
				
				// Runs through every single course in the course file
				for (int j = 0; j < courses.size(); j += 1) 
				{
					/* If the student's course and the course in the course file
					match up, retrieve their information and display it*/
					
					if (students.get(i).getCourse(0).equals(courses.get(j).getCourseCode())) 
					{
						courseName[0] = courses.get(j).getCourseName();
						roomNumber[0] = courses.get(j).getRoomNumber();
					}
						
					if (students.get(i).getCourse(1).equals(courses.get(j).getCourseCode())) 
					{
						courseName[1] = courses.get(j).getCourseName();
						roomNumber[1] = courses.get(j).getRoomNumber();
					}
		
					if (students.get(i).getCourse(2).equals(courses.get(j).getCourseCode())) 
					{
						courseName[2] = courses.get(j).getCourseName();
						roomNumber[2] = courses.get(j).getRoomNumber();
					}
		
					if (students.get(i).getCourse(3).equals(courses.get(j).getCourseCode())) 
					{
						courseName[3] = courses.get(j).getCourseName();
						roomNumber[3] = courses.get(j).getRoomNumber();
					}
				}
				
				COURSE_INFO_ONE.setText("Course 1: " + courseName[0] + ". "
									  + "Room Number: " + roomNumber[0]);
				
				COURSE_INFO_TWO.setText("Course 2: " + courseName[1] + ". " 
									  + "Room Number: " + roomNumber[1]);
				
				COURSE_INFO_THREE.setText("Course 3: " + courseName[2] + ". " 
									    + "Room Number: " + roomNumber[2]);
				
				COURSE_INFO_FOUR.setText("Course 4: " + courseName[3] + ". " 
									   + "Room Number: " + roomNumber[3]);
				
			}
		}
	}
	

	public static void main(String[] args) throws FileNotFoundException {

		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		root = new HBox();

		fileLayout = new VBox();
		reportLayout = new VBox();
		studentInfoLayout = new VBox();
		studentMarkLayout = new HBox();

		tableTitleLayout = new VBox();
		tableCourseInfoLayout = new VBox();
		tableCourseCodeLayout = new VBox();
		tableMarkLayout = new VBox();
		tableKnowledgeLayout = new VBox();
		tableApplicationLayout = new VBox();
		tableThinkingLayout = new VBox();
		tableCommunicationLayout = new VBox();
		tableClassLayout = new VBox();

		// Initializes the scene
		double scenex = 1250;
		double sceney = 800;
		Scene scene = new Scene(root, scenex, sceney);

	
		// Initializes fonts
		Font FONT_IMPORT = new Font("Arial", 15);
		Font FONT_REPORT = new Font("Arial", 25);
		Font FONT_TIMETABLE = new Font("Arial", 15);

		// Initializes file importing menu

		fileLayout.setSpacing(10);
		
		Label FILE_STUDENT_LABEL = new Label("Search For The Student File To Import: ");
		FILE_STUDENT_LABEL.setFont(FONT_IMPORT);
		TextField FILE_STUDENT_TEXT = new TextField();
		Button FILE_STUDENT_BUTTON = new Button("Import Student File");

		Label FILE_COURSE_LABEL = new Label("Search For The Course File To Import: ");
		FILE_COURSE_LABEL.setFont(FONT_IMPORT);
		TextField FILE_COURSE_TEXT = new TextField();
		Button FILE_COURSE_BUTTON = new Button("Import Course File");

		Label FILE_EVALUATION_LABEL = new Label("Search For The Evaluation File To Import: ");
		FILE_EVALUATION_LABEL.setFont(FONT_IMPORT);
		TextField FILE_EVALUATION_TEXT = new TextField();
		Button FILE_EVALUATION_BUTTON = new Button("Import Evaluation File");

		Label FILE_GRADE_LABEL = new Label("Search For The Grade File To Import: ");
		FILE_GRADE_LABEL.setFont(FONT_IMPORT);
		TextField FILE_GRADE_TEXT = new TextField();
		Button FILE_GRADE_BUTTON = new Button("Import Grade File");
		
		Label S_FILE_IMPORT = new Label("Student File Not Imported");
		S_FILE_IMPORT.setFont(FONT_TIMETABLE);
		
		Label C_FILE_IMPORT = new Label("Course File Not Imported");
		C_FILE_IMPORT.setFont(FONT_TIMETABLE);
		
		Label E_FILE_IMPORT = new Label("Evaluation File Not Imported");
		E_FILE_IMPORT.setFont(FONT_TIMETABLE);
		
		Label G_FILE_IMPORT = new Label("Grade File Not Imported");
		G_FILE_IMPORT.setFont(FONT_TIMETABLE);

		// Button used to load the student file
		FILE_STUDENT_BUTTON.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {

				String STUDENT_FILE_INPUT = FILE_STUDENT_TEXT.getText();
				try {
					loadStudents(STUDENT_FILE_INPUT);
					S_FILE_IMPORT.setText("Student File Imported");

				} catch (FileNotFoundException e) {
					System.out.println("STUDENT FILE NOT FOUND");
					e.printStackTrace();
				}

			}

		});

		// Button used to load the course file
		FILE_COURSE_BUTTON.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {

				String COURSE_FILE_INPUT = FILE_COURSE_TEXT.getText();
				try {
					loadCourses(COURSE_FILE_INPUT);
					C_FILE_IMPORT.setText("Course File Imported");

				} catch (FileNotFoundException e) {
					System.out.println("COURSE FILE NOT FOUND");
					e.printStackTrace();
				}

			}

		});

		// Button used to load the evaluation file
		FILE_EVALUATION_BUTTON.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {

				String EVALUATION_FILE_INPUT = FILE_EVALUATION_TEXT.getText();
				try {
					loadEvaluations(EVALUATION_FILE_INPUT);
					E_FILE_IMPORT.setText("Evaluation File Imported");

				} catch (FileNotFoundException e) {
					System.out.println("EVALUATION FILE NOT FOUND");
					e.printStackTrace();
				}

			}

		});

		// Button used to load the grade file
		FILE_GRADE_BUTTON.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {

				String GRADE_FILE_INPUT = FILE_GRADE_TEXT.getText();
				try {
					loadGrades(GRADE_FILE_INPUT);
					G_FILE_IMPORT.setText("Grade File Imported");

				} catch (FileNotFoundException e) {
					System.out.println("GRADE FILE NOT FOUND");
					e.printStackTrace();
				}


			}

		});

		// Initalizes the student search menu
		
		Label STUDENT_SEARCH_LABEL = new Label("Search for a student using their" +
											   "\nfull name or student number: ");
		
		Label STUDENT_SEARCH_LABEL_2 = new Label("Make sure the first letters of the first"
											+ " and last name are capitalized \nand there is a "
											+ "space in between the first and last name");
		
		STUDENT_SEARCH_LABEL.setFont(FONT_IMPORT);
		TextField STUDENT_TEXTFIELD = new TextField();
		Button STUDENT_BUTTON = new Button("Search For Student");

		Label STUDENT_INVALID_LABEL = new Label();
		STUDENT_INVALID_LABEL.setFont(FONT_TIMETABLE);
		
		// Sets a border for the file importing and student searching menu
		border = new Border(new BorderStroke(Color.BLUE, BorderStrokeStyle.SOLID, null, null));
		fileLayout.setBorder(border);

		
		// Sets the spacing for the report card layout
		reportLayout.setSpacing(30);
		
		// Initalizes the student personal information display
		
		studentInfoLayout.setSpacing(30);
		
		STUDENT_NAME = new Label("Student Name: ");
		STUDENT_NAME.setFont(FONT_REPORT);
		STUDENT_NAME.setTranslateY(10);

		STUDENT_NUMBER = new Label("Student Number: ");
		STUDENT_NUMBER.setFont(FONT_REPORT);
		STUDENT_NUMBER.setTranslateY(10);

		PHONE_NUMBER = new Label("Phone Number: ");
		PHONE_NUMBER.setFont(FONT_REPORT);
		PHONE_NUMBER.setTranslateY(10);
		
		// The spacing value for the report card marks
		int tableSpacing = 50;
		
		
		// Initializes and displays all of the marks and course information
		
		
		tableTitleLayout.setSpacing(tableSpacing);

		Label COURSE_ONE_LABEL = new Label("Course 1");
		COURSE_ONE_LABEL.setFont(FONT_TIMETABLE);
		COURSE_ONE_LABEL.setTranslateY(67);

		Label COURSE_TWO_LABEL = new Label("Course 2");
		COURSE_TWO_LABEL.setFont(FONT_TIMETABLE);
		COURSE_TWO_LABEL.setTranslateY(67);

		Label COURSE_THREE_LABEL = new Label("Course 3");
		COURSE_THREE_LABEL.setFont(FONT_TIMETABLE);
		COURSE_THREE_LABEL.setTranslateY(67);

		Label COURSE_FOUR_LABEL = new Label("Course 4");
		COURSE_FOUR_LABEL.setFont(FONT_TIMETABLE);
		COURSE_FOUR_LABEL.setTranslateY(67);

		tableCourseCodeLayout.setSpacing(tableSpacing);

		Label COURSE_CODE = new Label("Course Code");
		COURSE_CODE.setFont(FONT_TIMETABLE);

		COURSE_CODE_ONE = new Label();
		COURSE_CODE_ONE.setFont(FONT_TIMETABLE);

		COURSE_CODE_TWO = new Label();
		COURSE_CODE_TWO.setFont(FONT_TIMETABLE);

		COURSE_CODE_THREE = new Label();
		COURSE_CODE_THREE.setFont(FONT_TIMETABLE);

		COURSE_CODE_FOUR = new Label();
		COURSE_CODE_FOUR.setFont(FONT_TIMETABLE);

		
		studentMarkLayout.setSpacing(35);
		
		
		tableMarkLayout.setSpacing(tableSpacing);

		Label COURSE_MARK = new Label("Total Mark");
		COURSE_MARK.setFont(FONT_TIMETABLE);

		COURSE_ONE_MARK = new Label();
		COURSE_ONE_MARK.setFont(FONT_TIMETABLE);

		COURSE_TWO_MARK = new Label();
		COURSE_TWO_MARK.setFont(FONT_TIMETABLE);

		COURSE_THREE_MARK = new Label();
		COURSE_THREE_MARK.setFont(FONT_TIMETABLE);

		COURSE_FOUR_MARK = new Label();
		COURSE_FOUR_MARK.setFont(FONT_TIMETABLE);

		
		tableKnowledgeLayout.setSpacing(tableSpacing);

		Label COURSE_KNOWLEDGE = new Label("Knowledge");
		COURSE_KNOWLEDGE.setFont(FONT_TIMETABLE);

		COURSE_ONE_KNOWLEDGE = new Label();
		COURSE_ONE_KNOWLEDGE.setFont(FONT_TIMETABLE);

		COURSE_TWO_KNOWLEDGE = new Label();
		COURSE_TWO_KNOWLEDGE.setFont(FONT_TIMETABLE);

		COURSE_THREE_KNOWLEDGE = new Label();
		COURSE_THREE_KNOWLEDGE.setFont(FONT_TIMETABLE);

		COURSE_FOUR_KNOWLEDGE = new Label();
		COURSE_FOUR_KNOWLEDGE.setFont(FONT_TIMETABLE);

		
		tableApplicationLayout.setSpacing(tableSpacing);

		Label COURSE_APPLICATION = new Label("Application");
		COURSE_APPLICATION.setFont(FONT_TIMETABLE);

		COURSE_ONE_APPLICATION = new Label();
		COURSE_ONE_APPLICATION.setFont(FONT_TIMETABLE);

		COURSE_TWO_APPLICATION = new Label();
		COURSE_TWO_APPLICATION.setFont(FONT_TIMETABLE);

		COURSE_THREE_APPLICATION = new Label();
		COURSE_THREE_APPLICATION.setFont(FONT_TIMETABLE);

		COURSE_FOUR_APPLICATION = new Label();
		COURSE_FOUR_APPLICATION.setFont(FONT_TIMETABLE);

		
		tableThinkingLayout.setSpacing(tableSpacing);

		Label COURSE_THINKING = new Label("Thinking");
		COURSE_THINKING.setFont(FONT_TIMETABLE);

		COURSE_ONE_THINKING = new Label();
		COURSE_ONE_THINKING.setFont(FONT_TIMETABLE);

		COURSE_TWO_THINKING = new Label();
		COURSE_TWO_THINKING.setFont(FONT_TIMETABLE);

		COURSE_THREE_THINKING = new Label();
		COURSE_THREE_THINKING.setFont(FONT_TIMETABLE);

		COURSE_FOUR_THINKING = new Label();
		COURSE_FOUR_THINKING.setFont(FONT_TIMETABLE);

		
		tableCommunicationLayout.setSpacing(tableSpacing);

		Label COURSE_COMMUNICATION = new Label("Communication");
		COURSE_COMMUNICATION.setFont(FONT_TIMETABLE);

		COURSE_ONE_COMMUNICATION = new Label();
		COURSE_ONE_COMMUNICATION.setFont(FONT_TIMETABLE);

		COURSE_TWO_COMMUNICATION = new Label();
		COURSE_TWO_COMMUNICATION.setFont(FONT_TIMETABLE);

		COURSE_THREE_COMMUNICATION = new Label();
		COURSE_THREE_COMMUNICATION.setFont(FONT_TIMETABLE);

		COURSE_FOUR_COMMUNICATION = new Label();
		COURSE_FOUR_COMMUNICATION.setFont(FONT_TIMETABLE);
		

		tableClassLayout.setSpacing(tableSpacing);

		Label CLASS_AVERAGE = new Label("Class Average");
		CLASS_AVERAGE.setFont(FONT_TIMETABLE);

		CLASS_AVERAGE_ONE = new Label();
		CLASS_AVERAGE_ONE.setFont(FONT_TIMETABLE);

		CLASS_AVERAGE_TWO = new Label();
		CLASS_AVERAGE_TWO.setFont(FONT_TIMETABLE);

		CLASS_AVERAGE_THREE = new Label();
		CLASS_AVERAGE_THREE.setFont(FONT_TIMETABLE);

		CLASS_AVERAGE_FOUR = new Label();
		CLASS_AVERAGE_FOUR.setFont(FONT_TIMETABLE);

		
		tableCourseInfoLayout.setSpacing(10);

		COURSE_INFO_ONE = new Label();
		COURSE_INFO_ONE.setFont(FONT_TIMETABLE);

		COURSE_INFO_TWO = new Label();
		COURSE_INFO_TWO.setFont(FONT_TIMETABLE);

		COURSE_INFO_THREE = new Label();
		COURSE_INFO_THREE.setFont(FONT_TIMETABLE);

		COURSE_INFO_FOUR = new Label();
		COURSE_INFO_FOUR.setFont(FONT_TIMETABLE);

		// Button used to search for a student
		STUDENT_BUTTON.setOnAction(new EventHandler<ActionEvent>() {

			public void handle(ActionEvent arg0) {

				// Receives input from the user
				String STUDENT_INPUT = STUDENT_TEXTFIELD.getText();

				// Runs through all the students in the student file
				for (int i = 0; i < students.size(); i += 1) {

					studentName = students.get(i).getFirstName() + " " 
								+ students.get(i).getLastName();
					
					studentNumber = students.get(i).getStudentNumber();

					// If the input from the user matches a student's name or student number
					if (STUDENT_INPUT.equals(studentName) || STUDENT_INPUT.equals(studentNumber)) {
						
						// Display all of the student's information, marks, and courses
						
						studentValid = true; 

						addStudentInfo(STUDENT_INPUT);
					
						addStudentCourses(STUDENT_INPUT);

						addStudentMarks(STUDENT_INPUT);

						addStudentBreakdown(STUDENT_INPUT);
						
						addClassAverage(STUDENT_INPUT);
						
						addCourseInfo(STUDENT_INPUT);

						STUDENT_INVALID_LABEL.setText("");

						break;

					// If the input from the user does not match a student in the files
					} else 
					{
						// Clear the screen
						
						studentValid = false;
						STUDENT_NAME.setText("Student Name: ");
						STUDENT_NUMBER.setText("Student Number: ");
						PHONE_NUMBER.setText("Phone Number: ");
						COURSE_CODE_ONE.setText("");
						COURSE_CODE_TWO.setText("");
						COURSE_CODE_THREE.setText("");
						COURSE_CODE_FOUR.setText("");
						COURSE_ONE_MARK.setText("");
						COURSE_TWO_MARK.setText("");
						COURSE_THREE_MARK.setText("");
						COURSE_FOUR_MARK.setText("");	
						COURSE_ONE_KNOWLEDGE.setText("");
						COURSE_TWO_KNOWLEDGE.setText("");
						COURSE_THREE_KNOWLEDGE.setText("");
						COURSE_FOUR_KNOWLEDGE.setText("");
						COURSE_ONE_APPLICATION.setText("");
						COURSE_TWO_APPLICATION.setText("");
						COURSE_THREE_APPLICATION.setText("");
						COURSE_FOUR_APPLICATION.setText("");
						COURSE_ONE_THINKING.setText("");
						COURSE_TWO_THINKING.setText("");
						COURSE_THREE_THINKING.setText("");
						COURSE_FOUR_THINKING.setText("");
						COURSE_ONE_COMMUNICATION.setText("");
						COURSE_TWO_COMMUNICATION.setText("");
						COURSE_THREE_COMMUNICATION.setText("");
						COURSE_FOUR_COMMUNICATION.setText("");
						CLASS_AVERAGE_ONE.setText("");
						CLASS_AVERAGE_TWO.setText("");
						CLASS_AVERAGE_THREE.setText("");
						CLASS_AVERAGE_FOUR.setText("");
						COURSE_INFO_ONE.setText("");
						COURSE_INFO_TWO.setText("");
						COURSE_INFO_THREE.setText("");
						COURSE_INFO_FOUR.setText("");
					
					}

				}

				// If the user inputted student doesn't exist
				if (studentValid == false) {
					
					// Tell the user that the student doesn't exist
					STUDENT_INVALID_LABEL.setText("Student Does Not Exist");
				}

			}

		});

		// Add all the labels, textfields and buttons to their respective display screens
		
		tableTitleLayout.getChildren().addAll(COURSE_ONE_LABEL, COURSE_TWO_LABEL, 
											  COURSE_THREE_LABEL, COURSE_FOUR_LABEL);
		
		tableCourseCodeLayout.getChildren().addAll(COURSE_CODE, COURSE_CODE_ONE, COURSE_CODE_TWO,
												   COURSE_CODE_THREE, COURSE_CODE_FOUR);
		
		tableMarkLayout.getChildren().addAll(COURSE_MARK, COURSE_ONE_MARK, COURSE_TWO_MARK, 
											 COURSE_THREE_MARK, COURSE_FOUR_MARK);
		
		tableKnowledgeLayout.getChildren().addAll(COURSE_KNOWLEDGE, COURSE_ONE_KNOWLEDGE, 
							COURSE_TWO_KNOWLEDGE, COURSE_THREE_KNOWLEDGE, COURSE_FOUR_KNOWLEDGE);
		
		tableApplicationLayout.getChildren().addAll(COURSE_APPLICATION, COURSE_ONE_APPLICATION, 
					COURSE_TWO_APPLICATION, COURSE_THREE_APPLICATION, COURSE_FOUR_APPLICATION);
		
		tableThinkingLayout.getChildren().addAll(COURSE_THINKING, COURSE_ONE_THINKING, 
								COURSE_TWO_THINKING, COURSE_THREE_THINKING, COURSE_FOUR_THINKING);
		
		tableCommunicationLayout.getChildren().addAll(COURSE_COMMUNICATION,COURSE_ONE_COMMUNICATION,
				COURSE_TWO_COMMUNICATION, COURSE_THREE_COMMUNICATION, COURSE_FOUR_COMMUNICATION);
		
		tableClassLayout.getChildren().addAll(CLASS_AVERAGE, CLASS_AVERAGE_ONE, CLASS_AVERAGE_TWO, 
											  CLASS_AVERAGE_THREE, CLASS_AVERAGE_FOUR);
		
		tableCourseInfoLayout.getChildren().addAll(COURSE_INFO_ONE, COURSE_INFO_TWO, 
												   COURSE_INFO_THREE, COURSE_INFO_FOUR);

		studentInfoLayout.getChildren().addAll(STUDENT_NAME,STUDENT_NUMBER,PHONE_NUMBER);
		
		studentMarkLayout.getChildren().addAll(tableTitleLayout, tableCourseCodeLayout, 
			tableMarkLayout, tableKnowledgeLayout, tableApplicationLayout, tableThinkingLayout, 
			tableCommunicationLayout, tableClassLayout);
		
		reportLayout.getChildren().addAll(studentInfoLayout, studentMarkLayout, tableCourseInfoLayout);
		
		fileLayout.getChildren().addAll(FILE_STUDENT_LABEL, FILE_STUDENT_TEXT, FILE_STUDENT_BUTTON, 
				FILE_COURSE_LABEL, FILE_COURSE_TEXT, FILE_COURSE_BUTTON, FILE_EVALUATION_LABEL, 
				FILE_EVALUATION_TEXT, FILE_EVALUATION_BUTTON, FILE_GRADE_LABEL, FILE_GRADE_TEXT, 
				FILE_GRADE_BUTTON, STUDENT_SEARCH_LABEL, STUDENT_SEARCH_LABEL_2, STUDENT_TEXTFIELD,
				STUDENT_BUTTON, S_FILE_IMPORT, C_FILE_IMPORT, E_FILE_IMPORT, G_FILE_IMPORT, STUDENT_INVALID_LABEL);
		
		root.getChildren().addAll(fileLayout, reportLayout);

		// Displays the scene
		primaryStage.setTitle("Assignment3");
		primaryStage.setScene(scene);
		primaryStage.show();

	}

}
