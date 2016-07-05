package practice;

public class Student {
	String name;
	int ban;
	int no;
	int kor;
	int eng;
	int math;
	
	public Student(){};
	public Student(String name,int ban,int no,int kor,int eng, int math){
		this.name = name;
		this.ban = ban;
		this.no = no;
		this.kor =kor;
		this.eng = eng;
		this.math = math;
	}
	
	public int getTotal(){
		return kor+eng+math;
	}
	public float getAverage(){
		float average = (float)getTotal()/3;
		average = (float)Math.round(average*10)/10;
		return average;

	}
	
	public void info(){
		System.out.println("¿Ã∏ß  : "+this.name);
		System.out.println("√—¡°  : "+this.getTotal());
		System.out.println("∆Ú±’ : "+this.getAverage());
		
	}

}
