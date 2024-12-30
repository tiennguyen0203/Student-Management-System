public class Schedule {

	public String dayOfWeek;

	public String startTime;

	public String endTime;

	public String room;

	
	public Schedule(String dayOfWeek, String startTime, String endTime, String room) {
		super();
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
		this.room = room;
	}

	public String toString() {
		return null;
	}

	public boolean isConflict() {
		return false;
	}
}
