package school.subject;

import java.util.ArrayList;


public class Subject {
	
	int subjectCode;
	String subjectName;
	private int score;
	
	
	ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	
	public Subject(int subjectCode,String subjectName){
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		
		subjectList.add(this);
	}


	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score = score;
	}

	
	
}
