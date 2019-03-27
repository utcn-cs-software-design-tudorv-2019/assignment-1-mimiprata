package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import bll.StudentBLL;
import bll.TeacherBLL;

public class ControllerLogin implements ActionListener {
	private LoginView view;
	private TeacherBLL teacherBLL= new TeacherBLL();
	private StudentBLL studentBLL= new StudentBLL();
	public ControllerLogin(LoginView v){
		this.view = v;

	}
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String value = (String) view.cb.getSelectedItem();
		Object source = e.getSource();
		if(source == view.login) {
		
			String pass1= view.getPasswordT();
			
			
			if (value.equals("Student")){
				String pass2 = studentBLL.findpassword(view.getEmailT());
				if (pass1.equals(pass2)){
					int id = studentBLL.findId(view.getEmailT());
				view.dispose();
				 view.setStudentView(id);
			}
			}
			if (value.equals("Teacher")) {
				String pass2 = teacherBLL.findpassword(view.getEmailT());
				
				if (pass1.equals(pass2)){
					
					int id = teacherBLL.findId(view.getEmailT());
					System.out.println(id);
					view.dispose();
					view.setTeacherOpView(id);
			}
	}


}
		if (source== view.register)
		{
			if (value.contentEquals("Student"))
			{
			view.setRegisterView();
			}
			else  JOptionPane.showMessageDialog(null,"Please register as student!", null,
					JOptionPane.ERROR_MESSAGE);  
			}
	}
	}

