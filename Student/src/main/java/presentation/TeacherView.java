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

import bll.StudentBLL;
import model.StudentTableModel;


public class TeacherView extends JFrame {


	private StudentBLL studentBLL;
	private StudentTableModel tableC;
	private JLabel id;
	private JLabel name;
	private JLabel adress;
	private JLabel email;
	private JLabel cnp ;
	private JLabel password ;
	private JLabel idgroup ;



	ControllerTeacher controllerteacher ;
	private JTextField id1;
	private JTextField name1;
	private JTextField adress1;
	private JTextField email1;
	private JTextField cnp1;
	private JTextField password1;
	private JTextField idgroup1;
	JTable table;
	private JScrollPane scrollPane;
	JButton insereaza;
	JButton v;
	JButton sterge;
	JButton update;
	JButton back;
	public TeacherView()
	{
		controllerteacher=new ControllerTeacher(this);
		id=new JLabel("Id:");
		name=new JLabel("Name:");
		adress=new JLabel("Address:");
		email=new JLabel("Email:");
		cnp = new JLabel("Cnp:");
		password = new JLabel("Password:");
		idgroup  = new JLabel("IdGroup:");
		tableC=new StudentTableModel();
		studentBLL= new StudentBLL();
		id1=new JTextField(1);
		name1=new JTextField(3);
		adress1=new JTextField(3);
		email1=new JTextField(3);
		password1=new JTextField(3);
		idgroup1=new JTextField(3);
		cnp1= new JTextField(3);
		table=new JTable();
		scrollPane=new JScrollPane();
		insereaza=new JButton("Insert");
		v=new JButton("View");
		sterge=new JButton("Delete");
		update=new JButton("Edit");
		back=new JButton("Back");
		JTable x=tableC.createTable(studentBLL.findAll());
		this.setTable(x);
		this.setTitle("StudentOp");

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500,500);

		JPanel panel1=new JPanel();
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		// panel1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add( Box.createRigidArea(new Dimension(2,2)) );
		id.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(id);
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		id1.setAlignmentX(Component.CENTER_ALIGNMENT);
		id1.setMaximumSize(new Dimension(60, 20));
		panel1.add(id1);
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		name.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(name);
		panel1.add( Box.createRigidArea(new Dimension(10,5)) );
		name1.setMaximumSize(new Dimension(145, 20));
		name1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(name1);
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		cnp.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(cnp);
		panel1.add( Box.createRigidArea(new Dimension(10,5)) );
		cnp1.setMaximumSize(new Dimension(145, 20));
		cnp1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(cnp1);
		//address
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		adress.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(adress);
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		adress1.setAlignmentX(Component.CENTER_ALIGNMENT);
		adress1.setMaximumSize(new Dimension(150, 20));
		panel1.add(adress1);
		//email
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		email.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(email);
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		email1.setAlignmentX(Component.CENTER_ALIGNMENT);
		email1.setMaximumSize(new Dimension(150, 20));
		panel1.add(email1);
		//password
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		password.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(password);
		panel1.add( Box.createRigidArea(new Dimension(10,5)) );
		password1.setMaximumSize(new Dimension(145, 20));
		password1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(password1);

		//idgroup
		panel1.add( Box.createRigidArea(new Dimension(5,5)) );
		idgroup.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(idgroup);
		panel1.add( Box.createRigidArea(new Dimension(10,5)) );
		idgroup1.setMaximumSize(new Dimension(145, 20));
		idgroup1.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel1.add(idgroup1);
		

		panel1.setPreferredSize(new Dimension(150, 500));
		panel1.setMaximumSize(new Dimension(150, 500));


		
		JPanel panel2=new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.Y_AXIS));
		panel2.add(v);
		panel2.add(panel1);
		panel2.add(insereaza) ;
		panel2.add(sterge);
		panel2.add(update);
		panel2.add(back);
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BorderLayout(0, 0));

		tablePanel.add(scrollPane);
		JPanel panel3 = new JPanel();
		panel3.setLayout(new BoxLayout(panel3, BoxLayout.X_AXIS));
		this.add(panel3);
		panel3.add(panel2);
		panel3.add(tablePanel);
		this.setVisible(true);
		v.addActionListener(controllerteacher);
		insereaza.addActionListener(controllerteacher);
		sterge.addActionListener(controllerteacher);
		update.addActionListener(controllerteacher);
		back.addActionListener(controllerteacher);

	}

	public int getId1() {
		return Integer.parseInt(id1.getText());
	}
	public void setId1(JTextField id1) {
		this.id1 = id1;
	}
	public String getName1() {
		return name1.getText();
	}

	public String getAdress1() {
		return adress1.getText();
	}

	public String getEmail1() {
		return email1.getText();
	}
	public int getIdgroup1() {
		return Integer.parseInt(idgroup1.getText());
	}
	public void setIdgroup1(JTextField idgroup1) {
		this.idgroup1 = idgroup1;
	}
	public String getCnp1() {
		return cnp1.getText();
	}
	public void setCnp1(JTextField cnp1) {
		this.cnp1 = cnp1;
	}
	public String getPassword1() {
		return password1.getText();
	}
	public void setPassword1(JTextField password1) {
		this.password1 = password1;
	}
	public void setTable(JTable newTable) {
		this.table = newTable;
		System.out.println("----"+table.getColumnName(1));

		scrollPane.setViewportView(table);
		repaint();
		revalidate();
	}

}
