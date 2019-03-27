package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTable;

import bll.CourseBLL;
import bll.TeacherBLL;
import model.CourseTableModel;

public class ControllerTeacherOp implements ActionListener {
	private TeacherOpView view;
	private int id;
	private TeacherBLL teacherBLL;
	private CourseTableModel tableC;
	private CourseBLL courseBLL;
	public ControllerTeacherOp(TeacherOpView v,int id){
		this.view = v;
		this.id = id;
		teacherBLL=new TeacherBLL();
		courseBLL=new CourseBLL();
		tableC=new CourseTableModel();
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == view.manageStudents)
		{
			view.setTeacherView();
		}
		if (source == view.reports)
		{
			view.setReportView(id);
			
		}
		if(source==view.view)
		{
			JTable x =new JTable();
			x.setModel(courseBLL.tableCourse(id));
				this.view.setTable(x);
		}
		
		if (source == view.setDate)
		{
			//int idCourse = courseBLL.findId(id);
			courseBLL.setDate(id,view.getEnterDate1());	
		}
		if (source == view.setGrade)
		{
			//view.dispose();
			//int idCourse = courseBLL.findId(id);
			//courseBLL.setGrade(idCourse,view.getEnterGrade1());	
			view.setGradeView(id);
		}
		if (source == view.back)
		{
			view.dispose();
			  LoginView login=new LoginView();
			
		}
	}
	
	

}
