package school;

import school.student.Student;

public class Test {

	public static void main(String[] args) {


		School school = new School();
		
		Student student1 = new Student("�̽±�",141213,"����");
		Student student2 = new Student("�����",141518,"����");
		Student student3 = new Student("�ֿ�",141230,"����");
		Student student4 = new Student("����",141255,"����");
		Student student5 = new Student("�̹�ȣ",141590,"����");
		
		school.addStudent(student1);
		school.addStudent(student2);
		school.addStudent(student3);
		school.addStudent(student4);
		school.addStudent(student5);
		
		student1.setScore("����", 95);
		student1.setScore("����", 20);
		
		student2.setScore("����", 90);
		student2.setScore("����", 100);		
		
		student3.setScore("����", 76);
		student3.setScore("����", 60);
		
		student4.setScore("����", 85);
		student4.setScore("����", 89);
		
		student5.setScore("����", 90);
		student5.setScore("����", 95);		
		
		
		System.out.println(student1.getName()+"	"+student1.getStudentID()+"	"+student1.getMajorName()+"	"+student1.getScore("����")+ student1.getMathGrade(student1)+"	" +student1.getScore("����")+student1.getEnglishGrade(student1));
		System.out.println(student2.getName()+"	"+student2.getStudentID()+"	"+student2.getMajorName()+"	"+student2.getScore("����")+ student2.getMathGrade(student2)+"	" +student2.getScore("����")+student2.getEnglishGrade(student2));
		System.out.println(student3.getName()+"	"+student3.getStudentID()+"	"+student3.getMajorName()+"	"+student3.getScore("����")+ student3.getMathGrade(student3)+"	" +student3.getScore("����")+student3.getEnglishGrade(student3));
		System.out.println(student4.getName()+"	"+student4.getStudentID()+"	"+student4.getMajorName()+"	"+student4.getScore("����")+ student4.getMathGrade(student4)+"	" +student4.getScore("����")+student4.getEnglishGrade(student4));
		System.out.println(student5.getName()+"	"+student5.getStudentID()+"	"+student5.getMajorName()+"	"+student5.getScore("����")+ student5.getMathGrade(student5)+"	" +student5.getScore("����")+student5.getEnglishGrade(student5));
		

		
	}
}
