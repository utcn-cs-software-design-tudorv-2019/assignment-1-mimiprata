package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import connection.ConnectionFactory;
import model.Teacher;

public class TeacherDAO extends AbstractDAO<Teacher>{

	
	
	private static final String loginString= "SELECT password FROM teacher where email=?";
	private static final String searchID= "SELECT idteacher FROM teacher where email=?";
	private static final String studentsgroup="SELECT student.name,student.email,student.cnp,student.address FROM student WHERE idgroup=?";
	
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
				return rs.getInt("idteacher");
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return (Integer) null;
	}
	
	public TableModel tableGroup(int id) {
		DefaultTableModel model=new DefaultTableModel(new Object[] {"StudentName","Email", "CNP","Address"},0);
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement filterStatement = null;
		ResultSet rs = null;
		try {filterStatement = dbConnection.prepareStatement(studentsgroup);
		filterStatement.setInt(1, id); 
		rs = filterStatement.executeQuery();
		while (rs.next()) {
			String name = rs.getString("name");
			String email=rs.getString("email");
			String cnp = rs.getString("cnp");
			String address = rs.getString("address");
			model.addRow(new Object[] {name,email,cnp,address});
		}
		return model;
		}catch (Exception e){
			LOGGER.log(Level.WARNING, e.getMessage());
		}
		return null;
	}
	
	
	
}
