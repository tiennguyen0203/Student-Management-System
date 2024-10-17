package manage;

import java.util.List;

public class Subject {
	private String subjectID;
	private String name;
	private short numberCredit;
	private List<Subject> conditionSub;
	private float midtermGrade;
	private float lasttermGrade;
	
	public Subject(String subjectID, String name, short numberCredit, List<Subject> conditionSub) {
        this.subjectID = subjectID;
        this.name = name;
        this.numberCredit = numberCredit;
        this.conditionSub = conditionSub;
    }
	
	public boolean availableRegister(List<Subject> completedSub) {
		for (Subject sub : conditionSub) {
			if (!completedSub.contains(sub)){
                return false;
            }
        }
        return true;
	}
	
	public boolean finish() {
		float finalGrade = this.midtermGrade*0.4f + this.lasttermGrade*0.6f;
		return finalGrade >= 4.0f;
	}  
	
	public short getNumberCredit() {
		return numberCredit;
	}
}
