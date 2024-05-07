package com.raj.userportal.converter;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.raj.userportal.entities.User;
import com.raj.userportal.model.UserModel;

public class ModelConverter {
	private PasswordEncoder passwordEncoder;

	public static User ModelToEntity(UserModel userModel) {
		User user = new User(userModel.getId(), userModel.getUserName(), userModel.getPassword(),
				userModel.getMobileNo(), userModel.getEmail()

		);
		return user;
	}

	// convert entity to DTO/model dao
	public static UserModel EntityToModel(User user) {
		UserModel userModel = new UserModel(user.getId(), user.getUserName(), user.getPassword(), user.getMobileNo(),
				user.getEmail());

		return userModel;
	}

}
