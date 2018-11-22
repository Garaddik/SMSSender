package com.sms.smsapp;

import com.fasterxml.jackson.databind.util.JSONPObject;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class SMSController {


	@GetMapping("/smssend/{number}")
	public Response smsSend(@PathVariable(name="") String number){

		RestTemplate template = new RestTemplate();


		String key = "248683AgvolPse5bf7b914";

		int otp = this.getRandomNumber(100000,999999);

		String message = "Your verification code is " + otp;

		
		String path = "http://api.msg91.com/api/sendhttp.php?&sender=MSG-ASH&route=4&mobiles="+number+"&authkey="+key+"&message="+message;

		template.getForEntity(path, null);

		Response resp = new Response();

		resp.setMessage("Sucess");

		return resp;
	}

	public int getRandomNumber(int min, int max) {
		return (int) Math.floor(Math.random() * (max - min + 1)) + min;
	}
}

class Response{

	private String message;


	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

