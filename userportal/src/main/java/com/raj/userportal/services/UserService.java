package com.raj.userportal.services;

import com.raj.userportal.model.LoginModel;
import com.raj.userportal.model.UserModel;
import com.raj.userportal.payloadResponse.LoginMessage;

public interface UserService {
	String saveUser(UserModel userModel);

	LoginMessage loginUser(LoginModel loginModel);

}
