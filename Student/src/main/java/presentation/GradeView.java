package presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import bll.CourseBLL;
import bll.StudentBLL;
import bll.TeacherBLL;
import model.CourseTableModel;

public class GradeView extends JFrame {

	JTable table;
	private JScrollPane scrollPane;
	private JLabel enterGrade;
	 JTextField enterGrade1;
	 JButton setGrade;
	 JButton view;
	 JButton back;
		ControllerGrade controllergrade ;
		private StudentBLL studentBLL;
		private CourseTableModel tableC;
		private CourseBLL courseBLL;
		private TeacherView viewTeacher;
		private TeacherOpView viewTeacherOp;
		public GradeView(int id)
		{
			controllergrade=new ControllerGrade(this,id);
			scrollPane=new JScrollPane();
			tableC=new CourseTableModel();
			courseBLL = new CourseBLL();
			studentBLL=new StudentBLL();
			setGrade=new JButton("Set Grade");
			view=new JButton("View");
			back=new JButton("Back");
			enterGrade = new JLabel("Enter grade:");
			enterGrade1= new JTextField(3);
			JPanel panel1=new JPanel();
			panel1.add(view);
			panel1.add( Box.createRigidArea(new Dimension(5,5)) );
			enterGrade.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel1.add(enterGrade);
			panel1.add( Box.createRigidArea(new Dimension(10,5)) );
			enterGrade1.setMaximumSize(new Dimension(145, 20));
			enterGrade1.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel1.add(enterGrade1);
			panel1.add(setGrade);
			panel1.add(back);
			JPanel tablePanel = new JPanel();
			tablePanel.setLayout(new BorderLayout(0, 0));

			tablePanel.add(scrollPane);
			JPanel panel3 = new JPanel();
			panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
			this.add(panel3);
			panel3.add(panel1);
			panel3.add(tablePanel);
			setGrade.addActionListener(controllergrade);
			view.addActionListener(controllergrade);
			back.addActionListener(controllergrade);
			JTable x =new JTable();
					x.setModel(courseBLL.tableGrade(id));
			this.setTable(x);
		
			this.setTitle("Grades");
			this.setVisible(true);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setSize(500,500);
		}
		public void setTable(JTable newTable) {
			this.table = newTable;
			System.out.println("----"+table.getColumnName(1));

			scrollPane.setViewportView(table);
			repaint();
			revalidate();
		}
		public void setTeacherOpView(int id) {
			// TODO Auto-generated method stub
			viewTeacherOp = new TeacherOpView(id);
			//viewInsert.addBtnListener(listener);
			
		}
			
		public String getEnterGrade1() {
			return enterGrade1.getText();
		}
		public void setEnterGrade1(JTextField enterGrade1) {
			this.enterGrade1 = enterGrade1;
		}


}




