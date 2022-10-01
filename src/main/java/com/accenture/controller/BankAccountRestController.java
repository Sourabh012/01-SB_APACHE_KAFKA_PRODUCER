package com.accenture.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.accenture.entity.BankAccountDetails;
import com.accenture.service.BankAccountService;

@RestController
public class BankAccountRestController {
	
	@Autowired
	private BankAccountService bankAccountService;
	
	@PostMapping("/newdetails")
	public ResponseEntity<String>NewAccountDetails(@RequestBody BankAccountDetails bankAccountDetails)
	{
		String responseMsg = null; 
		
		String details = bankAccountService.addDetails(bankAccountDetails);
		
		return new ResponseEntity<>(responseMsg,HttpStatus.CREATED);
	}

}
