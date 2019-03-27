package bll;


import java.util.List;
import java.util.NoSuchElementException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import dao.StudentDAO;
import dao.TeacherDAO;
import model.Student;
import model.Teacher;

public class TeacherBLL {

	
	//private List<Validator<Client>> validators;
	private StudentDAO studentDAO;
	private TeacherDAO teacherDAO;
	public TeacherBLL() {
	//	validators=new ArrayList<Validator<Client>>();
		//validators.add(new EmailValidator());
		studentDAO=new StudentDAO();
		teacherDAO=new TeacherDAO();

	}
	
	//
	
	public Student findClientById(int id) {
		Student st =studentDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return st;
	}
	
	public List<Student> findAll() {
		return studentDAO.findAll();
	}
	public List<Teacher> showTeachers() {
		System.out.print("A INTRAT IN BLL");
		return teacherDAO.findAll();
	}
	
	public Student buildStudent (int id, String name, String cnp,String address,String email,String password,int idgroup) {
		Student c = new Student (id,name,cnp,address,email,password,idgroup);
		return studentDAO.insert(c);
		
	}
	public Student insert(Student c)
	{
		return studentDAO.insert(c);
	}
	
	public Student delete(int id)
	{
		return studentDAO.delete(id);
	}
	
	public Student buildStudentForUpdate(int id, String name, String cnp,String address,String email,String password,int idgroup)
	{
		Student c = new Student (id,name,cnp,address,email,password,idgroup);
		return studentDAO.update(id,c);
	}
	public Student update(int id, Student c)
	{
		return studentDAO.update(id, c);
	}
	
	public String findpassword(String x)
	{
		return teacherDAO.findpassword(x);
	}
	public int findId(String x)
	{
		return teacherDAO.findId(x);
	}
	public TableModel tableGroup(int id)
	{
		return teacherDAO.tableGroup(id);
	}
}