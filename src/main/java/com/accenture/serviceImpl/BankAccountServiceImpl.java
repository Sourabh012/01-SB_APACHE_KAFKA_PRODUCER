package com.accenture.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import com.accenture.entity.BankAccountDetails;
import com.accenture.service.BankAccountService;
import com.accenture.util.KafkaConstants;


@Service
public class BankAccountServiceImpl implements BankAccountService {

	@Autowired
	private KafkaTemplate<String, BankAccountDetails> kafkaTemplate;
	
	
	@Override
	public String addDetails(BankAccountDetails bankAccountDetails) {
		// TODO Auto-generated method stub
		if(!bankAccountDetails.equals(null))
		{
		 kafkaTemplate.send(KafkaConstants.TOPIC,bankAccountDetails);
		 System.out.println("done success");
		 return "successfully added";
		}
		 System.out.println("not done");
		return "unable to process";
	}

}
