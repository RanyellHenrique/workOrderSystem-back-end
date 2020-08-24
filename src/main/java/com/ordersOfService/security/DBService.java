package com.ordersOfService.security;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersOfService.domain.Address;
import com.ordersOfService.domain.Category;
import com.ordersOfService.domain.Client;
import com.ordersOfService.domain.Employee;
import com.ordersOfService.domain.Order;
import com.ordersOfService.domain.OrderItem;
import com.ordersOfService.domain.Payment;
import com.ordersOfService.domain.PaymentByCard;
import com.ordersOfService.domain.PaymentBySlip;
import com.ordersOfService.domain.Product;
import com.ordersOfService.domain.ProductUsed;
import com.ordersOfService.domain.enums.OrderStatus;
import com.ordersOfService.domain.enums.PaymentStatus;
import com.ordersOfService.repositories.AddressRepository;
import com.ordersOfService.repositories.CategoryRepository;
import com.ordersOfService.repositories.ClientRepository;
import com.ordersOfService.repositories.EmployeeRepository;
import com.ordersOfService.repositories.OrderItemRepository;
import com.ordersOfService.repositories.OrderRepository;
import com.ordersOfService.repositories.PaymentRepository;
import com.ordersOfService.repositories.ProductRepository;
import com.ordersOfService.repositories.ProductUsedRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired 
	private OrderRepository orderRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Autowired
	private ProductUsedRepository productUsedRepository;
	
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
		
		Employee em1 = new Employee(null, "Ranyell", "Ranyell@gmail.com", "05187022199", "12345");
		Employee em2 = new Employee(null, "Ronaldo", "ronaldo@gmail.com", "85397833599", "65478");
		
		Client cli1 = new Client(null, "Ranyell", "Abcdee@gmail.com", "05899753210");
		cli1.getPhones().add("3349-7038");
		
		Client cli2 = new Client(null, "Marcos", "Abcdee@gmail.com", "95899753210");
		cli2.getPhones().add("3745-5659");
		
		Address ad1 = new Address(null, "72310422", "DF", "Brasilia", "Samambaia", "305", "conjunto 10", cli1);
		cli1.setAddress(ad1);
		
		Address ad2 = new Address(null, "792058416", "SP", "Campinas", "Centro", "079", "conjunto 25 casa 37", cli2);
		cli2.setAddress(ad2);
		
		employeeRepository.saveAll(Arrays.asList(em1, em2));
		clientRepository.saveAll(Arrays.asList(cli1, cli2));
		addressRepository.saveAll(Arrays.asList(ad1, ad2));
		
		Order or1 = new Order(null, new Date(), new Date(), OrderStatus.OPEN, cli2, em1);
		Order or2 = new Order(null, new Date(), new Date(), OrderStatus.OPEN, cli1, em2);
		Order or3 = new Order(null, new Date(), new Date(), OrderStatus.OPEN, cli2, em2);
		
		Payment pay1 = new PaymentByCard(null , PaymentStatus.SETTLED, 3, or1);
		or1.setPayment(pay1);
		
		Payment pay2 = new PaymentByCard(null , PaymentStatus.PEDING, 4, or2);
		or2.setPayment(pay2);
		
		Payment pay3 = new PaymentBySlip(null, PaymentStatus.CANCELED, or3, new Date(), new Date());
		or3.setPayment(pay3);
		
		orderRepository.saveAll(Arrays.asList(or1, or2, or3));
		paymentRepository.saveAll(Arrays.asList(pay1, pay2, pay3));
		
		OrderItem orIt1 = new OrderItem(null, "Problem.....", p1, or1);
		OrderItem orIt2 = new OrderItem(null, "Problem.....", p3, or2);
		OrderItem orIt3 = new OrderItem(null, "Problem.....", p2, or3);
		
		orderItemRepository.saveAll(Arrays.asList(orIt1, orIt2, orIt3));
		
		ProductUsed proU1 = new ProductUsed(2, 45.37, p1, orIt3);
		ProductUsed proU2 = new ProductUsed(1, 35.80, p2, orIt1);
		ProductUsed proU3 = new ProductUsed(3, 2040.39, p3, orIt2);
		ProductUsed proU4 = new ProductUsed(3, 2040.39, p2, orIt2);
		
		productUsedRepository.saveAll(Arrays.asList(proU1, proU2, proU3, proU4));
		
	}
}
