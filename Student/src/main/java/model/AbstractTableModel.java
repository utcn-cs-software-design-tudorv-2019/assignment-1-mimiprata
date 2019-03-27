package model;

import java.util.List;

import javax.swing.JTable;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
public abstract class AbstractTableModel<T> {
	private final Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractTableModel() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}
	public JTable createTable(List<T> list) {
		if (list.size() == 0)
			
			return null;
		JTable table = null;
		int numberOfColumns = list.get(0).getClass().getDeclaredFields().length;
		String columns[] = new String[numberOfColumns];
		int i = 0;
		for (Field field : list.get(0).getClass().getDeclaredFields()) {
			columns[i] = field.getName();
			System.out.println(columns[i]);
			i++;
		}
		String data[][] = new String[list.size()][numberOfColumns];
		int row = 0;
		for (Object obj : list) {
			int col = 0;
			for (Field field : obj.getClass().getDeclaredFields()) {
				System.out.println(field.getName());
				field.setAccessible(true);
				Object value;
				try {
					value = field.get(obj);
					//System.out.println(value.toString());
					data[row][col] = value.toString();
					//System.out.println(data[row][col]);
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				col++;
			}
			row++;
		}
		table = new JTable(data,columns);
	
		return table;
	}
	private JTable createTable1(List<Object> objects) {
		if (objects.size() == 0)
			return null;
		JTable table = null;
		int numberOfColumns = objects.get(0).getClass().getDeclaredFields().length;
		String columns[] = new String[numberOfColumns];
		int i = 0;
		for (Field field : objects.get(0).getClass().getDeclaredFields()) {
			columns[i] = field.getName();
			i++;
		}
		String data[][] = new String[objects.size()][numberOfColumns];
		int row = 0;
		for (Object obj : objects) {
			int col = 0;
			for (Field field : obj.getClass().getDeclaredFields()) {
				field.setAccessible(true);
				Object value;
				try {
					value = field.get(obj);
					data[row][col] = value.toString();
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				col++;
			}
			row++;
		}
		table = new JTable(data,columns);
		return table;
	}
	
}
