package presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.Box;
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
import bll.StudentBLL;
import bll.TeacherBLL;
import model.Course;
import model.CourseTableModel;
import model.Teacher;

public class TeacherOpView extends JFrame{
	
	private JTable table;
	private JScrollPane scrollPane;
	private JLabel enterDate;
	private JLabel enterGrade;
	 JTextField enterDate1;
	 JTextField enterGrade1;
	JButton manageStudents;
	JButton reports;
	JButton setGrade;
	JButton setDate;
	JButton view;
	ControllerTeacherOp controllerteacherop ;
	private TeacherBLL teacherBLL;
	private StudentBLL studentBLL;
	private CourseTableModel tableC;
	private CourseBLL courseBLL;
	private TeacherView viewTeacher;
	private GradeView viewGrade;
	JButton back;
	private ReportView viewReport;
	
	public TeacherOpView(int id)
	{
		controllerteacherop=new ControllerTeacherOp(this,id);
		scrollPane=new JScrollPane();
		tableC=new CourseTableModel();
		courseBLL = new CourseBLL();
		teacherBLL = new TeacherBLL();
		studentBLL=new StudentBLL();
		manageStudents = new JButton("Manage Students");
		reports = new JButton("GetReports");
		setDate=new JButton("SetDate");
		setGrade=new JButton("SetGrade");
		view=new JButton("View");
		back=new JButton("Logout");
		enterDate = new JLabel("Enter date:");
		enterGrade1= new JTextField(3);
		enterDate1 = new JTextField(3);
		JPanel panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.add(view);
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		enterDate.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(enterDate);
		panel1.add( Box.createRigidArea(new Dimension(10,5)) );
		enterDate1.setMaximumSize(new Dimension(145, 20));
		enterDate1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(enterDate1);
		panel1.add(setDate);
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		
		panel1.add(setGrade);
		//buttons
		panel1.add(manageStudents);
		panel1.add(reports) ;
		panel1.add(back);
		//tables
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout(0, 0));

		tablePanel.add(scrollPane);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		this.add(panel3);
		panel3.add(panel1);
		panel3.add(tablePanel);
		manageStudents.addActionListener(controllerteacherop);
		reports.addActionListener(controllerteacherop);
		setDate.addActionListener(controllerteacherop);
		setGrade.addActionListener(controllerteacherop);
		view.addActionListener(controllerteacherop);
		back.addActionListener(controllerteacherop);
		JTable x =new JTable();
		x.setModel(courseBLL.tableCourse(id));
		this.setTable(x);
		
	
		this.setTitle("TeacherOp");
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
	public void setTeacherView() {
		// TODO Auto-generated method stub
		viewTeacher = new TeacherView();
		//viewInsert.addBtnListener(listener);
		
	}
	public void setGradeView(int id) {
		// TODO Auto-generated method stub
		viewGrade = new GradeView(id);
		//viewInsert.addBtnListener(listener);
		
	}
	public Date getEnterDate1() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "yyyy-MM-dd" );
		
		LocalDate localDate = LocalDate.parse(enterDate1.getText() , formatter );
		
		java.sql.Date sqlDate = java.sql.Date.valueOf( localDate );
		return sqlDate;
	}
	public void setEnterDate1(JTextField enterDate1) {
		this.enterDate1 = enterDate1;
	}
	public String getEnterGrade1() {
		return enterGrade1.getText();
	}
	public void setEnterGrade1(JTextField enterGrade1) {
		this.enterGrade1 = enterGrade1;
	}
	public void setReportView(int id) {
		// TODO Auto-generated method stub
		viewReport = new ReportView(id);
	}

}
