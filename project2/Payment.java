package project2;
public class Payment {
	private int paymentId;
	private Enrollment enrollment;
	private double amount;
	private String paymentMethod;
	private boolean completed;
	public Payment(int paymentId, Enrollment enrollment, double amount, String paymentMethod) {
		this.paymentId = paymentId;
		this.enrollment = enrollment;
		this.amount = amount;
		this.paymentMethod = paymentMethod;
		this.completed = false;
	}
	public void makePayment() {
		completed = true;
		enrollment.confirmEnrollment();
	}
	public boolean isCompleted() {
		return completed;
	}
	public double getAmount() {
		return amount;
	}
	public Enrollment getEnrollment() {
		return enrollment;
	}
	public String toString() {
		return "Payment ID: " + paymentId + ", Amount: " + amount +
		       ", Method: " + paymentMethod + ", Completed: " + completed;
	}
}
