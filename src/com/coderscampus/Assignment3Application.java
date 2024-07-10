package com.coderscampus;

import java.io.IOException;

public class Assignment3Application {

    public static void main(String[] args) throws IOException {
    	
        FileService fileService = new FileService();
        User[] users = fileService.getUserInfo("data.txt");

        UserService userService = new UserService();
        userService.users = users;
        
        userService.login();
    }
}