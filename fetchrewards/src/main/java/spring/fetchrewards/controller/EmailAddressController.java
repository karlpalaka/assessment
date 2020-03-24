package spring.fetchrewards.controller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class EmailAddressController {
	
	@GetMapping("/getUniqueEmailCount")
	public ResponseEntity<String> getUniqueEmailCount(@RequestParam(name="emails") List<String> emails)
	{
		Set<String> emailAddresses = new HashSet<String>();
		for (String email: emails)
		{
			if (email.length() > 10)
			{
				if (email.substring(email.length() - 10, email.length()).equals("@gmail.com"))
				{
					//for + or whitespace in between email username
					if (email.contains(" "))
					{
						System.out.println(email.substring(0, email.indexOf(" ")).replace(".", ""));
						emailAddresses.add(email.substring(0, email.indexOf(" ")).replace(".", ""));
					}
					else
					{
						System.out.println(email.substring(0, email.indexOf("@")).replace(".", ""));
						emailAddresses.add(email.substring(0, email.indexOf("@")).replace(".", ""));
					}
				}
			}	
		}
		
		return new ResponseEntity<String>("Number of unique email addresses is " + emailAddresses.size(), HttpStatus.OK);
	}
}
