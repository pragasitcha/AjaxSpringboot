package com.example.inet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.inet.model.Member;

@RestController
public class AppController {
 
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
}
