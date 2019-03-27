package presentation;

import java.awt.BorderLayout;
import java.util.List;
import java.lang.reflect.Field;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import bll.CourseBLL;
import bll.TeacherBLL;
import model.CourseTableModel;
import model.StudentTableModel;
import model.Teacher;
import model.Course;
import model.TeacherTableModel;

public class CourseView extends JFrame{
	private  ControllerCourse controllercourse;
	private JLabel textt;
	 JButton mycourses;
	
	
	private JTextField name1;
	
	JTable table;
	private JTable table1;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane1;
	private CourseTableModel tableC;
	private TeacherTableModel tableT;
	JButton logout;
	JButton enrol;
	private CourseBLL courseBLL;
	private TeacherBLL teacherBLL;
	
	
	public CourseView(int id)
	{
		
		 table=new JTable();
		 table1=new JTable();
		 scrollPane= new JScrollPane();
		 scrollPane1 = new JScrollPane();
		controllercourse=new ControllerCourse(this,id);
		tableC=new CourseTableModel();
		tableT=new TeacherTableModel();
		courseBLL = new CourseBLL();
		teacherBLL = new TeacherBLL();
		textt=new JLabel("Pick a course!");
		enrol=new JButton("Enrol!");
		mycourses=new JButton("My Courses");
		logout=new JButton("Logout");
		
		JTable table=new JTable();
		
		 table=tableC.teacherTable(teacherBLL.showTeachers());
		 
		 this.setTable(table);
		
		
		this.setTitle("Enrol");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);

		
		
		JPanel panel2=new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		
		panel2.add(textt);
		panel2.add(enrol);
		panel2.add(mycourses);
		panel2.add(logout);
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout(0, 0));

		tablePanel.add(scrollPane);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		this.add(panel3);
		panel3.add(panel2);
		panel3.add(tablePanel);
		this.setVisible(true);
		
		enrol.addActionListener(controllercourse);
		mycourses.addActionListener(controllercourse);
		logout.addActionListener(controllercourse);
		
	}
	
	public void setTable(JTable newTable) {
		this.table = newTable;
	System.out.println("----"+table.getColumnName(1));
		
		scrollPane.setViewportView(table);
		repaint();
		revalidate();
	}
	
	
	
	 
	
	
}
