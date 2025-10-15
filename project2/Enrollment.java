package project2;
public class Enrollment {
	private int enrollmentId;
	private Student student;
	private Course course;
	private boolean confirmed;
	public Enrollment(int enrollmentId, Student student, Course course) {
		this.enrollmentId = enrollmentId;
		this.student = student;
		this.course = course;
		this.confirmed = false;
	}
	public void confirmEnrollment() {
		this.confirmed = true;
		course.reduceCapacity();
	}
	public Student getStudent() {
		return student;
	}
	public Course getCourse() {
		return course;
	}
	public String toString() {
		return "Enrollment ID: " + enrollmentId + ", Student: " + student.getName() + ", Course: " + course.getCourseName() + ", Confirmed: " + confirmed;
	}
}