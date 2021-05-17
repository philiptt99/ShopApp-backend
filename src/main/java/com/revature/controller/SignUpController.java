package com.revature.controller;

import java.util.HashMap;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.controller.RequestPojo.ApiResponse;
import com.revature.model.User;
import com.revature.service.UserService;


@RestController
@RequestMapping("api/signup")
public class SignUpController {
	@Autowired
    UserService userservice;
	@RequestMapping("user")
	public ResponseEntity<?> userLogin(@RequestBody HashMap<String,String> signupRequest) {
		try {
			JSONObject obj = new JSONObject();		
			//validation has to add for client request
			User user = userservice.signUpUser(signupRequest);
			System.out.println(user);
			return  ResponseEntity.ok(user);
		}catch(Exception e ) {
			System.err.println(e.getMessage());
			e.printStackTrace();
			return ResponseEntity.badRequest().body(new ApiResponse(e.getMessage(), ""));
		}
	}

}