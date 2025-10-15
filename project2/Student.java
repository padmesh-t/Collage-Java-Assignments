package project2;
public class Student {
	protected int studentId;
	protected String name;
	protected String email;
	public Student(int studentId, String name, String email) {
		this.studentId = studentId;
		this.name = name;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public double getFeeForCourse(Course course) {
		return course.getFee();
	}
	public String toString() {
		return "Student ID: " + studentId + ", Name: " + name + ", Email: " + email;
	}
}