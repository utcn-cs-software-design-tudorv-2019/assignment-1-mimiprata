package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Student;

public class StudentDAO extends AbstractDAO<Student> {
private static final Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	
	private static final String loginString= "SELECT password FROM student where email=?";
	private static final String searchID= "SELECT idstudent FROM student where email=?";
	private static final String findIdGroup = "SELECT idgroup FROM student where idstudent = ?";
	private static final String findCNP ="SELECT cnp FROM student where idstudent=?";
	
	public String findpassword(String email) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement filterStatement = null;
		ResultSet rs = null;
		//List<Object> list = new ArrayList<Object>();
		
		try {
			filterStatement = dbConnection.prepareStatement(loginString);
			filterStatement.setString(1, email); 
			rs = filterStatement.executeQuery();
			while (rs.next()) {
				return rs.getString("password");
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return null;
	}
	public int findId(String email) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement filterStatement = null;
		ResultSet rs = null;
		//List<Object> list = new ArrayList<Object>();
		
		try {
			filterStatement = dbConnection.prepareStatement(searchID);
			filterStatement.setString(1, email); 
			rs = filterStatement.executeQuery();
			while (rs.next()) {
				return rs.getInt("idstudent");
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return (Integer) null;
	}
	
	public int findIdGroup(int id) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement filterStatement = null;
		ResultSet rs = null;
		//List<Object> list = new ArrayList<Object>();
		
		try {
			filterStatement = dbConnection.prepareStatement(findIdGroup);
			filterStatement.setInt(1, id); 
			rs = filterStatement.executeQuery();
			while (rs.next()) {
				return rs.getInt("idgroup");
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return (Integer) null;
	}
	public String findCNP(int id) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement filterStatement = null;
		ResultSet rs = null;
		//List<Object> list = new ArrayList<Object>();
		
		try {
			filterStatement = dbConnection.prepareStatement(findCNP);
			filterStatement.setInt(1, id); 
			rs = filterStatement.executeQuery();
			while (rs.next()) {
				return rs.getString("cnp");
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return null;
	}
 public List<Student> StudentListId (int id)
 {
	 List<Student>a=new ArrayList<Student>();
	 Student b= this.findById(id);
	 a.add(b);
	 
	return a;
	 
 }
}
