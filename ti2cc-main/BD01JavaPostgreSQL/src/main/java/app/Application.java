package app;

import java.util.List;

import dao.DAO;
import dao.UserDAO;
import model.User;

public class Application {
	
	public static void main(String[] args) throws Exception {
		
		UserDAO userDAO = new UserDAO();
		
		System.out.println("\n\n==== Insert user === ");
		User user = new User(12, "Sir Timothy John Berners-Lee", "1234",'M');
		if(userDAO.insert(user) == true) {
			System.out.println("Insertion successful -> " + user.toString());
		}
		
		System.out.println("\n\n==== Testing authentication ===");
		System.out.println("User (" + user.getLogin() + "): " + userDAO.authenticate("Sir Timothy John Berners-Lee", "1234"));
			
		System.out.println("\n\n==== Show male users === ");
		List<User> users = userDAO.getMaleGender();
		for (User u: users) {
			System.out.println(u.toString());
		}

		System.out.println("\n\n==== Update password (code (" + user.getCode() + ") === ");
		user.setPassword(DAO.toMD5("1234"));
		userDAO.update(user);
		
		System.out.println("\n\n==== Testing authentication ===");
		System.out.println("User (" + user.getLogin() + "): " + userDAO.authenticate("Sir Timothy John Berners-Lee", DAO.toMD5("1234")));		
		
		System.out.println("\n\n==== Attempt SQL Injection ===");
		System.out.println("User (" + user.getLogin() + "): " + userDAO.authenticate("Sir Timothy John Berners-Lee", "x' OR 'x' LIKE 'x"));

		System.out.println("\n\n==== Show users ordered by code === ");
		users = userDAO.getOrderByCode();
		for (User u: users) {
			System.out.println(u.toString());
		}
		
		System.out.println("\n\n==== Delete user (code " + user.getCode() + ") === ");
		userDAO.delete(user.getCode());
		
		System.out.println("\n\n==== Show users ordered by login === ");
		users = userDAO.getOrderByLogin();
		for (User u: users) {
			System.out.println(u.toString());
		}
	}
}
