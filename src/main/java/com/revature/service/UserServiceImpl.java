package com.revature.service;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.repository.UserRepository;
import com.revature.model.User;
import com.revature.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepo;
	
	@Override
	public User findByMobile(String mobile) throws Exception {
		return userRepo.findByMobile(mobile).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public User getUserDetailById(long userId) throws Exception {
		
		return userRepo.findById(userId).orElseThrow(()->new Exception("User Not found.."));
	}

	@Override
	public User signUpUser(HashMap<String, String> signupRequest) throws Exception {
		
			if(userRepo.findByMobile(signupRequest.get("mobile")).isPresent()) {
				throw new Exception("User is already registered with Mobile No.");
			}
			User user = new User();
			System.out.println("Given name is " + signupRequest.get("user_name"));
			user.setName(signupRequest.get("user_name"));
			user.setEmail(signupRequest.get("email"));
			user.setMobile(signupRequest.get("mobile"));
			user.setPassword(signupRequest.get("password"));
			userRepo.save(user);
			return user;
		
		
	}

	@Override
	public User findByEmail(String email) throws Exception {
		return userRepo.findByMobile(email).orElseThrow(() -> new Exception("User Not found.."));
	}
	@Override
	public User forgot(HashMap<String, String> forgotRequest) throws Exception {
		
		User user = new User();
		user =userRepo.findByEmail(forgotRequest.get("resetemail"));
		return user;
	}
}
