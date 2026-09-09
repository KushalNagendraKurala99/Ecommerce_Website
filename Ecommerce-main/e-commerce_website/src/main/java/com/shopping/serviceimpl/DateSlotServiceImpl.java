package com.shopping.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shopping.Entities.DateSlot;
import com.shopping.repositories.DateSlotRepository;
import com.shopping.service.DateSlotService;

@Service
public class DateSlotServiceImpl implements DateSlotService {
	
	@Autowired
	private DateSlotRepository dateSlotRepository; 

	@Override
	public DateSlot createDateSlot(DateSlot dateSlot) {
		
		return dateSlotRepository.save(dateSlot);
	}

}
