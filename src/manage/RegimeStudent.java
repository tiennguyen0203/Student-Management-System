package manage;

import java.util.ArrayList;
import java.util.List;

public class RegimeStudent extends Student {
	
	private List<Subject> subList; 
	private List<Subject> completedSub;
	
	public RegimeStudent(String studentID, String studentName, String dateOfBirth, List<Subject> subList) {
		super(studentID, studentName, dateOfBirth);
		this.subList = subList;
		this.completedSub = new ArrayList<>();
	}
	
	public void completedSub(Subject sub) {
		if(sub.finish()) completedSub.add(sub);
	}
	@Override
	public void registerSub(Subject sub) {
		// TODO Auto-generated method stub
		System.out.println("Sinh vien nien che khong can dang ky mon hoc");
	}

	@Override
	public boolean graduateCondition() {
		// TODO Auto-generated method stub
		for(Subject sub : subList) {
			if(!subList.contains(sub)) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public List<Subject> checkCompletedSub(){
		return completedSub;
	}
	
	
	//Getter and setter for subject list
	public List<Subject> getCompletedSub(){
		return this.completedSub;
	}
	
	public void setSubList(List<Subject> subList) {
		this.subList = subList;
	}
	
	@Override
	public String getStudentID() {
		return this.studentID;
	}
	
	
	@Override
	public List<Subject> getSubList(){
		return subList;
	}
	
	@Override
	public String getStudentName() {
		return this.studentName;
	}

}
