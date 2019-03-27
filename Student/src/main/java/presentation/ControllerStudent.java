package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import bll.StudentBLL;

import model.StudentTableModel;

public class ControllerStudent implements ActionListener{
	private StudentView view;
	private StudentBLL studentBLL;
	private StudentTableModel tableC;
	private int id;
	public ControllerStudent(StudentView v, int id){
		this.view = v;
		this.id=id;
		this.studentBLL= new StudentBLL();
		this.tableC=new StudentTableModel();
	
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == view.v)
		{
			JTable x=tableC.createTable(studentBLL.StudentListId(id));
			this.view.setTable(x);
		}
		if(source==view.enrol)
		{
			view.dispose();
			view.setCourseView(id);
			
		}
		/*if(source==view.sterge)
		{
			int id=view.getId1();
			studentBLL.delete(id);
			
		}*/
		if(source==view.update)
		{
			studentBLL.buildStudentForUpdate(id, view.getName1(),studentBLL.findCNP(id),view.getAdress1(),view.getEmail1(), view.getPassword1(), studentBLL.findIdGroup(id));
			
		}
		
	}
}
