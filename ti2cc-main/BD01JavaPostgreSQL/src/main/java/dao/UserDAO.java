package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO extends DAO {
	
	public UserDAO() {
		super();
		connect();
	}

	public void finalize() {
		close();
	}
	
	
	public boolean insert(User user) {
		boolean status = false;
		try {  
			Statement st = connection.createStatement();
			String sql = "INSERT INTO user (code, login, password, gender) "
				       + "VALUES ("+user.getCode()+ ", '" + user.getLogin() + "', '"  
				       + user.getPassword() + "', '" + user.getGender() + "');";
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}

	
	public User get(int code) {
		User user = null;
		
		try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM product WHERE id=" + code;
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	
	        if(rs.next()){            
	        	 user = new User(rs.getInt("code"), rs.getString("login"), rs.getString("password"), rs.getString("gender").charAt(0));
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return user;
	}
	
	
	public List<User> get() {
		return get("");
	}

	
	public List<User> getOrderByCode() {
		return get("code");		
	}
	
	
	public List<User> getOrderByLogin() {
		return get("login");		
	}
	
	
	public List<User> getOrderByGender() {
		return get("gender");		
	}
	
	
	private List<User> get(String orderBy) {	
	
		List<User> users = new ArrayList<User>();
		
		try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM user" + ((orderBy.trim().length() == 0) ? "" : (" ORDER BY " + orderBy));
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	User u = new User(rs.getInt("code"), rs.getString("login"), rs.getString("password"), rs.getString("gender").charAt(0));
	            users.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return users;
	}


	public List<User> getMaleGender() {
		List<User> users = new ArrayList<User>();
		
		try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM user WHERE user.gender LIKE 'M'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);	           
	        while(rs.next()) {	            	
	        	User u = new User(rs.getInt("code"), rs.getString("login"), rs.getString("password"), rs.getString("gender").charAt(0));
	            users.add(u);
	        }
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return users;
	}
	
	
	public boolean update(User user) {
		boolean status = false;
		try {  
			Statement st = connection.createStatement();
			String sql = "UPDATE user SET login = '" + user.getLogin() + "', password = '"  
				       + user.getPassword() + "', gender = '" + user.getGender() + "'"
					   + " WHERE code = " + user.getCode();
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int code) {
		boolean status = false;
		try {  
			Statement st = connection.createStatement();
			String sql = "DELETE FROM user WHERE code = " + code;
			System.out.println(sql);
			st.executeUpdate(sql);
			st.close();
			status = true;
		} catch (SQLException u) {  
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean authenticate(String login, String password) {
		boolean response = false;
		
		try {
			Statement st = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			String sql = "SELECT * FROM user WHERE login LIKE '" + login + "' AND password LIKE '" + password  + "'";
			System.out.println(sql);
			ResultSet rs = st.executeQuery(sql);
			response = rs.next();
	        st.close();
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return response;
	}	
}
