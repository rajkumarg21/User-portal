package com.raj.userportal.servicesImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.raj.userportal.entities.User;
import com.raj.userportal.model.LoginModel;
import com.raj.userportal.model.UserModel;
import com.raj.userportal.payloadResponse.LoginMessage;
import com.raj.userportal.repositories.UserRepository;
import com.raj.userportal.services.UserService;

/*
 * Authore : Rajkumar Saad
*/

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserRepository userRepository;

	@Override
	public String saveUser(UserModel userModel) {
		User user = new User(userModel.getId(), userModel.getUserName(),
				this.passwordEncoder.encode(userModel.getPassword()), userModel.getMobileNo(), userModel.getEmail()

		);
		userRepository.save(user);
		return user.getUserName();
	}

	@Override
	public LoginMessage loginUser(LoginModel loginModel) {
		String msg = "";
		User user1 = userRepository.findByEmail(loginModel.getEmail());
		if (user1 != null) {
			String password = loginModel.getPassword();

			String encodedPassword = user1.getPassword();

			boolean isPwdRight = passwordEncoder.matches(password, encodedPassword);
			if (isPwdRight) {
				Optional<User> user = userRepository.findOneByEmailAndPassword(loginModel.getEmail(), encodedPassword);
				if (user.isPresent()) {
					return new LoginMessage("Login Success", true);

				} else {
					return new LoginMessage("Login Failed", false);

				}

			} else {
				return new LoginMessage("password Not  Matched", false);
			}
		} else {
			return new LoginMessage("Email Not Exist", false);
		}

	}

}
