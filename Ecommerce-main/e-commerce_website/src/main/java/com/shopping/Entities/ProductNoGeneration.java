package com.shopping.Entities;

import java.io.Serializable;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

public class ProductNoGeneration implements IdentifierGenerator {
	
	public int generateProductId() {
		Random random=new Random();
		return random.nextInt(999999);
	}

	@Override
	public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
		// TODO Auto-generated method stub
		return 556+this.generateProductId();
	}

}
