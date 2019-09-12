package com.example.inet.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.inet.model.Member;

@RestController
public class AppController {
 
	@Value("${message.welcome}")
	private String stringValue;
	
	@PostMapping(path = "/api/member")
	public ResponseEntity<?> getMember(@RequestBody Member member){
		Member responseMember = new Member();
		
		if (member.getUserID().equals("1") || member.getUserName().equals("pragasit") ){			
			responseMember.setUserID("1");
			responseMember.setUserName("pragasit");
			responseMember.setUserPassword("1234");
			responseMember.setResponseStatus("Success");
		}
		else {
			responseMember.setUserID("");
			responseMember.setUserName("");
			responseMember.setUserPassword("");
			responseMember.setResponseStatus("Fail");
		}
		
		return ResponseEntity.ok(responseMember);
	}
	
	@GetMapping(path = "/api/config")
	public ResponseEntity<?> getConfig(){			
		return ResponseEntity.ok(stringValue);
	}
}
