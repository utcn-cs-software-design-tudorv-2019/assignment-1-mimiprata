package bll;


import java.sql.Date;
import java.util.List;

import javax.swing.table.TableModel;

import dao.CourseDAO;
import model.Course;
import model.Student;

public class CourseBLL {
	private CourseDAO courseDAO;
	public CourseBLL()
	{
		courseDAO = new CourseDAO();
	}
	
	public List<Course> findAll() {
		return courseDAO.findAll();
	}
	public Course newCourse (int idteacher, int  idstudent) {
		
		return courseDAO.newCourse(idteacher, idstudent);
	}
	
	public Course delete(int id)
	{
		return courseDAO.delete(id);
	}
	

	public Course update(int id, Course c)
	{
		return courseDAO.update(id, c);
	}
	
	public int findId(int x)
	{
		System.out.println(x);
		return courseDAO.findId(x);
	}
	public Course setDate (int id, Date date) {
		
		return courseDAO.setDate(id,date);
	}
	public Course setGrade ( int idstudent,int idprof,String grade) {
		System.out.println( " idstud"+idstudent+" id prof " + idprof+" "+ grade);
		return courseDAO.setGrade(idstudent,idprof,grade);
	}
	public int findIdByStudent(int id)
	{
		return courseDAO.findIdByIdStudent(id);
	}
	
	
	public TableModel tableGrade(int id)
	{
		return courseDAO.tableGrade(id);
	}

	public TableModel tableGradeStud(int id) {
		// TODO Auto-generated method stub
		return courseDAO.tableGradeStud(id);
	}

	public TableModel tableCourse(int id) {
		// TODO Auto-generated method stub
		return courseDAO.tableCourse(id);
	}
}
