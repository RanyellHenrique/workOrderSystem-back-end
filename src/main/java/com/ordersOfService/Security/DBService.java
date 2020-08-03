package com.ordersOfService.Security;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersOfService.domain.Category;
import com.ordersOfService.repositories.CategoryRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Eletrônicos");
		Category cat3 = new Category(null, "Impressora");
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));

	}

}
