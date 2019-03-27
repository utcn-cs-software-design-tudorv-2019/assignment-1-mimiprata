package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import bll.CourseBLL;
import bll.StudentBLL;
import model.CourseTableModel;

public class ControllerGrade implements ActionListener {
	private GradeView view;
	private int id;
	private CourseTableModel tableC;
	private CourseBLL courseBLL;
	private StudentBLL studentBLL;
	public ControllerGrade(GradeView v,int id){
		this.view = v;
		this.id = id;
		studentBLL=new StudentBLL();
		courseBLL=new CourseBLL();
		tableC=new CourseTableModel();
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source==view.view)
		{
			JTable x =new JTable();
			x.setModel(courseBLL.tableGrade(id));
	view.setTable(x);
		}
		if (source == view.back)
		{
			
			view.dispose();
			//view.setTeacherOpView(id);
		}
		if (source == view.setGrade)
		{
			
			int row = view.table.getSelectedRow();
			String emailStudent=view.table.getValueAt(row,1).toString();
			int idStudent = studentBLL.findId(emailStudent);
			System.out.println(idStudent+ "id Stud");
			
			courseBLL.setGrade(idStudent,id,view.getEnterGrade1());	
			
		}
		
	}

}
