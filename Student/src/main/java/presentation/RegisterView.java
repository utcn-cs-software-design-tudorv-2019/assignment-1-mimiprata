package presentation;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegisterView extends JFrame {

	private JLabel name;
	private JLabel cnp;
	private JLabel address;
	private JLabel idgroup;
	private JLabel email;
	private JLabel password;
	 JTextField emailT;
	 JTextField passwordT;
	 JTextField cnpT;
	 JTextField addressT;
	 JTextField idgroupT;
	 JTextField nameT;
	JButton register;
	ControllerRegister controllerregister;
	  JPanel panel;
	private LoginView loginview;
	private LoginView viewLogin;
	 JLabel idstudent;
	 JTextField idstudentT;
	 public RegisterView()
	   {
		 controllerregister=new ControllerRegister(this);
		 email = new JLabel("Email:");
		 password = new JLabel("Password:");
		 emailT= new JTextField(3);
		 passwordT = new JTextField(3);
		 name = new JLabel("Name:");
		 cnp = new JLabel("Cnp:");
		 address = new JLabel("Address:");
		 idgroup= new JLabel("Group:");
		 nameT = new JTextField(3);
		 cnpT=new JTextField(3);
		 addressT= new JTextField(3);
		 idgroupT= new JTextField(3);
		 idstudent=new JLabel("Id:");
		 idstudentT=new JTextField(3);
		 register = new JButton("Register");
		
		  panel=new JPanel(new GridLayout(4,5));
		   panel.add(idstudent);
		   panel.add(idstudentT);
		   panel.add(name);
		   panel.add(nameT);
		   panel.add(cnp);
		   panel.add(cnpT);
		   panel.add(address);
		   panel.add(addressT);
		   panel.add(idgroup);
		   panel.add(idgroupT);
		   panel.add(email);
		   panel.add(emailT);
		   panel.add(password);
		   panel.add(passwordT);
		   panel.add(register);
		   add(panel,BorderLayout.CENTER);
		   
		   register.addActionListener(controllerregister);
		  
		   setTitle("REGISTER FORM");
		   this.setSize(400,150);
		   this.setVisible(true);
		   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   }
	 public void setLoginView() {
			// TODO Auto-generated method stub
		 
			viewLogin = new LoginView();
			//viewInsert.addBtnListener(listener);
			
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
	public void setPasswordT(JTextField passwordT) {
		this.passwordT = passwordT;
	}
	public String getCnpT() {
		return cnpT.getText();
	}
	public void setCnpT(JTextField cnpT) {
		this.cnpT = cnpT;
	}
	public String getAddressT() {
		return addressT.getText();
	}
	public void setAddressT(JTextField addressT) {
		this.addressT = addressT;
	}
	public int getIdgroupT() {
		return Integer.parseInt(idgroupT.getText());
	}
	public void setIdgroupT(JTextField idgroupT) {
		this.idgroupT = idgroupT;
	}
	public String getNameT() {
		return nameT.getText();
	}
	public void setNameT(JTextField nameT) {
		this.nameT = nameT;
	}
	public int getIdstudentT() {
		return Integer.parseInt(idstudentT.getText());
	}
	public void setIdstudentT(JTextField idstudentT) {
		this.idstudentT = idstudentT;
	}
	
}
