package school;

import java.util.ArrayList;

import school.student.Student;

public class School {
	
	private static School school = new School();
	
	public School getSchool(){
		if(school == null)
			school = new School();
		
		return school;
	}
	

	ArrayList<Student> studentList = new ArrayList<Student>();
	
	public void addStudent(Student student){
		studentList.add(student);
	}

}
