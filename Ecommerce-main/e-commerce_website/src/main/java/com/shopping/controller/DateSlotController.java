package com.shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.shopping.Entities.DateSlot;
import com.shopping.service.DateSlotService;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class DateSlotController {
	
	@Autowired
	private DateSlotService dateSlotService;
	
	@PostMapping("/createDateSlot")
	ResponseEntity<DateSlot> createDateSlot(@RequestBody DateSlot dateSlot )
	{
		return new ResponseEntity<DateSlot>(dateSlotService.createDateSlot(dateSlot),HttpStatus.CREATED);
	}

}
