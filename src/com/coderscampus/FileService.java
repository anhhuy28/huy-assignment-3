package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileService {
	public User[] getUserInfo(String fileName) {
		// read data from data.txt file line by line
		BufferedReader fileReader = null;
		try {
			fileReader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String line;
		User[] users = new User[10];
		int i = 0;
		
		try {
			while ((line = fileReader.readLine()) != null) {
				// split each line into different pieces
				String[] linePieces = line.split(",");
				
				String username = linePieces[0];
				String password = linePieces[1];
				String name = linePieces[2];
				users[i] = new User(username, password, name);
				i++;
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fileReader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return users;
	}

}