package project2;
public class PremiumStudent extends Student {
	private double discountPercent;
	public PremiumStudent(int studentId, String name, String email, double discountPercent) {
		super(studentId, name, email);
		this.discountPercent = discountPercent;
	}
	@Override
	public double getFeeForCourse(Course course) {
		double fee = course.getFee();
		return fee - (fee * discountPercent / 100);
	}
	public String toString() {
		return super.toString() + " [Premium, Discount: " + discountPercent + "%]";
	}
}
