import java.util.ArrayList;
import java.util.List;

public class ClassSection {

	private String classSectionId;

	private Subject subject;
	
	private String semeter;

	private String lecturer;

	private int maxCapacity;

	private List<Student> enrolledStudents;

	private List<Schedule> schedules;

	public ClassSection(String classSectionId, Subject subject, String semeter, String lecturer,
			int maxCapacity, List<Schedule> schedules) {
		this.classSectionId = classSectionId;
		this.subject = subject;
		this.semeter = semeter;
		this.lecturer = lecturer;
		this.maxCapacity = maxCapacity;
		this.enrolledStudents = new ArrayList<Student>();
		this.schedules = schedules;
	}

	public boolean addStudent(Student student) {
		if(enrolledStudents.size() >= maxCapacity) 
		{
			System.out.println("This class is full. Can not add student");
			return false;
		}
		else if(!isStudentEligible(student)) 
		{
			System.out.println("Students are not eligible to take this class.");
			return isStudentEligible(student);			
		}
		else
		{
			enrolledStudents.add(student);
			return isStudentEligible(student);
		}
		
	}

	public boolean removeStudent(int studentId) {
		return true;
	}

	public boolean isStudentEligible(Student student) {
		return true;
	}

	public String toString() {
		return null;
	}

	
	//Getter and Setter
	public String getClassSectionId() {
		return classSectionId;
	}



	public void setClassSectionId(String classSectionId) {
		this.classSectionId = classSectionId;
	}



	public Subject getSubject() {
		return subject;
	}



	public void setSubject(Subject subject) {
		this.subject = subject;
	}



	public String getSemeter() {
		return semeter;
	}



	public void setSemeter(String semeter) {
		this.semeter = semeter;
	}



	public String getLecturer() {
		return lecturer;
	}



	public void setLecturer(String lecturer) {
		this.lecturer = lecturer;
	}



	public int getMaxCapacity() {
		return maxCapacity;
	}



	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}



	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}



	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}



	public List<Schedule> getSchedules() {
		return schedules;
	}



	public void setSchedules(List<Schedule> schedules) {
		this.schedules = schedules;
	}



	

}
