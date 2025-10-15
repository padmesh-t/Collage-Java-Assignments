package project2;
import java.util.*;
public class Receipt {
	private int receiptId;
	private Payment payment;
	private String date;
	public Receipt(int receiptId, Payment payment, String date) {
		this.receiptId = receiptId;
		this.payment = payment;
		this.date = date;
	}
	public String toString() {
		return "Receipt ID: " + receiptId +
		       ", Student: " + payment.getEnrollment().getStudent().getName() +
		       ", Course: " + payment.getEnrollment().getCourse().getCourseName() + ", Amount Paid: " + payment.getAmount() +
		       ", Date: " + date;
	}
}
class OnlineCourseSystem {
	private static Scanner sc = new Scanner(System.in);
	private static List<Course> courses = new ArrayList<>();
	private static List<Student> students = new ArrayList<>();
	private static List<Enrollment> enrollments = new ArrayList<>();
	public static void main(String[] args) {
		System.out.println("=== Online Course Enrollment System ===");
		int choice;
		do {
			System.out.println("1. Add Course");
			System.out.println("2. Add Student");
			System.out.println("3. Enroll in Course");
			System.out.println("4. Make Payment");
			System.out.println("5. Display Courses");
			System.out.println("6. Exit");
			System.out.print("Enter choice: ");
			choice = sc.nextInt();
			switch (choice) {
			case 1 -> addCourse();
			case 2 -> addStudent();
			case 3 -> enrollCourse();
			case 4 -> makePayment();
			case 5 -> displayCourses();
			case 6 -> System.out.println("Exiting system...");
				default -> System.out.println("Invalid choice!");
			}
		} while (choice != 6);
	}
	private static void addCourse() {
		System.out.print("Enter Course ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Course Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Instructor Name: ");
		String iname = sc.nextLine();
		System.out.print("Enter Instructor Email: ");
		String iemail = sc.nextLine();
		System.out.print("Enter Capacity: ");
		int cap = sc.nextInt();
		System.out.print("Enter Fee: ");
		double fee = sc.nextDouble();
		Instructor ins = new Instructor(id, iname, iemail);
		Course c = new Course(id, name, ins, cap, fee);
		courses.add(c);
		System.out.println("Course added successfully!");
	}
	private static void addStudent() {
		System.out.print("Enter Student ID: ");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.print("Enter Student Name: ");
		String name = sc.nextLine();
		System.out.print("Enter Email: ");
		String email = sc.nextLine();
		System.out.print("Is Premium Student (y/n): ");
		char ans = sc.next().charAt(0);
		if (ans == 'y' || ans == 'Y') {
			System.out.print("Enter Discount Percent: ");
			double disc = sc.nextDouble();
			students.add(new PremiumStudent(id, name, email, disc));
		} else {
			students.add(new Student(id, name, email));
		}
		System.out.println("Student added successfully!");
	}
	private static void enrollCourse() {
		System.out.print("Enter Student ID: ");
		int sid = sc.nextInt();
		Student st = students.stream().filter(s -> s.studentId == sid).findFirst().orElse(null);
		if (st == null) {
			System.out.println("Student not found!");
			return;
		}
		System.out.print("Enter Course ID: ");
		int cid = sc.nextInt();
		Course c = courses.stream().filter(cc -> cc.getCourseId() == cid).findFirst().orElse(null);
		if (c == null || c.getCapacity() <= 0) {
			System.out.println("Course not available!");
			return;
		}
		Enrollment e = new Enrollment(enrollments.size() + 1, st, c);
		enrollments.add(e);
		System.out.println("Enrollment created successfully! Please make payment to confirm.");
	}
	private static void makePayment() {
		System.out.print("Enter Enrollment ID: ");
		int eid = sc.nextInt();
		Enrollment e = enrollments.stream().filter(en -> en.toString().contains("Enrollment ID: " + eid)).findFirst().orElse(null);
		if (e == null) {
			System.out.println("Enrollment not found!");
			return;
		}
		double fee = e.getStudent().getFeeForCourse(e.getCourse());
		System.out.println("Fee to Pay: " + fee);
		sc.nextLine();
		System.out.print("Enter Payment Method (Card/UPI/Cash): ");
		String method = sc.nextLine();
		Payment p = new Payment(1, e, fee, method);
		p.makePayment();
		Receipt r = new Receipt(1, p, new Date().toString());
		System.out.println("\\n=== Payment Successful ===");
		System.out.println(r);
	}
	private static void displayCourses() {
		System.out.println("\\n=== Available Courses ===");
		for (Course c : courses) {
			System.out.println(c);
		}
	}
}
