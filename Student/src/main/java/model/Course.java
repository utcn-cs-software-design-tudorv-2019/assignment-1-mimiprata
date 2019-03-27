package model;

import java.util.Date;

public class Course {
	private int idcourse;
	private Date examDate;
	private int idteacher;
	private int idstudent;
	private String grade;
	public Course() {
		
	}
	public Course (int idcourse, Date examDate, int idteacher, int idstudent, String grade)
	{
		this.idcourse=idcourse;
		this.examDate=examDate;
		this.idteacher=idteacher;
		this.idstudent=idstudent;
		this.grade=grade;
	}
	public int getIdcourse() {
		return idcourse;
	}
	public void setIdcourse(int idcourse) {
		this.idcourse = idcourse;
	}
	public int getIdteacher() {
		return idteacher;
	}
	public void setIdteacher(int idTeacher) {
		this.idteacher = idTeacher;
	}
	public Date getExamDate() {
		return examDate;
	}
	public void setExamDate(Date examDate) {
		this.examDate = examDate;
	}
	public int getIdstudent() {
		return idstudent;
	}
	public void setIdstudent(int idstudent) {
		this.idstudent = idstudent;
	}

	@Override
	public String toString() {
		return "Course [idcourse=" + idcourse  + ",examDate="+examDate+ ",grade=" + grade+ "]";
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
}
