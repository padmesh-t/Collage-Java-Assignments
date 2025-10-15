package project2;
class Course {
	private int courseId;
	private String courseName;
	private Instructor instructor;
	private int capacity;
	private double fee;
	public Course(int courseId, String courseName, Instructor instructor, int capacity, double fee) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.instructor = instructor;
		this.capacity = capacity;
		this.fee=fee;
	}
	public int getCourseId() {
		return courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public int getCapacity() {
		return capacity;
	}
	public double getFee() {
		return fee;
	}
	public Instructor getInstructor() {
		return instructor;
	}
	public void reduceCapacity() {
		if (capacity > 0) capacity--;
	}
	public String toString() {
		return "Course ID: " + courseId + ", Name: " + courseName + ", Instructor: " + instructor.getName() + ", Capacity: " + capacity + ", Fee: " + fee;
	}
}

