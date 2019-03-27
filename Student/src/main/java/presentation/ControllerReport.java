package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.TableModel;

import bll.CourseBLL;
import bll.TeacherBLL;
import model.CourseTableModel;

public class ControllerReport implements ActionListener{
	private ReportView view;
	private int id;
	private TeacherBLL teacherBLL;
	private CourseTableModel tableC;
	private CourseBLL courseBLL;
	private FileWriter fw = null;
	private BufferedWriter bw = null;
	
	public ControllerReport(ReportView v,int id){
		this.view = v;
		this.id = id;
		teacherBLL=new TeacherBLL();
		courseBLL=new CourseBLL();
		tableC=new CourseTableModel();
	}
	public void actionPerformed(ActionEvent e) {
		
		// TODO Auto-generated method stub
		Object source = e.getSource();
		if (source == view.back)
		{
			view.dispose();
		}
		if(source == view.mystudents )
		{
		
		
		TableModel c=courseBLL.tableGrade(id);
		JTable table=new JTable();
		table.setModel(c);
		view.setTable(table);
		
		StringBuffer sbTableData = new StringBuffer();
		for(int row = 0; row < table.getRowCount(); row ++){
		    for(int column = 0; column < table.getColumnCount(); column ++){
		        sbTableData.append(table.getValueAt(row, column)).append("\t");
		    }
			sbTableData.append(System.getProperty("line.separator"));
		    
		}
		try {
			fw = new FileWriter("Students" + id+"_p" + ".txt");
			bw = new BufferedWriter(fw);
			bw.write(sbTableData.toString());
			bw.flush();
		}catch(IOException e1){
			e1.printStackTrace();
	}
		

	
	
		}
		if(source==view.studentsgroup)
		{
			int id1 =view.getIdgroup1();
			TableModel c=teacherBLL.tableGroup(id1);
			JTable table=new JTable();
			table.setModel(c);
			view.setTable(table);	
			StringBuffer sbTableData = new StringBuffer();
			for(int row = 0; row < table.getRowCount(); row ++){
			    for(int column = 0; column < table.getColumnCount(); column ++){
			        sbTableData.append(table.getValueAt(row, column)).append("\t");
			    }
				sbTableData.append(System.getProperty("line.separator"));
			    
			}
		
		try {
			fw = new FileWriter("Students_" + id1+"_p" + ".txt");
			bw = new BufferedWriter(fw);
			bw.write(sbTableData.toString());
			bw.flush();
		}catch(IOException e1){
			e1.printStackTrace();
	}
		}
	}
}

