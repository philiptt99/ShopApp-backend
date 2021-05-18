package com.revature.controller;

import java.util.HashMap;
import java.util.Properties;
import java.io.IOException;

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

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.Authenticator;


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
	
	@RequestMapping("resetemail") // post and get
	public ResponseEntity<?> reset(@RequestBody HashMap<String, String> forgotRequest) throws Exception {
		User user = userservice.forgot(forgotRequest);
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("drstrange231294@gmail.com", "test@1234");
			}
		});
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress("drstrange231294@gmail.com", false));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(forgotRequest.get("resetemail")));
		msg.setSubject("Forgotten Password");
		msg.setContent("This is your forgot password"+user.getPassword(), "text/html");
		
		MimeBodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setContent("Hello "+user.getName()+"!!<br> This is your password: "+user.getPassword() +"<br> Username is: "+user.getMobile(), "text/html");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		msg.setContent(multipart);
		Transport.send(msg);
		return new ResponseEntity<>(new ApiResponse("Server is running.", ""), HttpStatus.OK);
	}
	
	

}