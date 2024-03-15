package com.coderscampus;

import java.util.Scanner;

public class UserService {

	User[] users = new User[10];
	int userLoginLeft = 5;

	public void pleaseLogin() {

		Scanner scanner = new Scanner(System.in);
		
		int userLoginAttempts = 0;
		while (userLoginAttempts < 5) {
			// prompt for username and password
			System.out.println("Enter email:");
			String userLogin = scanner.nextLine();
			System.out.println("Enter password:");
			String userPassword = scanner.nextLine();
			User personLogged = userValidation(userLogin, userPassword);
			if (personLogged != null) {
				System.out.println("Welcome " + personLogged.getName() +"!");
				break;
			} else {
				System.out.println("Invalid login, please try again");
			}
			userLoginAttempts++;
		}
		
		if (userLoginAttempts >= 5) {
			System.out.println("Too many failed login attempts, you are now locked out.");
		}
		scanner.close();
	}

	public User userValidation(String username, String password) {
		for (User user : users) {
	        if (user != null && user.getUsername().equalsIgnoreCase(username) && user.getPassword().equals(password)) {
	            return user;
			}
		}
		return null;
	}
}