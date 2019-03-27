package dao;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;



public abstract class AbstractDAO<T> {
	protected static final Logger LOGGER = Logger.getLogger(AbstractDAO.class.getName());

	private final Class<T> type;

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		this.type = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

	}

	private String createSelectQuery(String field) {
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
	}
	
	
	
	
	
	public T findById(int id) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createSelectQuery(type.getDeclaredFields()[0].getName());
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			resultSet = statement.executeQuery();

			return createObjects(resultSet).get(0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, type.getName() + "DAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}

	private String createFindAllQuery()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("SELECT ");
		sb.append(" * ");
		sb.append(" FROM ");
		sb.append(type.getSimpleName());
		return sb.toString();
	}

	private String createDeleteQuery(String field)
	{
		StringBuilder sb=new StringBuilder();
		sb.append("DELETE FROM ");
		sb.append(type.getSimpleName());
		sb.append(" WHERE " + field + " =?");
		return sb.toString();
		
	}
	
	
	
	
	
	public List<T> findAll() {
		// TODO:
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createFindAllQuery();
		List<T> list = new ArrayList<T>();

		
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			resultSet = statement.executeQuery();
			try {
				while (resultSet.next()) {
					T instance = type.newInstance();
					for (Field field : type.getDeclaredFields()) {
						Object value = resultSet.getObject(field.getName());
						PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
						Method method = propertyDescriptor.getWriteMethod();
						method.invoke(instance, value);
					}
					list.add(instance);
				}
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (IntrospectionException e) {
				e.printStackTrace();
			}

			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, " ERROR FIND ALL ");
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return list;
		
	}
	public String createInsertQuery()
	{
		StringBuilder sb=new StringBuilder();
		sb.append("INSERT INTO ");
		sb.append(type.getSimpleName());
		sb.append(" (");
		int i=0;
		for (Field field : type.getDeclaredFields()) {
			if (i==type.getDeclaredFields().length-1) { sb.append(field.getName()); break; }
			i++;
			sb.append(field.getName() + ",");
			
		}
		
		sb.append(") ");
		sb.append("VALUES");
		sb.append( " (" );
		for (i=0;i<type.getDeclaredFields().length-1;i++)
		{
			sb.append("?,");
		}
		sb.append("?");
		sb.append(")");
		return sb.toString();
		
	}
	public T delete(int id) 
	{
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		String query = createDeleteQuery(type.getDeclaredFields()[0].getName());
		try {
				
			
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			statement.executeUpdate();
			
			
		
		}
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
			e.printStackTrace();
			LOGGER.log(Level.WARNING,"ERROR DELETE");
		} finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		return null;
	}
	
	public T insert(T t) {
		// TODO:
		Connection connection = null;
		PreparedStatement statement = null;
		
		String query = createInsertQuery();
		System.out.println(query);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			int i=1;
			for (Field field : type.getDeclaredFields()) {
				field.setAccessible(true);
				Object toBeInserted =field.get(t);
			 statement.setString(i, toBeInserted.toString());
				i++;
				
			}
			//resultSet=statement.getGeneratedKeys();
			statement.executeUpdate();
			
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ERROR INSERT");
		}
		catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
	
		return t;
		
	}
	
	public List<T> createObjects(ResultSet resultSet) {
		List<T> list = new ArrayList<T>();

		try {
			while (resultSet.next()) {
				T instance = type.newInstance();
				for (Field field : type.getDeclaredFields()) {
					Object value = resultSet.getObject(field.getName());
					PropertyDescriptor propertyDescriptor = new PropertyDescriptor(field.getName(), type);
					Method method = propertyDescriptor.getWriteMethod();
					method.invoke(instance, value);
				}
				list.add(instance);
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}
		return list;
	}

	public String createEditQuery(String f)
	{
		StringBuilder sb=new StringBuilder();
		sb.append("UPDATE  ");
		sb.append(type.getSimpleName());
		sb.append(" SET ");
		int i=0;
		for (Field field : type.getDeclaredFields()) {
			if (i==type.getDeclaredFields().length-1) { sb.append(field.getName()+"=?"); break; }
			i++;
			sb.append(field.getName() + "=?,");
			
		}
		
		
		
		sb.append(" WHERE " + f + " =?");
		return sb.toString();
		
	}
	

	public T update(int id, T t) {
		// TODO:
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		String query = createEditQuery(type.getDeclaredFields()[0].getName());
		System.out.println(query);
		try {
			connection = ConnectionFactory.getConnection();
			statement = connection.prepareStatement(query);
			int i=1;
			for (Field field : type.getDeclaredFields()) {
				field.setAccessible(true);
				Object value = field.get(t);
				statement.setString(i, value.toString());
				i++;
			}
			statement.setInt(i, id);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ERROR UPDATE");
		}catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			ConnectionFactory.close(resultSet);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(connection);
		}
		
		return t;
	
	}
}
