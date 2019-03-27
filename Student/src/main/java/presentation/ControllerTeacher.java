package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import bll.CourseBLL;
import bll.StudentBLL;

import model.StudentTableModel;

public class ControllerTeacher implements ActionListener{
	private TeacherView view;
	private StudentBLL studentBLL;
	private CourseBLL courseBLL;
	private StudentTableModel tableC;
	public ControllerTeacher(TeacherView v){
		this.view = v;
		this.courseBLL=new CourseBLL();
		this.studentBLL=new StudentBLL();
		this.tableC=new StudentTableModel();
	
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == view.v)
		{
			JTable x=tableC.createTable(studentBLL.findAll());
			this.view.setTable(x);
		}
		if(source==view.insereaza)
		{
			studentBLL.buildStudent(view.getId1(), view.getName1(),view.getCnp1(),view.getAdress1(),view.getEmail1(), view.getPassword1(), view.getIdgroup1());
			
			
		}
		if(source==view.sterge)
		{
			
			int row = view.table.getSelectedRow();
			int id=Integer.parseInt(view.table.getValueAt(row, 0).toString());
			
			if (courseBLL.findIdByStudent(id)!=0)
			{
				courseBLL.delete(courseBLL.findIdByStudent(id));
			}
			
			studentBLL.delete(id);
			
		}
		if(source==view.update)
		{
			int row = view.table.getSelectedRow();
			String cnp=view.table.getValueAt(row,3).toString();
			int id = Integer.parseInt(view.table.getValueAt(row, 0).toString());
			studentBLL.buildStudentForUpdate(id, view.getName1(),cnp,view.getAdress1(),view.getEmail1(), view.getPassword1(), view.getIdgroup1());
			
		}
		if (source== view.back)
		{
			view.dispose();
		}
		
	}
}
