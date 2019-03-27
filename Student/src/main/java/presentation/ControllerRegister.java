package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import bll.StudentBLL;

public class ControllerRegister implements ActionListener {
	private RegisterView view;
	private StudentBLL studentBLL= new StudentBLL();
	public ControllerRegister(RegisterView v){
		this.view = v;

	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if(source == view.register) {
		studentBLL.buildStudent(view.getIdstudentT(), view.getNameT(), view.getCnpT(), view.getAddressT(), view.getEmailT(), view.getPasswordT(), view.getIdgroupT());
		view.dispose();
		view.setLoginView();
		}
	}

}
