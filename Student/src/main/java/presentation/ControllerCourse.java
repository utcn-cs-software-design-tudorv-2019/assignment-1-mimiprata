package presentation;

import model.CourseTableModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import bll.CourseBLL;
import bll.TeacherBLL;

public class ControllerCourse implements ActionListener{
	private CourseView view;
	private int id;
	private CourseBLL courseBLL;
	private TeacherBLL teacherBLL;
	private CourseTableModel ctm;
	public ControllerCourse(CourseView v, int id)
	{
		this.view=v;
		this.id=id;
		this.courseBLL=new CourseBLL();
		this.teacherBLL=new TeacherBLL();
		this.ctm=new CourseTableModel();
		System.out.println("ddddddddddddddddddddd"+id);
		
	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == view.enrol) {
			
			int row = view.table.getSelectedRow();
			int idteacher=Integer.parseInt(view.table.getValueAt(row,0).toString());
			courseBLL.newCourse(idteacher, id);
			JOptionPane.showMessageDialog(null,"You have registered to this course!", null,
					JOptionPane.OK_OPTION);  
			
	}
		if (source ==view.mycourses)
		{
			JTable x =new JTable();
			x.setModel(courseBLL.tableGradeStud(id));
			view.setTable(x);
		}
		if(source == view.logout)
		{
			  
		            view.dispose();
		            // northInformation.removeAll();
		            // init();
		          LoginView login=new LoginView();
		       
		}
		
	}
	

	
	private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {                                     
	     JTable source = (JTable)evt.getSource();
	            int row = source.rowAtPoint( evt.getPoint() );
	            int column = source.columnAtPoint( evt.getPoint() );
	            String s=source.getModel().getValueAt(row, column)+"";
System.out.println(s);
	           // JOptionPane.showMessageDialog(null, s);


	}
}
