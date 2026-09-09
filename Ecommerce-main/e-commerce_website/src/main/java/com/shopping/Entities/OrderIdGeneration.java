package com.shopping.Entities;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class OrderIdGeneration implements IdentifierGenerator{
	
	public int genrateOrderId()
	{
		Random random=new Random();
		return random.nextInt(99999);
		
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		
		return 976+this.genrateOrderId();
	}

}
