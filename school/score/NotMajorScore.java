package school.score;

public class NotMajorScore implements IScore {


	public char grade(int score) {
		char grade = 'F';
		
		if(score>=90)
			grade = 'A';
		else if(score>=80)
			grade = 'B';
		else if(score>=70)
			grade = 'C';
		else if(score>=55)
			grade = 'D';
		
		
		
		
		return grade;
	}
}
