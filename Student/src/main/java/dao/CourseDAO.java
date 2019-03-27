package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import connection.ConnectionFactory;
import model.Course;

public class CourseDAO extends AbstractDAO<Course> {
	private static final String searchID= "SELECT idcourse FROM course where idteacher=? ";
	private static final String seachIDStud = "SELECT idcourse FROM course where idstudent=?";
	private static final String findStudents = "SELECT student.name, student.email,teacher.courseName,course.examDate,course.grade FROM student,course,teacher WHERE course.idstudent=student.idstudent and course.idteacher=teacher.idteacher and teacher.idteacher=?";
	private static final String findGrades = "SELECT teacher.name, teacher.courseName,course.examDate,course.grade FROM student,course,teacher WHERE course.idstudent=student.idstudent and course.idteacher=teacher.idteacher and student.idstudent=?";
	private static final String findCourses = "SELECT DISTINCT teacher.name, teacher.courseName,course.examDate FROM course,teacher WHERE course.idteacher=teacher.idteacher and teacher.idteacher=?";
	public  Course newCourse(int idprof,int idstud)
	{

	
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;	
		ResultSet rs = null;
		try {
			statement = connection.prepareStatement("INSERT INTO course (idteacher, idstudent,grade,examDate) VALUES(?,?,?,?)");
			statement.setInt(1, idprof);
			statement.setInt(2, idstud);
			 Calendar cal = Calendar.getInstance();
		    cal.set( cal.HOUR_OF_DAY, 0 );
		    cal.set( cal.MINUTE, 0 );
		    cal.set( cal.SECOND, 0 );
		    cal.set( cal.MILLISECOND, 0 );
		    
		    java.sql.Date jsqlD = 
		       new java.sql.Date( cal.getTime().getTime() );
			statement.setDate(4, jsqlD);
			statement.setString(3,"-");
			statement.executeUpdate() ;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	public  Course setDate(int id,Date examDate)
	{

	
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;	
		ResultSet rs = null;
		try {
			statement = connection.prepareStatement("UPDATE course,teacher SET course.examDate = ? where  teacher.idteacher=course.idteacher and teacher.idteacher= ?"); 
					
			statement.setDate(1,examDate);
			statement.setInt(2, id);
			statement.executeUpdate() ;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	public  Course setGrade(int idstudent,int idprof, String grade)
	{

	
		Connection connection = ConnectionFactory.getConnection();
		PreparedStatement statement = null;	
		ResultSet rs = null;
		try {
			statement = connection.prepareStatement("UPDATE student,course,teacher SET course.grade = ?  WHERE student.idstudent =? and student.idstudent = course.idstudent and course.idteacher=teacher.idteacher and teacher.idteacher=?");
			statement.setString(1,grade);
			//statement.setInt(2,id);
			statement.setInt(2, idstudent);
			statement.setInt(3, idprof);
			statement.executeUpdate() ;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public int findId(int id) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement filterStatement = null;
		ResultSet rs = null;
		//List<Object> list = new ArrayList<Object>();
		
		try {
			filterStatement = dbConnection.prepareStatement(searchID);
			filterStatement.setInt(1, id); 
			//filterStatement.setInt(2, idstud);
			rs = filterStatement.executeQuery();
			while (rs.next()) {
				return rs.getInt("idcourse");
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return (Integer) null;
	}
	public int findIdByIdStudent(int id) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement filterStatement = null;
		ResultSet rs = null;
		//List<Object> list = new ArrayList<Object>();
		
		try {
			filterStatement = dbConnection.prepareStatement(seachIDStud);
			filterStatement.setInt(1, id); 
			//filterStatement.setInt(2, idstud);
			rs = filterStatement.executeQuery();
			while (rs.next()) {
				return rs.getInt("idcourse");
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return 0;
	}
	
	
	public TableModel tableGrade(int id) {
		DefaultTableModel model=new DefaultTableModel(new Object[] {"Student Name","Student email","Course Name", "ExamDate","Grade"},0);
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement filterStatement = null;
		ResultSet rs = null;
		try {filterStatement = dbConnection.prepareStatement(findStudents);
		filterStatement.setInt(1, id); 
		rs = filterStatement.executeQuery();
		while (rs.next()) {
			String student_name = rs.getString("name");
			String student_email = rs.getString("email");
			String teacher_courseName=rs.getString("courseName");
			String course_examDate = rs.getString("examDate");
			String course_grade=rs.getString("grade");
			model.addRow(new Object[] {student_name, student_email,teacher_courseName,course_examDate,course_grade});
		}
		return model;
		}catch (Exception e){
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return null;
	}
	public TableModel tableGradeStud(int id) {
		DefaultTableModel model=new DefaultTableModel(new Object[] {"Teacher Name","Course Name", "ExamDate","Grade"},0);
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement filterStatement = null;
		ResultSet rs = null;
		try {filterStatement = dbConnection.prepareStatement(findGrades);
		filterStatement.setInt(1, id); 
		rs = filterStatement.executeQuery();
		while (rs.next()) {
			String teacher_name = rs.getString("name");
			String teacher_courseName=rs.getString("courseName");
			String course_examDate = rs.getString("examDate");
			String course_grade=rs.getString("grade");
			model.addRow(new Object[] {teacher_name,teacher_courseName,course_examDate,course_grade});
		}
		return model;
		}catch (Exception e){
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return null;
	}
	public TableModel tableCourse(int id) {
		DefaultTableModel model=new DefaultTableModel(new Object[] {"Teacher Name","Course Name", "ExamDate"},0);
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement filterStatement = null;
		ResultSet rs = null;
		try {filterStatement = dbConnection.prepareStatement(findCourses);
		filterStatement.setInt(1, id); 
		rs = filterStatement.executeQuery();
		while (rs.next()) {
			String teacher_name = rs.getString("name");
			String teacher_courseName=rs.getString("courseName");
			String course_examDate = rs.getString("examDate");
			model.addRow(new Object[] {teacher_name,teacher_courseName,course_examDate});
		}
		return model;
		}catch (Exception e){
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return null;
	}
	

	
	
	
}
