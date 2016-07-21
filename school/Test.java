package school;

import school.student.Student;

public class Test {

	public static void main(String[] args) {


		School school = new School();
		
		Student student1 = new Student("이승기",141213,"수학");
		Student student2 = new Student("김수현",141518,"영어");
		Student student3 = new Student("주원",141230,"수학");
		Student student4 = new Student("김우빈",141255,"수학");
		Student student5 = new Student("이민호",141590,"영어");
		
		school.addStudent(student1);
		school.addStudent(student2);
		school.addStudent(student3);
		school.addStudent(student4);
		school.addStudent(student5);
		
		student1.setScore("수학", 95);
		student1.setScore("영어", 20);
		
		student2.setScore("수학", 90);
		student2.setScore("영어", 100);		
		
		student3.setScore("수학", 76);
		student3.setScore("영어", 60);
		
		student4.setScore("수학", 85);
		student4.setScore("영어", 89);
		
		student5.setScore("수학", 90);
		student5.setScore("영어", 95);		
		
		
		System.out.println(student1.getName()+"	"+student1.getStudentID()+"	"+student1.getMajorName()+"	"+student1.getScore("수학")+ student1.getMathGrade(student1)+"	" +student1.getScore("영어")+student1.getEnglishGrade(student1));
		System.out.println(student2.getName()+"	"+student2.getStudentID()+"	"+student2.getMajorName()+"	"+student2.getScore("수학")+ student2.getMathGrade(student2)+"	" +student2.getScore("영어")+student2.getEnglishGrade(student2));
		System.out.println(student3.getName()+"	"+student3.getStudentID()+"	"+student3.getMajorName()+"	"+student3.getScore("수학")+ student3.getMathGrade(student3)+"	" +student3.getScore("영어")+student3.getEnglishGrade(student3));
		System.out.println(student4.getName()+"	"+student4.getStudentID()+"	"+student4.getMajorName()+"	"+student4.getScore("수학")+ student4.getMathGrade(student4)+"	" +student4.getScore("영어")+student4.getEnglishGrade(student4));
		System.out.println(student5.getName()+"	"+student5.getStudentID()+"	"+student5.getMajorName()+"	"+student5.getScore("수학")+ student5.getMathGrade(student5)+"	" +student5.getScore("영어")+student5.getEnglishGrade(student5));
		

		
	}
}
