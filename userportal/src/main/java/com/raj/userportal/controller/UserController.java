package com.raj.userportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.raj.userportal.model.LoginModel;
import com.raj.userportal.model.UserModel;
import com.raj.userportal.payloadResponse.LoginMessage;
import com.raj.userportal.services.UserService;

/*
 * Authore : Rajkumar Saad
*/

@RestController
@CrossOrigin
@RequestMapping("api/v1/user")
public class UserController {
	@Autowired
	private UserService userService;

	// save user
	@PostMapping("/save")
	public String saveUser(@RequestBody UserModel userModel) {
		String id = userService.saveUser(userModel);
		return id;

	}

	// login api
	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody LoginModel loginModel) {

		LoginMessage loginMessage = userService.loginUser(loginModel);
		return ResponseEntity.ok(loginMessage);
	}
}
