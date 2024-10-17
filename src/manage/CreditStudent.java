package manage;

import java.util.ArrayList;
import java.util.List;

public class CreditStudent extends Student {
	List<Subject> subList;
	List<Subject> completedSub;
	
	public CreditStudent(String studentID, String studentName, String dateOfBirth) {
		super(studentID, studentName, dateOfBirth);
		subList = new ArrayList<>();
		completedSub = new ArrayList<>();
	}
	@Override
	public void registerSub(Subject sub) {
		// TODO Auto-generated method stub
		if(sub.availableRegister(completedSub)) {
			subList.add(sub);
		}else {
			System.out.println("Unable to register for the course due to incomplete prerequisite credits!");
		}
		
	}

	@Override
	public boolean graduateCondition(){
		int tongTinChi = 0;
        for (Subject sub : subList) {
            if (sub.finish()) {
                tongTinChi += sub.getNumberCredit();
            }
        }
        return tongTinChi >= 120;
	}
	@Override
	public List<Subject> checkCompletedSub() {
		// TODO Auto-generated method stub
		return this.completedSub;
	};

}
