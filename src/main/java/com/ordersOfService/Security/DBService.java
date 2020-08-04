package com.ordersOfService.Security;

import java.text.ParseException;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersOfService.domain.Category;
import com.ordersOfService.domain.Product;
import com.ordersOfService.repositories.CategoryRepository;
import com.ordersOfService.repositories.ProductRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Category cat1 = new Category(null, "Informática");
		Category cat2 = new Category(null, "Eletrônicos");
		Category cat3 = new Category(null, "Impressora");
		
		Product p1 = new Product(null, "Computador", 2000.02, 3);
		Product p2 = new Product(null, "Multifuncional HP", 1035.15, 25);
		Product p3 = new Product(null, "Notebook Dell", 3500.02, 8);
		
		cat1.getProducts().addAll(Arrays.asList(p1, p3));
		cat2.getProducts().addAll(Arrays.asList(p1, p2, p3));
		cat3.getProducts().addAll(Arrays.asList(p2));
		
		p1.getCategories().addAll(Arrays.asList(cat1, cat2));
		p2.getCategories().addAll(Arrays.asList(cat2, cat3));
		p3.getCategories().addAll(Arrays.asList(cat1, cat2));
		
		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		productRepository.saveAll(Arrays.asList(p1, p2, p3));

	}

}
