package manage;

import java.util.List;

public class StudentManager {
	private List<Student> studentList;
	
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	public void inputGrade(String studentID, String subjectID, float midtermGrade, float lastermGrade){
		for(Student student : studentList) {
			if(student.getStudentID().equals(studentID)) {
				if(student instanceof CreditStudent) {
					CreditStudent creditStudent = (CreditStudent) student;
					for(Subject subject : creditStudent.getSubList()) {
						if(subject.getSubjectID().equals(subjectID)) {
							subject.setMidtermGrade(midtermGrade);
							subject.setLasttermGrade(lastermGrade);
							creditStudent.checkCompletedSub();
							break;
						}
					}
				} else if(student instanceof RegimeStudent) {
					RegimeStudent regimeStudent = (RegimeStudent) student;
					for(Subject subject : regimeStudent.getSubList()) {
						if(subject.getSubjectID().equals(subjectID)) {
							subject.setMidtermGrade(midtermGrade);
							subject.setLasttermGrade(lastermGrade);
							regimeStudent.checkCompletedSub();
							break;
						}
					}
				}
			}
		}
	}
	
	public void considerGraduate(String studentID) {
		for(Student student : studentList) {
			if(student.getStudentID().equals(studentID)) {
				if(student.graduateCondition()) {
					System.out.println("Student " + student.getStudentName() + " is eligible to graduate.");
				}else {
					System.out.println("Student " + student.getStudentName() + " is not qualified to graduate.");
				}
			}
		}
	}
}
