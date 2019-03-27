package presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


public class LoginView extends JFrame {
	private JLabel email;
	private JLabel password;
	 JTextField emailT;
	 JPasswordField passwordT;
	JButton login;
	JButton register;
	String user[]={"Student","Teacher"};        
    JComboBox cb; 
	
	ControllerLogin controllerlogin;
	  JPanel panel;
	private RegisterView viewRegister;
	private StudentView viewStudent;
	private TeacherView viewTeacher;
	private TeacherOpView viewTeacherOp;
	 public LoginView()
	   {
		 controllerlogin=new ControllerLogin(this);
		 email = new JLabel("email");
		 password = new JLabel("password");
		 emailT= new JTextField(3);
		 passwordT = new JPasswordField(3);
		 login = new JButton("Sign in");
		 register = new JButton("Register");
		 cb = new JComboBox(user);   
		 
		  panel=new JPanel(new GridLayout(4,5));
		   panel.add(email);
		   panel.add(emailT);
		   panel.add(password);
		   panel.add(passwordT);
		   panel.add(login);
		   panel.add(register);
		   panel.add(cb);
		   add(panel,BorderLayout.CENTER);
		   login.addActionListener(controllerlogin);
		   register.addActionListener(controllerlogin);
		   cb.addActionListener(controllerlogin);
		   cb.setAlignmentX(Component.CENTER_ALIGNMENT);
		   setTitle("LOGIN FORM");
		   this.setSize(400,150);
		   this.setVisible(true);
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }
	public String getEmailT() {
		return emailT.getText();
	}
	public void setEmailT(JTextField emailT) {
		this.emailT = emailT;
	}
	public String getPasswordT() {
		return passwordT.getText();
	}
	public void setPasswordT(JPasswordField passwordT) {
		this.passwordT = passwordT;
	}
	public void setRegisterView() {
		// TODO Auto-generated method stub
		viewRegister = new RegisterView();
		//viewInsert.addBtnListener(listener);
		
	}
	public void setStudentView(int id) {
		// TODO Auto-generated method stub
		viewStudent = new StudentView(id);
	}
	public void setTeacherOpView(int id) {
		// TODO Auto-generated method stub
		viewTeacherOp = new TeacherOpView(id);
		//viewInsert.addBtnListener(listener);
		
	}
	
	 
}