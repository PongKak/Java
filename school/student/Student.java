package school.student;

import java.util.ArrayList;

import school.score.IScore;
import school.score.MajorScore;
import school.score.NotMajorScore;


public class Student {
	
	private String name;
	private int studentID;
	private int majorCode;
	
	ArrayList<Integer> scoreList = new ArrayList<Integer>();
	
	
	public Student(String name,int studentID,int majorCode){
		this.name = name;
		this.studentID = studentID;
		this.majorCode = majorCode;
	}
	public Student(String name,int studentID,String majorName){
		this.name = name;
		this.studentID = studentID;
		
		if(majorName == "수학")
			this.majorCode = 0;
		else if(majorName == "영어")
			this.majorCode = 1;
		else
			this.majorCode = -1;
	}

	
	public void setScore(int subjectCode,int score){
		scoreList.add(subjectCode, score);
	}
	
	public void setScore(String subjectName,int score){
		if(subjectName == "수학")
			scoreList.add(0,score);
		else if(subjectName == "영어")
			scoreList.add(1, score);
		else
			System.out.println("그런 과목명을 다시 입력하세요");
		
	}
	
	public int getScore(int subjectCode){
		return scoreList.get(subjectCode);
	}
	
	public int getScore(String subjectName){
		if(subjectName == "수학")
			return scoreList.get(0);
		else if(subjectName == "영어")
			return scoreList.get(1);
		else
			System.out.println("그런 과목명을 다시 입력하세요");
		
		return 0;
	}
	
	///////////////////////////
	//학점을 얻는 부분
	IScore score;
	
	public char getGrade(int score){
		return this.score.grade(score);
		
	}
	
	public char getMathGrade(Student student)
	{
		if(student.getMajorCode() == 0){
			score = new MajorScore();
			return student.getGrade(student.getScore(0));
		}
		else{
			score = new NotMajorScore();
			return student.getGrade(student.getScore(0));
		}
	}

	public char getEnglishGrade(Student student)
	{
		if(student.getMajorCode() == 1){
			score = new MajorScore();
			return student.getGrade(student.getScore(1));	
		}else{

			score = new NotMajorScore();
			return student.getGrade(student.getScore(1));
		}
		
	}

	/////////////////////////
	
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getStudentID() {
		return studentID;
	}


	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}


	public int getMajorCode() {
		return majorCode;
	}
	
	public String getMajorName(){
		if(this.majorCode == 0)
			return "수학";
		else if(this.majorCode ==1)
			return "영어";
		
		return "없음";
		
	}


	public void setMajorCode(int majorCode) {
		this.majorCode = majorCode;
	}
	
	

}
