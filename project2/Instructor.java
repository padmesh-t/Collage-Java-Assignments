package project2;
import java.util.*;
class Instructor {
	private int instructorId;
	private String name;
	private String email;
	public Instructor(int instructorId, String name, String email) {
		this.instructorId = instructorId;
		this.name = name;
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public String toString() {
		return "Instructor ID: " + instructorId + ", Name: " + name + ", Email: " + email;
	}
}
