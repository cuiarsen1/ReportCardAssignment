// Arsen Cui
// ICS3U1-01
// December 13, 2018
// Mr. Radulovic
// Assignment 3 - Grader Assignment

// Class storing all the methods needed to access the courses file

public class Course {
	
	// Variables used to store the the values obtained by the course methods
	private String courseCode;
	private String courseName;
	private String roomNumber;
	
	public Course()
	{
		
	}

	// Gets a course's course code
	public String getCourseCode()
	{
		return courseCode;
	}
	
	// Sets a value to a course's course code
	public void setCourseCode(String courseCode)
	{
		this.courseCode = courseCode;
	}
	
	// Gets a course's name
	public String getCourseName()
	{
		return courseName;
	}
	
	// Sets a value to a course's name
	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}
	
	// Gets a course's room number
	public String getRoomNumber()
	{
		return roomNumber;
	}
	
	// Sets a value to a course's room number
	public void setRoomNumber(String roomNumber)
	{
		this.roomNumber = roomNumber;
	}
	
}
