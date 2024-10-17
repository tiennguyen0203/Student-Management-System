package manage;

import java.util.List;

public abstract class Student {
	protected String studentID;
	protected String studentName;
	protected String dateOfBirth;
	
	public Student(String studentID, String studentName, String dateOfBirth) {
		this.studentID = studentID;
		this.studentName = studentName;
		this.dateOfBirth = dateOfBirth;
	}
	
	
	public abstract void registerSub(Subject sub);
	public abstract boolean graduateCondition();
	public abstract List<Subject> checkCompletedSub();
}
