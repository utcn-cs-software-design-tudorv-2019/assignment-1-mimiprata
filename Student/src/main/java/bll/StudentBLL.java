package bll;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import dao.StudentDAO;
import model.Student;
import validator.CnpValidator;
import validator.EmailValidator;
import validator.NameValidator;
import validator.Validator;

public class StudentBLL {

	
	private List<Validator<Student>> validators;
	private StudentDAO studentDAO;
	
	public StudentBLL() {
		validators=new ArrayList<Validator<Student>>();
		validators.add(new CnpValidator());
		validators.add(new NameValidator());
		validators.add(new EmailValidator());
		studentDAO=new StudentDAO();

	}
	
	//
	public Student buildStudent (int id, String name, String cnp,String address,String email,String password,int idgroup) {
		Student c = new Student (id,name,cnp,address,email,password,idgroup);
		for (Validator<Student> v : validators) {
			System.out.println(v.isValid(c));
			if (v.isValid(c)==0) {
				
				throw new IllegalArgumentException("Invalid argument identified by " + v.getClass().getName());
			}
		}
		return studentDAO.insert(c);
		
	}
	public Student findStudentById(int id) {
		Student st =studentDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The student with id =" + id + " was not found!");
		}
		return st;
	}
	
	public List<Student> findAll() {
		return studentDAO.findAll();
	}
	public List<Student> StudentListId(int id) {
		return studentDAO.StudentListId(id);
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
		for (Validator<Student> v : validators) {
			System.out.println(v.isValid(c));
			if (v.isValid(c)==0) {
				
				throw new IllegalArgumentException("Invalid argument identified by " + v.getClass().getName());
			}
		}
		return studentDAO.update(id,c);
	}
	public Student update(int id, Student c)
	{
		return studentDAO.update(id, c);
	}
	
	public String findpassword(String x)
	{
		return studentDAO.findpassword(x);
	}
	
	public int findId(String x)
	{
		return studentDAO.findId(x);
	}
	public int findIdGroup(int id) {
		int x =studentDAO.findIdGroup(id);
		
		return x;
	}
	public String findCNP(int id) {
		String x =studentDAO.findCNP(id);
		
		return x;
	}
	
}