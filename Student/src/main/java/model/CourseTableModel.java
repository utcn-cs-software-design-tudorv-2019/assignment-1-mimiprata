package model;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class CourseTableModel extends AbstractTableModel<Course> {
	

	public JTable teacherTable(List<Teacher> t)
	{
		DefaultTableModel model=new DefaultTableModel(new Object[] {"IdTeacher", "Teacher","Course"},0);
		
		for(Teacher temp1:t) {
			
			model.addRow(new Object[] {temp1.getIdteacher(),temp1.getName(),temp1.getCourseName()});
			}
		
		JTable table=new JTable();
		
		 table.setModel(model);
		 return table;
	}
	

}
